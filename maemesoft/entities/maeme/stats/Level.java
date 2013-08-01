package maemesoft.entities.maeme.stats;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import maemesoft.blocks.BlockEvolutionRock;
import maemesoft.common.ChatHandler;
import maemesoft.common.EnumPackets;
import maemesoft.common.PacketCreator;
import maemesoft.common.MaemeLevelUpPacket;
import maemesoft.common.MaemeStatsPacket;
import maemesoft.common.packetHandlers.ReplaceMove;
import maemesoft.db.DBMoves;
import maemesoft.db.DBStats;
import maemesoft.db.EvolutionInfo;
import maemesoft.db.EvolutionInfo.InfoMode;
import maemesoft.db.ExperienceGroup;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.enums.EnumBiomes;
import maemesoft.enums.EnumPokemon;
import maemesoft.enums.heldItems.EnumHeldItems;
import maemesoft.items.ItemHeld;
import maemesoft.storage.MaemeStorage;

public class Level {

	private EntityMaeme pixelmon;
	private int baseLevel = 0;

	public Level(EntityMaeme p) {
		this.pixelmon = p;
		pixelmon.getDataWatcher().addObject(19, (short) -1); // Level
		pixelmon.getDataWatcher().addObject(11, (short) 0); // Experience
		pixelmon.getDataWatcher().addObject(13, (short) 0); // Experience to
															// next level
		setScale();
	}

	protected void updateStats() {
		pixelmon.updateStats();
	}

	public void writeToNBT(NBTTagCompound var1) {
		var1.setInteger("Level", getLevel());
		var1.setInteger("EXP", getExp());
		var1.setInteger("EXPToNextLevel", getExpToNextLevel());
	}

	public void readFromNBT(NBTTagCompound var1) {
		setExp(var1.getInteger("EXP"));
		setExpToNextLevel(getExpForLevel(getLevel() + 1) - getExpForLevel(getLevel()));
		setLevel(var1.getInteger("Level"));
	}

	public int getLevel() {
		return pixelmon.getDataWatcher().getWatchableObjectShort(19);
	}

	public void setLevel(int i) {
		pixelmon.getDataWatcher().updateObject(19, (short) i);
		setScale();
		setExpToNextLevel(getExpForLevel(getLevel() + 1) - getExpForLevel(getLevel()));
		if (pixelmon.getHealth() == pixelmon.stats.HP) {
			updateStats();
			pixelmon.setEntityHealth(pixelmon.stats.HP);
		} else {
			float oldHp = pixelmon.stats.HP;
			float oldHealth = pixelmon.getHealth();
			updateStats();
			float newHealth = pixelmon.stats.HP;
			if (oldHp != 0)
				newHealth = oldHealth / oldHp * pixelmon.stats.HP;
			pixelmon.setEntityHealth((int) Math.ceil(newHealth));
		}
	}

	private int getExpForLevel(int level2) {
		double l = level2;
		ExperienceGroup ex = pixelmon.baseStats.experienceGroup;
		if (ex == ExperienceGroup.Erratic) {
			if (l <= 50)
				return (int) (l * l * l * (100 - l)) / 50;
			if (l <= 68)
				return (int) (l * l * l * (150 - l)) / 100;
			if (l <= 98)
				return (int) (l * l * l * (1911 - 10 * l)) / 3;
			if (l <= 100)
				return (int) (l * l * l * (160 - l)) / 100;
		} else if (ex == ExperienceGroup.Fast) {
			return (int) (4 * l * l * l / 5);
		} else if (ex == ExperienceGroup.MediumFast) {
			return (int) (l * l * l);
		} else if (ex == ExperienceGroup.MediumSlow) {
			return (int) ((6 / 5) * l * l * l - 15 * l * l + 100 * l - 140);
		} else if (ex == ExperienceGroup.Slow) {
			return (int) (5 * l * l * l / 4);
		} else if (ex == ExperienceGroup.Fluctuating) {
			if (l <= 15)
				return (int) (l * l * l * ((l + 1) / 3 + 24) / 50);
			if (l <= 36)
				return (int) (l * l * l * (l + 14) / 50);
			if (l <= 100)
				return (int) (l * l * l * ((l / 2) + 32) / 50);
		}

		return -1;
	}

	public int getExp() {
		return pixelmon.getDataWatcher().getWatchableObjectShort(11);
	}

	public void setExp(int i) {
		pixelmon.getDataWatcher().updateObject(11, (short) i);
	}

	public int getExpToNextLevel() {
		return pixelmon.getDataWatcher().getWatchableObjectShort(13);
	}

	public void setExpToNextLevel(int i) {
		pixelmon.getDataWatcher().updateObject(13, (short) i);
	}

	public boolean canLevelUp() {
		return getLevel() != 100;
	}

	protected void onLevelUp(MaemeStatsPacket stats) {
		float oldHp = pixelmon.stats.HP;
		updateStats();
		float percentGain = ((float) pixelmon.stats.HP) / oldHp;
		float newHealth = ((float) pixelmon.getHealth()) * percentGain;
		pixelmon.setEntityHealth((int) Math.ceil(newHealth));
		if (pixelmon.getOwner() != null && pixelmon.getOwner() instanceof EntityPlayerMP) {
			MaemeStatsPacket stats2 = MaemeStatsPacket.createPacket(pixelmon);
			MaemeLevelUpPacket p = new MaemeLevelUpPacket(pixelmon, getLevel(), stats, stats2, EnumPackets.LevelUp);
			((EntityPlayerMP) pixelmon.getOwner()).playerNetServerHandler.sendPacketToPlayer(p.getPacket());
			pixelmon.updateNBT();
		}

		if (pixelmon.getOwner() != null)
			pixelmon.friendship.onLevelUp();

		setScale();
	}

	public void learnNextMove() {
	}

	public void awardEXP(int i) {
		if (!pixelmon.doesLevel)
			return;
		setExp(getExp() + i);
		if ((pixelmon.getOwner() != null) && getLevel() != 100)
			if (pixelmon.getOwner() != null)
				ChatHandler.sendChat(pixelmon.getOwner(), "Your " + pixelmon.getNickname() + " gained " + i + " EXP!");
		if (!canLevelUp() || getExpToNextLevel() == -1) {
			setExp(0);
			return;
		}
		while (getExp() >= getExpToNextLevel()) {
			int newExp = getExp() - getExpToNextLevel();
			if (!canLevelUp())
				return;

			MaemeStatsPacket stats = null;
			if (pixelmon.getOwner() != null)
				stats = MaemeStatsPacket.createPacket(pixelmon);
			setLevel(getLevel() + 1);
			onLevelUp(stats);
			setExp(newExp);
			if (!ItemHeld.isItemOfType(pixelmon.getHeldItem(), EnumHeldItems.everStone)) {
				if (pixelmon.baseStats.evolveInto != null && pixelmon.baseStats.evolveLevel != -1 && getLevel() >= pixelmon.baseStats.evolveLevel) {
					pixelmon.evolve(pixelmon.baseStats.evolveInto.name);
				}
				for (EvolutionInfo e : DBStats.getEvolveList(pixelmon.getName())) {
					if (EnumPokemon.hasPokemon(e.pokemonName) && e.mode == InfoMode.friendship && pixelmon.friendship.isFriendshipHighEnoughToEvolve()) {
						boolean evolves = true;
						if (e.extraParam != null) {
							if (e.extraParam.equalsIgnoreCase("day") && !pixelmon.worldObj.isDaytime())
								evolves = false;
							else if (e.extraParam.equalsIgnoreCase("night") && pixelmon.worldObj.isDaytime())
								evolves = false;
						}
						if (evolves) {
							pixelmon.evolve(e.pokemonName);
							break;
						}
					} else if (EnumPokemon.hasPokemon(e.pokemonName) && e.mode == InfoMode.biome) {
						if (pixelmon.worldObj.getBiomeGenForCoords((int) pixelmon.posX, (int) pixelmon.posZ) == EnumBiomes.parseBiome(e.extraParam).getBiome()) {
							pixelmon.evolve(e.pokemonName);
							break;
						}
					} else if (EnumPokemon.hasPokemon(e.pokemonName) && e.mode == InfoMode.evolutionRock) {
						boolean evolves = false;
						EntityPlayer player = (EntityPlayer) pixelmon.getOwner();
						for (int j = 0; j < pixelmon.worldObj.loadedTileEntityList.size(); j++) {
							TileEntity t = (TileEntity) pixelmon.worldObj.loadedTileEntityList.get(j);
							if (t.getBlockType() instanceof BlockEvolutionRock && ((BlockEvolutionRock) t.getBlockType()).rockType == e.evolutionRock) {
								if (getDistanceFrom(t, player.posX, player.posY, player.posZ) < 100) {
									evolves = true;
									break;
								}
							}
						}
						if (evolves) {
							pixelmon.evolve(e.pokemonName);
							break;
						}
					}
				}
			}
			String name = pixelmon.getName();
		}
	}

	public double getDistanceFrom(TileEntity te, double par1, double par3, double par5) {
		double d3 = (double) te.xCoord + 0.5D - par1;
		double d4 = (double) te.yCoord + 0.5D - par3;
		double d5 = (double) te.zCoord + 0.5D - par5;
		return d3 * d3 + d4 * d4 + d5 * d5;
	}

	private void setScale() {
		float percent = 1;
		percent = 0.8f + 0.4f * (getLevel()) / (100);
		if (percent > pixelmon.maxScale)
			percent = pixelmon.maxScale;
		pixelmon.setScale(percent);
	}

	public void recalculateXP() {
		setExp(0);
		setExpToNextLevel(getExpForLevel(getLevel() + 1) - getExpForLevel(getLevel()));
	}
}