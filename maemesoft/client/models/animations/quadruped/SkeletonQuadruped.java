package maemesoft.client.models.animations.quadruped;

import maemesoft.client.models.animations.Module;
import maemesoft.client.models.animations.ModuleTailBasic;
import maemesoft.client.models.animations.SkeletonBase;
import maemesoft.client.models.animations.ModuleHead;
import maemesoft.client.models.animations.ModuleLeg;
import maemesoft.entities.maeme.EntityMaeme;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.MathHelper;

public class SkeletonQuadruped extends SkeletonBase {

	public SkeletonQuadruped(ModelRenderer body, Module headModule, ModuleLeg frontLeftLeg, ModuleLeg frontRightLeg, ModuleLeg backLeftLeg,
			ModuleLeg backRightLeg, ModuleTailBasic tail) {
		super(body);
		if (headModule != null)
			modules.add(headModule);
		if (frontLeftLeg != null)
			modules.add(frontLeftLeg);
		if (frontRightLeg != null)
			modules.add(frontRightLeg);
		if (backLeftLeg != null)
			modules.add(backLeftLeg);
		if (backRightLeg != null)
			modules.add(backRightLeg);
		if (tail != null)
			modules.add(tail);
	}
}