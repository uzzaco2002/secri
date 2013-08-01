package maemesoft.spawning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.world.biome.BiomeGenBase;
import maemesoft.config.MaemeEntityList.ClassType;
import maemesoft.db.DBStats;
import maemesoft.db.DBTrainers;
import maemesoft.db.SpawnLocation;

public class SpawnRegistry {

	private static HashMap<BiomeGenBase, List<SpawnData>> biomeSpawns = new HashMap<BiomeGenBase, List<SpawnData>>();
	private static HashMap<BiomeGenBase, List<SpawnData>> undergroundSpawns = new HashMap<BiomeGenBase, List<SpawnData>>();
	private static HashMap<BiomeGenBase, List<SpawnData>> biomeWaterSpawns = new HashMap<BiomeGenBase, List<SpawnData>>();

	public static void addSpawn(String name, int rarity, ClassType type) {
		BiomeGenBase[] biomes = null;
		if (type == ClassType.Pixelmon)
			biomes = DBStats.GetSpawnBiomes(name);
		else if (type == ClassType.Trainer)
			biomes = DBTrainers.GetSpawnBiomes(name);

		SpawnLocation[] spawnLocations = DBStats.getSpawnLocations(name);

		if (biomes == null)
			return;
		if (spawnLocations == null) {
			for (BiomeGenBase b : biomes) {
				storeSpawnInfo(biomeSpawns, name, rarity, type, b, null);
			}
		} else {
			for (SpawnLocation s : spawnLocations) {
				for (BiomeGenBase b : biomes) {
					if (type == ClassType.Pixelmon) {
						if (s == SpawnLocation.Land || s == SpawnLocation.Air) {
							storeSpawnInfo(biomeSpawns, name, rarity, type, b, s);
						} else if (s == SpawnLocation.UnderGround) {
							storeSpawnInfo(undergroundSpawns, name, rarity, type, b, s);
						} else if (s == SpawnLocation.Water || s == SpawnLocation.OnWater) {
							storeSpawnInfo(biomeWaterSpawns, name, rarity, type, b, s);
						}
					}
				}
			}
		}
	}

	private static void storeSpawnInfo(HashMap<BiomeGenBase, List<SpawnData>> hashmap, String name, int rarity, ClassType type, BiomeGenBase b, SpawnLocation s) {
		List<SpawnData> spawnList;
		if (hashmap.containsKey(b))
			spawnList = hashmap.get(b);
		else
			spawnList = new ArrayList<SpawnData>();

		spawnList.add(new SpawnData(name, rarity, type, s));
		hashmap.put(b, spawnList);
	}

	public static List<SpawnData> getSpawnsForBiome(BiomeGenBase b) {
		return biomeSpawns.get(b);
	}

	public static List<SpawnData> getUndergroundSpawnsForBiome(BiomeGenBase b) {
		return undergroundSpawns.get(b);
	}

	public static List<SpawnData> getWaterSpawnsForBiome(BiomeGenBase b) {
		return biomeWaterSpawns.get(b);
	}
}