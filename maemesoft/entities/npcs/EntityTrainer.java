package maemesoft.entities.npcs;

//수정일 : 7/11 12:35 (현재 인벤토리 오류 수정중)

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import maemesoft.Maeme;
import maemesoft.api.events.EventType;
import maemesoft.api.events.MaemeEventHandler;
import maemesoft.common.ChatHandler;
import maemesoft.config.MaemeConfig;
import maemesoft.config.MaemeEntityList;
import maemesoft.db.DBTrainers;
import maemesoft.db.SpawnLocation;
import maemesoft.db.TrainerInfo;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.storage.PlayerStorage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTrainer extends EntityNPC {

	public PlayerStorage pokemonStorage = new PlayerStorage(this);
	public EntityMaeme releasedPokemon;
	public TrainerInfo info;

	public EntityTrainer(World par1World) {
		super(par1World, NPCType.Trainer);
		dataWatcher.addObject(25, (int) 0);
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(2, new EntityAIWander(this, moveSpeed));
	}

	public void init(String name) {
		super.init(name);
		pokemonStorage = new PlayerStorage(this);
		info = DBTrainers.GetTrainerInfo(name);
		if (info == null) {
			if (MaemeConfig.printErrors)
				System.out.println("Database entry error/missing for trainer " + name);
			setDead();
			return;
		}
		dataWatcher.updateObject(25, info.level);
		if (dataWatcher.getWatchableObjectString(4).equals(""))
			dataWatcher.updateObject(4, info.model);
		dataWatcher.updateObject(26, info.name);
	}

	@Override
	protected boolean canDespawn() {
		return true;
	}

	public void releasePokemon() {
		if (pokemonStorage.count() == 0)
			loadPokemon();
		else {

		}
		EntityMaeme p = pokemonStorage.getFirstAblePokemon(worldObj);
		if (p != null) {
			releasedPokemon = p;
			p.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			motionX = 0;
			motionY = 0;
			motionZ = 0;
			p.releaseFromPokeball();
		}
	}

	public boolean hasAblePokemon() {
		if (pokemonStorage.countAblePokemon() == 0)
			return false;
		return true;
	}

	public void loadPokemon() {
		for (String pokemonName : info.partypokemon) {
			EntityMaeme p = (EntityMaeme) MaemeEntityList.createEntityByName(pokemonName, worldObj);
			if (p != null) {
				p.getLvl().setLevel((new Random()).nextInt(3) - 1 + info.level);
				p.setEntityHealth(p.stats.HP);
				pokemonStorage.addToParty(p);
			}
		}
	}

	public void startBattle(EntityPlayer player) {
		ChatHandler.sendBattleMessage(player, info.greeting);
	}

	public void loseBattle(EntityLiving entityLiving) {
		if (entityLiving instanceof EntityPlayer) {
			ChatHandler.sendBattleMessage(entityLiving, info.loseMessage);
			MaemeEventHandler.fireEvent(EventType.BeatTrainer, (EntityPlayer) entityLiving);
		}
	}

	public void winBattle(EntityLiving entityLiving) {
		ChatHandler.sendBattleMessage(entityLiving, info.winMessage);
	}

	public void retrievePokemon() {
		pokemonStorage.retrieve(releasedPokemon);
	}

	public void healAllPokemon() {
		for (NBTTagCompound nbt : pokemonStorage.partyPokemon) {
			if (nbt != null) {
				nbt.setShort("Health", (short) nbt.getInteger("StatsHP"));
				nbt.setBoolean("IsFainted", false);
				int numMoves = nbt.getInteger("PixelmonNumberMoves");
				for (int i = 0; i < numMoves; i++) {
					nbt.setInteger("PixelmonMovePP" + i, nbt.getInteger("PixelmonMovePPBase" + i));
				}
				if (nbt.hasKey("EffectCount")) {
					int numStatus = nbt.getShort("EffectCount");
					for (int i = 0; i < numStatus; i++) {
						nbt.removeTag("Effect" + i);
					}
					nbt.setShort("EffectCount", (short) 0);
				}
			}
		}
	}

	public int getNextPokemonID() {
		EntityMaeme p = pokemonStorage.getFirstAblePokemon(worldObj);
		return p.getPokemonId();
	}

	public int getLvl() {
		return dataWatcher.getWatchableObjectInt(25);
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	@Override
	public boolean interactWithNPC(EntityPlayer player) {
		return false;
	}

}