package maemesoft.entities.maeme.particleEffects;

import net.minecraft.util.MathHelper;
import maemesoft.client.ClientProxy;
import maemesoft.entities.maeme.Entity4Textures;

public class GastlyParticles extends ParticleEffects {

	public GastlyParticles(Entity4Textures pixelmon) {
		super(pixelmon);
	}

	@Override
	public void onUpdate() {
		float var2 = .6F;
		float var4 = rand.nextFloat() * (float) Math.PI * 2.0F;
		float var42 = rand.nextFloat() * (float) Math.PI * 2.0F;
		float var5 = rand.nextFloat() * 1F + .5F;
		float var52 = rand.nextFloat() * 1F + .5F;
		float var6 = MathHelper.sin(var4) * var2 * .7F * var5;
		float var62 = MathHelper.sin(var42) * var2 * .7F * var52;
		float var7 = MathHelper.cos(var4) * var2 * .5F * var5;
		float var72 = MathHelper.cos(var42) * var2 * .5F * var52;
		float var8 = rand.nextFloat() * var2 * 1.2F;
		float var82 = rand.nextFloat() * var2 * 1.2F;
	}

}