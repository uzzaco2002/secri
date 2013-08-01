package maemesoft.entities.maeme.particleEffects;

import net.minecraft.util.MathHelper;
import maemesoft.entities.maeme.Entity4Textures;

public class DiglettParticles extends ParticleEffects {

	public DiglettParticles(Entity4Textures pixelmon) {
		super(pixelmon);
	}

	@Override
	public void onUpdate() {
		if (pixelmon.lastTickPosX - pixelmon.posX != 0 || pixelmon.lastTickPosZ - pixelmon.posZ != 0) {
			int i = MathHelper.floor_double(pixelmon.posX);
			int j = MathHelper.floor_double(pixelmon.posY - 0.20000000298023224D - (double) pixelmon.yOffset);
			int k = MathHelper.floor_double(pixelmon.posZ);
			int j1 = pixelmon.worldObj.getBlockId(i, j, k);
			if (j1 > 0) {
				pixelmon.worldObj.spawnParticle("tilecrack_" + j1 + "_0", pixelmon.posX + ((double) rand.nextFloat() - 0.5D) * (double) pixelmon.width,
						pixelmon.boundingBox.minY + 0.10000000000000001D, pixelmon.posZ + ((double) rand.nextFloat() - 0.5D) * (double) pixelmon.width, -pixelmon.motionX * 4D,
						1.5D, -pixelmon.motionZ * 4D);
			}
		}

	}

}