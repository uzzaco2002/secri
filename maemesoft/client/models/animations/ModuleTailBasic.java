package maemesoft.client.models.animations;

import maemesoft.client.models.animations.bird.EnumWing;
import maemesoft.entities.maeme.EntityMaeme;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.MathHelper;

public class ModuleTailBasic extends Module {

	ModelRenderer tail;

	float TailRotationLimitY;
	float TailRotationLimitZ;
	float TailSpeed;
	float TailInitY;
	float TailInitZ;
	float TailOrientation;
	float TurningSpeed;
	float TurningAngle;

	public ModuleTailBasic(ModelRenderer tail, float TailRotationLimitY, float TailRotationLimitZ, float TailSpeed) {
		this.tail = tail;
		this.TailSpeed = TailSpeed;
		this.TailRotationLimitY = TailRotationLimitY;
		this.TailRotationLimitZ = TailRotationLimitZ;
		TailInitY = tail.rotateAngleY;
		TailInitZ = tail.rotateAngleX;


	}

	@Override
	public void walk(EntityMaeme entity, float f, float f1, float f2, float f3, float f4) {
		TurningSpeed = Math.abs(entity.rotationYaw - entity.prevRotationYaw);


		tail.rotateAngleY =  MathHelper.cos(f * TailSpeed)
				* (float) Math.PI
				* f1
				* TailRotationLimitY + TurningAngle;

		tail.rotateAngleX = MathHelper.cos(f * TailSpeed * 2)
				* (float) Math.PI
				* f1
				* TailRotationLimitZ;


	}

	@Override
	public void fly(EntityMaeme entity, float f, float f1, float f2, float f3, float f4) {

	}
}