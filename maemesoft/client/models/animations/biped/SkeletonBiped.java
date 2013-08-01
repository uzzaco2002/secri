package maemesoft.client.models.animations.biped;

import net.minecraft.client.model.ModelRenderer;
import maemesoft.client.models.animations.ModuleArm;
import maemesoft.client.models.animations.ModuleHead;
import maemesoft.client.models.animations.ModuleLeg;
import maemesoft.client.models.animations.ModuleTailBasic;
import maemesoft.client.models.animations.SkeletonBase;

public class SkeletonBiped extends SkeletonBase {

	public SkeletonBiped(ModelRenderer body, ModuleHead headModule, ModuleArm leftArm, ModuleArm rightArm, ModuleLeg leftLeg, ModuleLeg rightLeg, ModuleTailBasic tail) {
		super(body);
		if (headModule != null)
			modules.add(headModule);
		if (leftLeg != null)
			modules.add(leftLeg);
		if (rightLeg != null)
			modules.add(rightLeg);
		if (rightArm != null)
			modules.add(rightArm);
		if (leftArm != null)
			modules.add(leftArm);
		if (tail != null)
			modules.add(tail);
	}
}