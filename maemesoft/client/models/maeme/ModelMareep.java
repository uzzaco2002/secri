package maemesoft.client.models.maeme;

import net.minecraft.entity.Entity;
import maemesoft.client.models.MaemeModelBase;
import maemesoft.client.models.MaemeModelRenderer;
import maemesoft.client.models.animations.EnumLeg;
import maemesoft.client.models.animations.EnumPhase;
import maemesoft.client.models.animations.ModuleHead;
import maemesoft.client.models.animations.ModuleLeg;
import maemesoft.client.models.animations.ModuleTailBasic;
import maemesoft.client.models.animations.quadruped.SkeletonQuadruped;
import maemesoft.entities.maeme.EntityMaeme;

public class ModelMareep extends MaemeModelBase {
	// fields
	MaemeModelRenderer Body;
	MaemeModelRenderer Wool;

	public ModelMareep() {
		textureWidth = 128;
		textureHeight = 64;

		Body = new MaemeModelRenderer(this, "Body");
		Body.setRotationPoint(0, 17, -2);
		Wool = new MaemeModelRenderer(this, "Wool");
		MaemeModelRenderer wool = new MaemeModelRenderer(this, 0, 47);
		wool.addBox(-5F, -2.733333F, -2F, 8, 8, 9);
		wool.setTextureSize(128, 64);
		wool.mirror = true;
		setRotation(wool, 0.0349066F, 0F, 0F);
		Wool.addChild(wool);
		MaemeModelRenderer wool_2 = new MaemeModelRenderer(this, 0, 38);
		wool_2.addBox(-4F, -1.4F, -3F, 6, 6, 2);
		wool_2.setTextureSize(128, 64);
		wool_2.mirror = true;
		setRotation(wool_2, -0.1396263F, 0F, 0F);
		Wool.addChild(wool_2);
		MaemeModelRenderer wool_3 = new MaemeModelRenderer(this, 0, 29);
		wool_3.addBox(-4F, -1.066667F, 6F, 6, 6, 2);
		wool_3.setTextureSize(128, 64);
		wool_3.mirror = true;
		setRotation(wool_3, 0.122173F, 0F, 0F);
		Wool.addChild(wool_3);
		MaemeModelRenderer wool_4 = new MaemeModelRenderer(this, 35, 51);
		wool_4.addBox(1.933333F, -1.733333F, -1F, 2, 6, 7);
		wool_4.setTextureSize(128, 64);
		wool_4.mirror = true;
		setRotation(wool_4, 0.0349066F, 0F, 0F);
		Wool.addChild(wool_4);
		MaemeModelRenderer wool_5 = new MaemeModelRenderer(this, 35, 51);
		wool_5.addBox(-5.733333F, -1.733333F, -1F, 2, 6, 7);
		wool_5.setTextureSize(128, 64);
		wool_5.mirror = true;
		setRotation(wool_5, 0.0349066F, 0F, 0F);
		Wool.addChild(wool_5);
		MaemeModelRenderer wool_6 = new MaemeModelRenderer(this, 28, 41);
		wool_6.addBox(-4F, -3.466667F, -1F, 6, 2, 7);
		wool_6.setTextureSize(128, 64);
		wool_6.mirror = true;
		setRotation(wool_6, 0.0349066F, 0F, 0F);
		Wool.addChild(wool_6);
		Body.addChild(Wool);
		MaemeModelRenderer body = new MaemeModelRenderer(this, 100, 51);
		body.addBox(-4F, 0F, -2F, 6, 5, 8);
		body.setTextureSize(128, 64);
		body.mirror = true;
		setRotation(body, 0.0523599F, 0F, 0F);
		Body.addChild(body);
		MaemeModelRenderer neck = new MaemeModelRenderer(this, 87, 57);
		neck.addBox(-2F, 1.2F, -3F, 2, 3, 4);
		neck.setTextureSize(128, 64);
		neck.mirror = true;
		setRotation(neck, -0.5934119F, 0F, 0F);
		Body.addChild(neck);

		MaemeModelRenderer Head = new MaemeModelRenderer(this, "Head");
		Head.setRotationPoint(-1, 1, -4);
		MaemeModelRenderer head = new MaemeModelRenderer(this, 87, 49);
		head.addBox(-1.5F, -1.933333F, -2.2F, 3, 3, 4);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 1.169371F, 0F, 0F);
		Head.addChild(head);
		MaemeModelRenderer head_2 = new MaemeModelRenderer(this, 78, 59);
		head_2.addBox(0.8F, -1.4F, -1.666667F, 1, 2, 3);
		head_2.setTextureSize(128, 64);
		head_2.mirror = true;
		setRotation(head_2, 1.064651F, 0F, 0.122173F);
		Head.addChild(head_2);
		MaemeModelRenderer head_3 = new MaemeModelRenderer(this, 78, 59);
		head_3.addBox(-1.866667F, -1.4F, -1.666667F, 1, 2, 3);
		head_3.setTextureSize(128, 64);
		head_3.mirror = true;
		setRotation(head_3, 1.064651F, 0F, -0.122173F);
		Head.addChild(head_3);
		MaemeModelRenderer head_fluff = new MaemeModelRenderer(this, 116,
				33);
		head_fluff.addBox(-1.7F, -2.7F, 0.8F, 3, 3, 3);
		head_fluff.setTextureSize(128, 64);
		head_fluff.mirror = true;
		setRotation(head_fluff, 1.099557F, 1.099557F, 0F);
		Head.addChild(head_fluff);
		MaemeModelRenderer L_horn_1 = new MaemeModelRenderer(this, 21, 8);
		L_horn_1.addBox(0.8333333F, -2.4F, -0.5333334F, 2, 2, 2);
		L_horn_1.setTextureSize(128, 64);
		L_horn_1.mirror = true;
		setRotation(L_horn_1, 0F, 0F, 0.1570796F);
		Head.addChild(L_horn_1);
		MaemeModelRenderer L_horn_2 = new MaemeModelRenderer(this, 23, 5);
		L_horn_2.addBox(2.166667F, -2.266667F, -0.1333333F, 1, 1, 1);
		L_horn_2.setTextureSize(128, 64);
		L_horn_2.mirror = true;
		setRotation(L_horn_2, 0F, 0F, 0.296706F);
		Head.addChild(L_horn_2);
		MaemeModelRenderer R_horn_1 = new MaemeModelRenderer(this, 21, 0);
		R_horn_1.addBox(-2.7F, -2.4F, -0.5333334F, 2, 2, 2);
		R_horn_1.setTextureSize(128, 64);
		R_horn_1.mirror = true;
		setRotation(R_horn_1, 0F, 0F, -0.1570796F);
		Head.addChild(R_horn_1);
		MaemeModelRenderer R_horn_2 = new MaemeModelRenderer(this, 23, 5);
		R_horn_2.addBox(-3.166667F, -2.266667F, -0.1333333F, 1, 1, 1);
		R_horn_2.setTextureSize(128, 64);
		R_horn_2.mirror = true;
		setRotation(R_horn_2, 0F, 0F, -0.296706F);
		Head.addChild(R_horn_2);
		Body.addChild(Head);

		MaemeModelRenderer Tail = new MaemeModelRenderer(this, "Tail");
		Tail.setRotationPoint(-1, 2, 6);
		MaemeModelRenderer tail_1 = new MaemeModelRenderer(this, 36, 0);
		tail_1.addBox(-2F, -2F, -1F, 4, 4, 3);
		tail_1.setTextureSize(128, 64);
		tail_1.mirror = true;
		setRotation(tail_1, 0.1919862F, 0F, 0F);
		Tail.addChild(tail_1);
		MaemeModelRenderer tail_2 = new MaemeModelRenderer(this, 37, 8);
		tail_2.addBox(-1.5F, -1.6F, 1.8F, 3, 3, 2);
		tail_2.setTextureSize(128, 64);
		tail_2.mirror = true;
		setRotation(tail_2, 0.2617994F, 0F, 0F);
		Tail.addChild(tail_2);
		MaemeModelRenderer tail_3 = new MaemeModelRenderer(this, 38, 14);
		tail_3.addBox(-1F, -0.8666667F, 3F, 2, 2, 3);
		tail_3.setTextureSize(128, 64);
		tail_3.mirror = true;
		setRotation(tail_3, 0.4014257F, 0F, 0F);
		Tail.addChild(tail_3);
		MaemeModelRenderer tail_4 = new MaemeModelRenderer(this, 42, 20);
		tail_4.addBox(-0.5F, -0.06666667F, 5.533333F, 1, 1, 2);
		tail_4.setTextureSize(128, 64);
		tail_4.mirror = true;
		setRotation(tail_4, 0.4886922F, 0F, 0F);
		Tail.addChild(tail_4);
		MaemeModelRenderer tail_end = new MaemeModelRenderer(this, 38, 24);
		tail_end.addBox(-1.5F, 1.466667F, 6.533333F, 3, 3, 3);
		tail_end.setTextureSize(128, 64);
		tail_end.mirror = true;
		setRotation(tail_end, 0.837758F, 0F, 0F);
		Tail.addChild(tail_end);
		Body.addChild(Tail);

		MaemeModelRenderer FLLeg = new MaemeModelRenderer(this, "FLLeg");
		FLLeg.setRotationPoint(2, 4, 0);
		MaemeModelRenderer F_L_leg = new MaemeModelRenderer(this, 0, 0);
		F_L_leg.addBox(-1.6F, 0F, -1F, 2, 3, 2);
		F_L_leg.setTextureSize(128, 64);
		F_L_leg.mirror = true;
		setRotation(F_L_leg, 0F, 0F, 0F);
		FLLeg.addChild(F_L_leg);
		Body.addChild(FLLeg);

		MaemeModelRenderer FRLeg = new MaemeModelRenderer(this, "FRLeg");
		FRLeg.setRotationPoint(-4, 4, 0);
		MaemeModelRenderer _F_R_leg = new MaemeModelRenderer(this, 0, 0);
		_F_R_leg.addBox(-0.6F, 0F, -1F, 2, 3, 2);
		_F_R_leg.setTextureSize(128, 64);
		_F_R_leg.mirror = true;
		setRotation(_F_R_leg, 0F, 0F, 0F);
		FRLeg.addChild(_F_R_leg);
		Body.addChild(FRLeg);

		MaemeModelRenderer BRLeg = new MaemeModelRenderer(this, "BRLeg");
		BRLeg.setRotationPoint(-4, 4, 5);
		MaemeModelRenderer B_R_leg = new MaemeModelRenderer(this, 0, 0);
		B_R_leg.addBox(-0.6F, 0F, -1F, 2, 3, 2);
		B_R_leg.setTextureSize(128, 64);
		B_R_leg.mirror = true;
		setRotation(B_R_leg, 0F, 0F, 0F);
		BRLeg.addChild(B_R_leg);
		Body.addChild(BRLeg);

		MaemeModelRenderer BLLeg = new MaemeModelRenderer(this, "BLLeg");
		BLLeg.setRotationPoint(2, 4, 5);
		MaemeModelRenderer B_L_leg = new MaemeModelRenderer(this, 0, 0);
		B_L_leg.addBox(-1.6F, 0F, -1F, 2, 3, 2);
		B_L_leg.setTextureSize(128, 64);
		B_L_leg.mirror = true;
		setRotation(B_L_leg, 0F, 0F, 0F);
		BLLeg.addChild(B_L_leg);
		Body.addChild(BLLeg);

		ModuleHead headModule = new ModuleHead(Head);

		float legspeed = 0.8F;
		float legRotationLimit = 1.1F;

		ModuleLeg frontlegLModule = new ModuleLeg(FLLeg, EnumLeg.FrontLeft,
				EnumPhase.OutPhase, legRotationLimit, legspeed);
		ModuleLeg frontlegRModule = new ModuleLeg(FRLeg, EnumLeg.FrontRight,
				EnumPhase.OutPhase, legRotationLimit, legspeed);
		ModuleLeg backlegLModule = new ModuleLeg(BLLeg, EnumLeg.BackLeft,
				EnumPhase.OutPhase, legRotationLimit, legspeed);
		ModuleLeg backlegRModule = new ModuleLeg(BRLeg, EnumLeg.BackRight,
				EnumPhase.OutPhase, legRotationLimit, legspeed);
		ModuleTailBasic tailModule = new ModuleTailBasic(Tail, .2F, .05F, legspeed);

		skeleton = new SkeletonQuadruped(Body, headModule, frontlegLModule,
				frontlegRModule, backlegLModule, backlegRModule, tailModule);

	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		Body.render(f5);
		if (((EntityMaeme) entity).getNumInteractions() == 0)
			Wool.isHidden = true;
		else
			Wool.isHidden = false;
	}

	private void setRotation(MaemeModelRenderer model, float x, float y,
			float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}