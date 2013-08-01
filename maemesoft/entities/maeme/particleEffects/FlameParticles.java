package maemesoft.entities.maeme.particleEffects;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.world.World;
import maemesoft.client.ClientProxy;
import maemesoft.entities.maeme.Entity4Textures;


public class FlameParticles extends ParticleEffects {

	public float radius;
	public float yOffset;
	private byte count = 0;
	private int size = 0;

	public FlameParticles(Entity4Textures pixelmon, float r, float y, int s) {
		super(pixelmon);
		radius = r;
		yOffset = y;
		size = s;
	}

	private Double random(double sc, boolean np) {
		if(!np)
			return Math.random() * sc;
		double d = Math.random();
		if(d > 0.5)
			return Math.random() * sc;
		else
			return -(Math.random() * sc);
	}

	private Double random(double sc) {
		return random(sc, true);
	}

	public void onUpdate() {
		double x = pixelmon.posX;
		double y = pixelmon.posY + pixelmon.hoverTimer + yOffset * pixelmon.getScaleFactor();
		double z = pixelmon.posZ;

		float f = 180 - (pixelmon.renderYawOffset);
		x += Math.sin(Math.toRadians(f)) * radius * pixelmon.getScaleFactor();
		z += Math.cos(Math.toRadians(f)) * radius * pixelmon.getScaleFactor();
		byte countmax = 3;
		if(count++ == countmax) {
			if(pixelmon.isWet()) {
				for(int i = 0; i < size * 2; i++) {
					boolean movedMuch = Math.abs(pixelmon.posX - pixelmon.lastTickPosX) > 0.3 ||
							Math.abs(pixelmon.posY - pixelmon.lastTickPosY) > 0.1 ||
							Math.abs(pixelmon.posZ - pixelmon.lastTickPosZ) > 0.1;
				}
			} else {
				for(int i = 0; i < size * 2; i++) {
					boolean movedMuch = Math.abs(pixelmon.posX - pixelmon.lastTickPosX) > 0.1 ||
							Math.abs(pixelmon.posY - pixelmon.lastTickPosY) > 0.1 ||
							Math.abs(pixelmon.posZ - pixelmon.lastTickPosZ) > 0.1;
				}
			}
			count = 0;
		}
	}
}