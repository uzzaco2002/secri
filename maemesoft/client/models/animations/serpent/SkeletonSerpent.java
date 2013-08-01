package maemesoft.client.models.animations.serpent;

import maemesoft.client.models.animations.ModuleHead;
import maemesoft.client.models.animations.SkeletonBase;
import maemesoft.entities.maeme.EntityMaeme;
import net.minecraft.client.model.ModelRenderer;

public class SkeletonSerpent extends SkeletonBase {

	protected ModelRenderer leftArm, rightArm;
	protected ModelRenderer leftLeg, rightLeg;

	public SkeletonSerpent(ModelRenderer body){
		super(body);
	}

	public SkeletonSerpent(ModelRenderer body, ModuleHead headModule){
		this(body);
		modules.add(headModule);
	}

	@Override
	public void walk(EntityMaeme entity, float f, float f1, float f2, float f3, float f4) {
		super.walk(entity, f, f1, f2, f3, f4);
	}
}