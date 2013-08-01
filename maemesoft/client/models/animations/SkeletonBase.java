package maemesoft.client.models.animations;

import java.util.ArrayList;

import maemesoft.entities.maeme.EntityMaeme;

import net.minecraft.client.model.ModelRenderer;

public class SkeletonBase {
	protected float toDegrees = 57.29578F;
	protected float toRadians = 1 / toDegrees;
	protected ArrayList<Module> modules = new ArrayList<Module>();
	public ModelRenderer body;

	public SkeletonBase(ModelRenderer body) {
		this.body = body;
	}

	public void add(Module module) {
		modules.add(module);
	}

	public void walk(EntityMaeme entity, float f, float f1, float f2, float f3, float f4) {
		for (Module m : modules)
			m.walk(entity, f, f1, f2, f3, f4);
	}

	public void fly(EntityMaeme entity, float f, float f1, float f2, float f3, float f4) {
		for (Module m : modules)
			m.fly(entity, f, f1, f2, f3, f4);
	}

	public void swim(EntityMaeme pixelmon, float f, float f1, float f2, float f3, float f4) {

	}

}