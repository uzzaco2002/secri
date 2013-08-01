package maemesoft.config;

//수정일 : 7/10 11:46 (현재 인벤토리 오류 수정중)

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import maemesoft.Maeme;
import maemesoft.db.DBStats;
import maemesoft.db.DBTrainers;
import maemesoft.entities.npcs.EntityDoctor;
import maemesoft.entities.npcs.EntityNPC;
import maemesoft.entities.npcs.EntityTrainer;
import maemesoft.entities.npcs.NPCType;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.enums.EnumPokemon;
import maemesoft.enums.EnumTrainers;
import maemesoft.spawning.SpawnRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class MaemeEntityList {
	/**
	 * Create a new instance of an entity in the world by using the entity name.
	 */
	public static EntityLiving createEntityByName(String par0Str, World par1World) {
		EntityLiving var2 = null;

		try {
			ClassType type = null;
			for (EnumPokemon pokemon : EnumPokemon.values())
				if (pokemon.name.equalsIgnoreCase(par0Str))
					type = ClassType.Pixelmon;

			if (type == ClassType.Pixelmon) {
				var2 = new EntityMaeme(par1World);
				((EntityMaeme) var2).init(par0Str);
			} else if (EnumTrainers.has(par0Str)) {
				var2 = new EntityTrainer(par1World);
				((EntityTrainer) var2).init(par0Str);
			}else {
				NPCType npcType = NPCType.get(par0Str);
				if (npcType == NPCType.Doctor)
					var2 = new EntityDoctor(par1World);
				((EntityNPC)var2).init(par0Str);
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		return var2;
	}

	/**
	 * create a new instance of an entity from NBT store
	 */
	public static Entity createEntityFromNBT(NBTTagCompound par0NBTTagCompound, World par1World) {
		EntityLiving var2 = null;

		try {
			Class<?> var3 = EntityMaeme.class;

			if (var3 != null) {
				var2 = (EntityLiving) var3.getConstructor(new Class[] { World.class }).newInstance(new Object[] { par1World });
				((EntityMaeme) var2).init(par0NBTTagCompound.getString("Name"));
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		if (var2 != null) {
			var2.readFromNBT(par0NBTTagCompound);
		} else {
			if (MaemeConfig.printErrors)
				System.out.println("Skipping Entity with id " + par0NBTTagCompound.getString("id"));
		}

		return var2;
	}

	public static void registerEntities() {
		EntityRegistry.registerModEntity(EntityNPC.class, "NPC", MaemeConfig.idTrainers, Maeme.instance, 100, 1, true);
		EntityRegistry.registerModEntity(EntityMaeme.class, "Pixelmon", MaemeConfig.idPixelmon, Maeme.instance, 100, 1, true);
	}

	public static void addSpawns() {
		System.out.println("[PIXELMON] Registering entity spawns");

		for (EnumPokemon pokemon : EnumPokemon.values()) {
			String name = pokemon.name;
			int rarity = DBStats.GetRarity(name);
			if (rarity > 0)
				SpawnRegistry.addSpawn(name, rarity, ClassType.Pixelmon);
		}

		for (EnumTrainers trainer : EnumTrainers.values()) {
			String name = trainer.toString();
			int rarity = DBTrainers.getRarity(name);
			double rardbl = (double) rarity;
			rardbl *= ((double) MaemeConfig.trainerRarityModifier) / 100.0;
			rarity = (int) rardbl;
			if (rarity > 0)
				SpawnRegistry.addSpawn(name, rarity, ClassType.Trainer);
		}
	}

	public enum ClassType {
		Trainer, Pixelmon
	}
}