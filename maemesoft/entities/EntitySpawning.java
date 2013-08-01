package maemesoft.entities;

//수정일 : 7/11 12:23 (현재 인벤토리 오류 수정중)

import maemesoft.RandomHelper;
import maemesoft.config.MaemeConfig;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent;

public class EntitySpawning {
	@ForgeSubscribe
	public void onSpawnInChunk(EntityEvent.EnteringChunk event) {
		if (event.entity.posX > event.newChunkX * 16 + 16 || event.entity.posX < event.newChunkX * 16 || event.entity.posZ > event.newChunkZ * 16 + 16
				|| event.entity.posZ < event.newChunkZ * 16) {
			if (MaemeConfig.printErrors)
				System.out.println("Fixing entity");
			event.entity.posX = RandomHelper.getRandomNumberBetween(0, 15) + event.newChunkX * 16;
			event.entity.posZ = RandomHelper.getRandomNumberBetween(0, 15) + event.newChunkZ * 16;
		}
	}
}