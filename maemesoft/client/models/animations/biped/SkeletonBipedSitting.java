package maemesoft.client.models.animations.biped;

import net.minecraft.client.model.ModelRenderer;
import maemesoft.client.models.animations.ModuleHead;
import maemesoft.client.models.animations.SkeletonBase;
import maemesoft.entities.maeme.EntityMaeme;

public class SkeletonBipedSitting extends SkeletonBase {
	ModelRenderer LeftArm, RightArm;

	public SkeletonBipedSitting(ModelRenderer body, ModuleHead headModule, ModelRenderer LeftArm, ModelRenderer RightArm, ModelRenderer leftLeg, ModelRenderer rightLeg) {
		super(body);
		modules.add(headModule);
		this.LeftArm = LeftArm;
		this.RightArm = RightArm;
	}

	@Override
	public void walk(EntityMaeme entity, float f, float f1, float f2, float f3, float f4) {
		super.walk(entity, f, f1, f2, f3, f4);
	}

}