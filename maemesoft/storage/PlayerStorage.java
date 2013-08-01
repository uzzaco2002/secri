package maemesoft.storage;

//수정일 : 7/10 11:25 (현재 인벤토리 오류 수정중)
//수정일 : 7/31 22:09 (5월 5일자로 갈아엎음)

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import maemesoft.DownloadHelper;
import maemesoft.common.ChatHandler;
import maemesoft.common.EnumPackets;
import maemesoft.common.PacketCreator;
import maemesoft.common.MaemeDataPacket;
import maemesoft.config.MaemeEntityList;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.npcs.EntityTrainer;
import maemesoft.enums.EnumBossMode;
import maemesoft.enums.EnumPokeballs;
import maemesoft.storage.CardManager.CardManagerMode;

public class PlayerStorage {
	public NBTTagCompound[] partyPokemon = new NBTTagCompound[6];
	private static int pokeDollars = 0;
	private static final int carryLimit = 6;
	public EntityPlayerMP player;
	public EntityTrainer trainer;
	public String userName;
	public String saveFile;
	public CardManagerMode mode;
	public boolean guiOpened = false;

	public PlayerStorage(EntityPlayerMP player) {
		this.mode = CardManagerMode.Player;
		this.player = player;
		this.userName = player.username;
		this.saveFile = DownloadHelper.getDir() + "/saves/" + player.worldObj.getSaveHandler().getWorldDirectoryName() + "/pokemon/" + player.username + ".pk";
	}

	public PlayerStorage(EntityTrainer trainer) {
		this.mode = CardManagerMode.Trainer;
		this.trainer = trainer;
	}

	public static int getCurrency() {
		return pokeDollars;
	}

	public static void setCurrency(int par1) {
		pokeDollars = par1;
		if (pokeDollars >= 999999) {
			pokeDollars = 999999;
		}
		if (pokeDollars <= 0) {
			pokeDollars = 0;
		}
	}

	public boolean hasSpace() {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt == null) {
				return true;
			}
		}
		return false;
	}

	public int getNextOpen() {
		for (int i = 0; i < partyPokemon.length; i++) {
			if (partyPokemon[i] == null) {
				return i;
			}
		}
		return 0;
	}

	public void setPokemon(NBTTagCompound[] pokemon) {
		partyPokemon = pokemon;
	}

	public void addToParty(EntityMaeme p) {
		if (!hasSpace()) {
			ChatHandler.sendChat(p.getOwner(), "Your party is full, " + p.getName() + " is sent to your computer!");
			MaemeStorage.ComputerManager.getPlayerStorage(player).addToComputer(p);
			return;
		}
		if (p.caughtBall == null)
			p.caughtBall = EnumPokeballs.PokeBall;
		if (mode == CardManagerMode.Player)
			p.setOwner(player.username);
		p.setBoss(EnumBossMode.Normal);
		NBTTagCompound n = new NBTTagCompound();
		int id = 0;
		if (mode == CardManagerMode.Player)
			id = new Random().nextInt(32000);
		else if (mode == CardManagerMode.Trainer)
			id = new Random().nextInt(32000) * -1 - 1;
		boolean isUsed = false;
		do {
			isUsed = false;
			for (int i = 0; i < partyPokemon.length; i++) {
				NBTTagCompound nbt = partyPokemon[i];
				if (nbt != null) {
					if (mode == CardManagerMode.Player) {
						id = new Random().nextInt(32000);
					} else if (mode == CardManagerMode.Trainer) {
						id = new Random().nextInt(32000) * -1 - 1;
					}
				}
			}
		} while (contains(id));

		p.setPokemonId(id);
		p.writeEntityToStorageNBT(n);
		p.writeToNBT(n);
		n.setString("id", "Pixelmon");
		n.setName(p.getName());
		n.setBoolean("IsInBall", true);
		n.setBoolean("IsShiny", p.getIsShiny());
		n.setInteger("PixelmonOrder", getNextOpen());
		if (p.getHeldItem() != null) {
			n.setCompoundTag("Held Item", p.getHeldItem().writeToNBT(new NBTTagCompound()));
		}
		partyPokemon[getNextOpen()] = n;
		if (p.getHealth() > 0)
			n.setBoolean("IsFainted", false);
		if (mode == CardManagerMode.Player)
			((EntityPlayerMP) player).playerNetServerHandler.sendPacketToPlayer(new MaemeDataPacket(n, EnumPackets.AddToStorage).getPacket());
	}

	public void retrieve(EntityMaeme currentPixelmon) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound n = partyPokemon[i];
			if (n != null) {
				if (n.getInteger("pixelmonID") == currentPixelmon.getPokemonId()) {
					currentPixelmon.writeEntityToStorageNBT(n);
					currentPixelmon.writeToNBT(n);
					n.setName(currentPixelmon.getName());
					n.setBoolean("IsInBall", true);
					currentPixelmon.unloadEntity();
				}
			}
		}
	}

	public boolean contains(int id) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (nbt.getInteger("pixelmonID") == id)
					return true;
			}
		}
		return false;
	}

	public EntityMaeme sendOut(int id, World world) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound n = partyPokemon[i];
			if (n != null) {
				if (n.getInteger("pixelmonID") == id) {
					n.setFloat("FallDistance", 0);
					n.setBoolean("IsInBall", false);
					EntityMaeme e = (EntityMaeme) MaemeEntityList.createEntityFromNBT(n, world);
					if (mode == CardManagerMode.Player) {
						e.setOwner(player.username);
						e.playerOwned = true;
					}
					e.motionX = e.motionY = e.motionZ = 0;
					e.isDead = false;
					return e;
				}
			}
		}
		return null;
	}

	public NBTTagCompound getNBT(int id) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (nbt.getInteger("pixelmonID") == id)
					return nbt;
			}
		}
		return null;
	}

	public NBTTagCompound[] getList() {
		return partyPokemon;
	}

	public void replace(EntityMaeme EntityMaeme, EntityMaeme entityCapturedPixelmon) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (nbt.getInteger("pixelmonID") == EntityMaeme.getPokemonId()) {
					entityCapturedPixelmon.setPokemonId(EntityMaeme.getPokemonId());
					entityCapturedPixelmon.writeEntityToStorageNBT(nbt);
					entityCapturedPixelmon.writeToNBT(nbt);
					nbt.setString("id", entityCapturedPixelmon.getName());
					nbt.setName(entityCapturedPixelmon.getName());
					if (mode == CardManagerMode.Player)
						player.playerNetServerHandler.sendPacketToPlayer(new MaemeDataPacket(nbt, EnumPackets.UpdateStorage).getPacket());
				}
			}
		}
	}

	public void changePokemon(int pos, NBTTagCompound n) {
		if (partyPokemon[pos] != null) {
			if (mode == CardManagerMode.Player)
				player.playerNetServerHandler.sendPacketToPlayer(PacketCreator.createPacket(EnumPackets.RemoveFromStorage, partyPokemon[pos].getInteger("pixelmonID")));
		}
		if (n != null) {
			n.setInteger("PixelmonOrder", pos);
			if (mode == CardManagerMode.Player)
				player.playerNetServerHandler.sendPacketToPlayer(new MaemeDataPacket(n, EnumPackets.AddToStorage).getPacket());
		}
		partyPokemon[pos] = n;
	}

	public void addToFirstEmptySpace(NBTTagCompound n) {
		for (int i = 0; i < partyPokemon.length; i++) {
			if (partyPokemon[i] == null) {
				if (n != null) {
					n.setInteger("PixelmonOrder", i);
					if (mode == CardManagerMode.Player)
						player.playerNetServerHandler.sendPacketToPlayer(new MaemeDataPacket(n, EnumPackets.AddToStorage).getPacket());
				}
				partyPokemon[i] = n;
				return;
			}
		}
	}

	public int count() {
		int count = 0;
		for (int i = 0; i < partyPokemon.length; i++)
			if (partyPokemon[i] != null)
				count++;
		return count;
	}

	public int countAblePokemon() {
		int c = 0;
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (!nbt.getBoolean("IsFainted") && nbt.getShort("Health") > 0)
					c++;
			}
		}
		return c;
	}

	public boolean isIn(EntityMaeme EntityMaeme) {
		return contains(EntityMaeme.getPokemonId());
	}

	public boolean hasSentOut(int pixelmonID) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (nbt.getInteger("pixelmonID") == pixelmonID)
					if (!nbt.getBoolean("IsInBall"))
						return true;
			}
		}
		return false;
	}

	public boolean isFainted(int pokemonId) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (nbt.getInteger("pixelmonID") == pokemonId) {
					if (nbt.getBoolean("IsFainted"))
						return true;
					if (nbt.getShort("Health") <= 0)
						return true;
				}
			}
		}
		return false;
	}

	public void updateNBT(EntityMaeme pixelmon) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (nbt.getInteger("pixelmonID") == pixelmon.getPokemonId()) {
					pixelmon.writeEntityToStorageNBT(nbt);
					pixelmon.writeToNBT(nbt);
					nbt.setString("id", pixelmon.getName());
					nbt.setName(pixelmon.getName());
					if (pixelmon.getHealth() <= 0)
						nbt.setBoolean("IsFainted", true);
					if (mode == CardManagerMode.Player)
						player.playerNetServerHandler.sendPacketToPlayer(new MaemeDataPacket(nbt, EnumPackets.UpdateStorage).getPacket());
				}
			}
		}
	}

	public void sendUpdatedList() {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (mode == CardManagerMode.Player)
					player.playerNetServerHandler.sendPacketToPlayer(new MaemeDataPacket(nbt, EnumPackets.UpdateStorage).getPacket());
			}
		}
	}

	public int getIDFromPosition(int pos) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound n = partyPokemon[i];
			if (n != null) {
				if (n.getInteger("PixelmonOrder") == pos)
					return n.getInteger("pixelmonID");
			}
		}
		return -1;
	}

	public boolean EntityAlreadyExists(int id, World world) {

		@SuppressWarnings("unchecked")
		List<Entity> EntityList = world.loadedEntityList;
		for (int i = 0; i < EntityList.size(); i++) {
			Entity e = EntityList.get(i);
			if (e instanceof EntityMaeme) {
				if (((EntityMaeme) e).getPokemonId() == id) {
					return true;
				}
			}
		}
		return false;
	}

	public EntityMaeme getAlreadyExists(int id, World world) {
		if (id == -1) {
			return null;
		}
		@SuppressWarnings("unchecked")
		List<Entity> EntityList = world.loadedEntityList;
		for (int i = 0; i < EntityList.size(); i++) {
			Entity e = EntityList.get(i);
			if (e instanceof EntityMaeme) {
				if (((EntityMaeme) e).getPokemonId() == id) {
					return (EntityMaeme) e;
				}
			}
		}
		return null;
	}

	public void writeToNBT(NBTTagCompound var1) {
		var1.setInteger("pixelDollars", pokeDollars);
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound e = partyPokemon[i];
			if (e != null) {
				if (EntityAlreadyExists(e.getInteger("pixelmonID"), player.worldObj)) {
					EntityMaeme pixelmon = getAlreadyExists(e.getInteger("pixelmonID"), player.worldObj);
					updateNBT(pixelmon);
				}
				e.setInteger("PixelmonOrder", i);
				var1.setCompoundTag("" + e.getInteger("pixelmonID"), e);
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public void readFromNBT(NBTTagCompound var1) {
		pokeDollars = var1.getInteger("pixelDollars");
		Iterator iterator = var1.getTags().iterator();
		do {
			if (!iterator.hasNext())
				break;

			NBTBase nbtbase = (NBTBase) iterator.next();

			if (nbtbase instanceof NBTTagCompound) {
				NBTTagCompound pokemonData = (NBTTagCompound) nbtbase;
				pokemonData.setName(pokemonData.getString("Name"));
				partyPokemon[pokemonData.getInteger("PixelmonOrder")] = pokemonData;
				if (mode == CardManagerMode.Player)
					player.playerNetServerHandler.sendPacketToPlayer(new MaemeDataPacket(pokemonData, EnumPackets.AddToStorage).getPacket());
			}
		} while (true);
	}

	public EntityMaeme getFirstAblePokemon(World world) {
		for (int i = 0; i < carryLimit; i++) {
			int id = getIDFromPosition(i);
			if (id != -1 && !isFainted(id))
				return sendOut(id, world);
		}
		return null;
	}

	public int getFirstAblePokemonID(World worldObj) {
		for (int i = 0; i < carryLimit; i++) {
			int id = getIDFromPosition(i);
			if (id != -1 && !isFainted(id))
				return id;
		}
		return -1;
	}

	public void healAllPokemon() {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				heal(nbt);
			}
		}
	}

	public EntityMaeme sendOutFromPosition(int pos, World worldObj) {
		return sendOut(getIDFromPosition(pos), worldObj);
	}

	public void heal(int index) {
		for (int i = 0; i < partyPokemon.length; i++) {
			NBTTagCompound nbt = partyPokemon[i];
			if (nbt != null) {
				if (nbt.getInteger("pixelmonID") == index)
					heal(nbt);
			}
		}
	}

	private void heal(NBTTagCompound nbt) {
		nbt.setShort("Health", (short) nbt.getInteger("StatsHP"));
		nbt.setBoolean("IsFainted", false);
		int numMoves = nbt.getInteger("PixelmonNumberMoves");
		for (int i = 0; i < numMoves; i++) {
			nbt.setInteger("PixelmonMovePP" + i, nbt.getInteger("PixelmonMovePPBase" + i));
		}
		int numStatus = nbt.getShort("EffectCount");
		for (int i = 0; i < numStatus; i++) {
			nbt.removeTag("Effect" + i);
		}
		nbt.setShort("EffectCount", (short) 0);
		if (mode == CardManagerMode.Player)
			player.playerNetServerHandler.sendPacketToPlayer(new MaemeDataPacket(nbt, EnumPackets.UpdateStorage).getPacket());
	}

	public void recallAllPokemon() {
		for (int i = 0; i < partyPokemon.length; i++) {
			if (partyPokemon[i] != null) {
				if (EntityAlreadyExists(partyPokemon[i].getInteger("pixelmonID"), player.worldObj)) {
					EntityMaeme p = getAlreadyExists(partyPokemon[i].getInteger("pixelmonID"), player.worldObj);
					try {
						MaemeStorage.CardManager.getPlayerStorage(player).retrieve(p);
					} catch (PlayerNotLoadedException e) {
						e.printStackTrace();
					}
					updateNBT(p);
					p.isInBall = true;
					p.unloadEntity();
				}
			}
		}
	}

}