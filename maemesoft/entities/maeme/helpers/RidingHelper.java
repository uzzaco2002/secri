package maemesoft.entities.maeme.helpers;

import net.minecraft.world.World;
import maemesoft.entities.maeme.EntityMaeme;

public class RidingHelper {

	EntityMaeme parent;
	World worldObj;
	private Object field_70768_au;
	private float field_70766_av;
	private int jumpTicks;

	public RidingHelper(EntityMaeme parent, World worldObj) {
		this.worldObj = worldObj;
		this.parent = parent;
	}

	public double getMountedYOffset() {
		return (double) parent.height * 0.9D;
	}

	public void onUpdate() {
		//parent.rotationYaw = parent.riddenByEntity.rotationYaw;
	}

	public void onLivingUpdate() {

	}

	public void updateRidden() {
		this.field_70768_au = this.field_70766_av;
		this.field_70766_av = 0.0F;
		parent.fallDistance = 0.0F;
	}

}