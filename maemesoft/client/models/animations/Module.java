package maemesoft.client.models.animations;

import maemesoft.entities.maeme.EntityMaeme;

public abstract class Module {
	protected float toDegrees = 57.29578F;
	protected float toRadians = 1 / toDegrees;

	public Module() {
		// TODO Auto-generated constructor stub
	}

	public abstract void walk(EntityMaeme entity, float f, float f1, float f2, float f3, float f4);

	public abstract void fly(EntityMaeme entity, float f, float f1, float f2, float f3, float f4);

}