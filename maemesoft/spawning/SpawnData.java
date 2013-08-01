package maemesoft.spawning;

import net.minecraft.util.WeightedRandomItem;
import maemesoft.config.MaemeEntityList.ClassType;
import maemesoft.db.SpawnLocation;

public class SpawnData extends WeightedRandomItem{
	public String name;
	public int rarity;
	public ClassType type;
	public SpawnLocation spawnLocation;

	public SpawnData(String n, int r, ClassType t, SpawnLocation s) {
		super(r);
		name = n;
		rarity = r;
		type = t;
		spawnLocation = s;
	}
}