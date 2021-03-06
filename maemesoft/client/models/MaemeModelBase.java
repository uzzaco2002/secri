package maemesoft.client.models;

import maemesoft.client.models.animations.SkeletonBase;
import maemesoft.entities.maeme.EntityMaeme;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public abstract class MaemeModelBase extends ModelBase {
	protected SkeletonBase skeleton;

	public MaemeModelBase() {

	}

	@Override
	public void render(Entity var1, float f, float f1, float f2, float f3, float f4, float f5) {
		doAnimation(var1, f, f1, f2, f3, f4, f5);
	}

	public void doAnimation(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		EntityMaeme pixelmon = (EntityMaeme) entity;
		if (entity.worldObj.getBlockMaterial((int) Math.ceil(entity.posX), (int) Math.ceil(entity.posY), (int) Math.ceil(entity.posZ)) == Material.water)
			skeleton.swim(pixelmon, f, f1, f2, f3, f4);
		else if (entity.isAirBorne || pixelmon.baseStats.doesHover)
			skeleton.fly(pixelmon, f, f1, f2, f3, f4);
		else
			skeleton.walk(pixelmon, f, f1, f2, f3, f4);
	}

}