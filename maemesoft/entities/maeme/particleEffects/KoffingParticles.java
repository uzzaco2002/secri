package maemesoft.entities.maeme.particleEffects;

import java.util.Random;

import net.minecraft.util.MathHelper;
import maemesoft.client.ClientProxy;
import maemesoft.entities.maeme.Entity4Textures;

public class KoffingParticles extends ParticleEffects {

	int count = 0;
	boolean particlesOn = true;

	public KoffingParticles(Entity4Textures pixelmon) {
		super(pixelmon);
	}

	@Override
	public void onUpdate() {
		float var2 = pixelmon.baseStats.width * pixelmon.baseStats.giScale * pixelmon.getScale();
		float var4 = this.rand.nextFloat() * (float) Math.PI * 2.0F;
		float var5 = this.rand.nextFloat() * 4F + .5F;
		float var6 = MathHelper.sin(var4) * var2 * .5F * var5;
		float var7 = MathHelper.cos(var4) * var2 * .5F * var5;

		if (count <= 0) {
			particlesOn = !particlesOn;
			if (particlesOn)
				count = (new Random()).nextInt(3);
			else
				count = (new Random()).nextInt(27);
		}
		count--;

	}

}