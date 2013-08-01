package maemesoft.client.models.animations;

import java.util.ArrayList;

import maemesoft.client.models.MaemeModelRenderer;
import maemesoft.entities.maeme.EntityMaeme;

import net.minecraft.client.model.ModelRenderer;

public class ModuleHead extends Module {

	ArrayList<Module> modules = new ArrayList<Module>();

	ModelRenderer head;

	float headStartAngleX, headStartAngleY;

	public ModuleHead(MaemeModelRenderer head) {
		this.head = head;
		headStartAngleX = head.rotateAngleX;
		headStartAngleY = head.rotateAngleY;
	}

	@Override
	public void walk(EntityMaeme entity, float f, float f1, float f2, float rotateAnglePitch, float rotateAngleYaw) {
		head.rotateAngleX = rotateAngleYaw * toRadians + headStartAngleX;
		head.rotateAngleY = rotateAnglePitch * toRadians + headStartAngleY;
		for (Module m : modules)
			m.walk(entity, f, f1, f2, rotateAnglePitch, rotateAngleYaw);
	}

	@Override
	public void fly(EntityMaeme entity, float f, float f1, float f2,
			float f3, float f4) {
		walk(entity, f, f1, f2, f3, f4);
	}

}