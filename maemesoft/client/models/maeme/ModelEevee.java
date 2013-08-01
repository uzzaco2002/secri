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

public class ModelEevee extends MaemeModelBase {
	// fields
	MaemeModelRenderer Body;

	public ModelEevee() {
		textureWidth = 128;
		textureHeight = 64;

		Body = new MaemeModelRenderer(this, "Body");
		Body.setRotationPoint(0, 18, 0);
		MaemeModelRenderer body = new MaemeModelRenderer(this, 0, 55);
		body.addBox(-2F, -1F, -1F, 4, 4, 5);
		body.setTextureSize(128, 64);
		body.mirror = true;
		setRotation(body, -0.0698132F, 0F, 0F);
		MaemeModelRenderer neck = new MaemeModelRenderer(this, 0, 47);
		neck.addBox(-1F, -0.8666667F, -2.2F, 2, 3, 3);
		neck.setTextureSize(128, 64);
		neck.mirror = true;
		setRotation(neck, -0.9773844F, 0F, 0F);
		MaemeModelRenderer main_top = new MaemeModelRenderer(this, 63, 0);
		main_top.addBox(-2F, -1.333333F, -1.8F, 4, 4, 1);
		main_top.setTextureSize(128, 64);
		main_top.mirror = true;
		setRotation(main_top, -0.6457718F, 0F, 0F);
		MaemeModelRenderer mane_front = new MaemeModelRenderer(this, 63,
				7);
		mane_front.addBox(-2F, 1F, -1.666667F, 4, 3, 2);
		mane_front.setTextureSize(128, 64);
		mane_front.mirror = true;
		setRotation(mane_front, -0.1047198F, 0F, 0F);
		MaemeModelRenderer mane_side_L = new MaemeModelRenderer(this, 52,
				6);
		mane_side_L.addBox(1.8F, -2F, -1.133333F, 2, 4, 3);
		mane_side_L.setTextureSize(128, 64);
		mane_side_L.mirror = true;
		setRotation(mane_side_L, -0.4537856F, 0.2094395F, 0.122173F);
		MaemeModelRenderer mane_side_R = new MaemeModelRenderer(this, 59,
				15);
		mane_side_R.addBox(-3.8F, -2F, -1.1F, 2, 4, 3);
		mane_side_R.setTextureSize(128, 64);
		mane_side_R.mirror = true;
		setRotation(mane_side_R, -0.4537856F, -0.2094395F, -0.122173F);
		MaemeModelRenderer back_mane = new MaemeModelRenderer(this, 58,
				24);
		back_mane.addBox(-2.5F, -2.466667F, -0.9333333F, 5, 2, 2);
		back_mane.setTextureSize(128, 64);
		back_mane.mirror = true;
		setRotation(back_mane, -0.4014257F, 0F, 0F);
		MaemeModelRenderer main_mane = new MaemeModelRenderer(this, 0, 0);
		main_mane.addBox(-3F, -2.133333F, -1.533333F, 6, 5, 3);
		main_mane.setTextureSize(128, 64);
		main_mane.mirror = true;
		setRotation(main_mane, -0.5061455F, 0F, 0F);
		Body.addChild(body);
		Body.addChild(neck);
		Body.addChild(main_top);
		Body.addChild(mane_front);
		Body.addChild(mane_side_L);
		Body.addChild(mane_side_R);
		Body.addChild(back_mane);
		Body.addChild(main_mane);

		MaemeModelRenderer Head = new MaemeModelRenderer(this, "Head");
		Head.setRotationPoint(0, -1.8F, -2);
		MaemeModelRenderer head = new MaemeModelRenderer(this, 0, 34);
		head.addBox(-2.5F, -3.266667F, -2.2F, 5, 5, 4);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, -0.0349066F, 0F, 0F);
		MaemeModelRenderer snout = new MaemeModelRenderer(this, 0, 26);
		snout.addBox(-1.5F, -1.066667F, -3F, 3, 2, 3);
		snout.setTextureSize(128, 64);
		snout.mirror = true;
		setRotation(snout, 0.4014257F, 0F, 0F);
		MaemeModelRenderer head_fur = new MaemeModelRenderer(this, 11, 21);
		head_fur.addBox(-2F, -4.8F, -0.9333333F, 4, 2, 1);
		head_fur.setTextureSize(128, 64);
		head_fur.mirror = true;
		setRotation(head_fur, -0.122173F, 0F, 0F);
		MaemeModelRenderer ear_L = new MaemeModelRenderer(this, 23, 27);
		ear_L.addBox(0F, -9.266666F, -0.2666667F, 5, 7, 1);
		ear_L.setTextureSize(128, 64);
		ear_L.mirror = true;
		setRotation(ear_L, -0.0349066F, -0.3141593F, 0.1745329F);
		MaemeModelRenderer ear_R = new MaemeModelRenderer(this, 39, 27);
		ear_R.addBox(-5F, -9.266666F, -0.3F, 5, 7, 1);
		ear_R.setTextureSize(128, 64);
		ear_R.mirror = true;
		setRotation(ear_R, -0.0349066F, 0.3141593F, -0.1745329F);
		Head.addChild(head);
		Head.addChild(snout);
		Head.addChild(head_fur);
		Head.addChild(ear_L);
		Head.addChild(ear_R);

		MaemeModelRenderer FLLeg = new MaemeModelRenderer(this,
				"Front Left Leg");
		FLLeg.setRotationPoint(2, 2, 0);
		MaemeModelRenderer front_leg_L = new MaemeModelRenderer(this, 25,
				0);
		front_leg_L.addBox(-1.266667F, 0F, -1.133333F, 2, 4, 2);
		front_leg_L.setTextureSize(128, 64);
		front_leg_L.mirror = true;
		setRotation(front_leg_L, 0F, 0F, 0F);
		FLLeg.addChild(front_leg_L);

		MaemeModelRenderer FRLeg = new MaemeModelRenderer(this,
				"Front Right Leg");
		FRLeg.setRotationPoint(-2, 2, 0);
		MaemeModelRenderer front_leg_R = new MaemeModelRenderer(this, 25,
				0);
		front_leg_R.addBox(-0.7F, 0F, -1.133333F, 2, 4, 2);
		front_leg_R.setTextureSize(128, 64);
		front_leg_R.mirror = true;
		setRotation(front_leg_R, 0F, 0F, 0F);
		FRLeg.addChild(front_leg_R);

		MaemeModelRenderer BLLeg = new MaemeModelRenderer(this,
				"Back Left Leg");
		BLLeg.setRotationPoint(2, 2, 3);
		MaemeModelRenderer L_leg_1 = new MaemeModelRenderer(this, 35, 0);
		L_leg_1.addBox(-1F, -1F, -1.733333F, 2, 3, 3);
		L_leg_1.setTextureSize(128, 64);
		L_leg_1.mirror = true;
		setRotation(L_leg_1, -0.296706F, 0F, 0F);
		MaemeModelRenderer L_leg_2 = new MaemeModelRenderer(this, 46, 0);
		L_leg_2.addBox(-1.6F, 0.8666667F, -0.8F, 2, 3, 2);
		L_leg_2.setTextureSize(128, 64);
		L_leg_2.mirror = true;
		setRotation(L_leg_2, -0.0349066F, 0F, 0F);
		BLLeg.addChild(L_leg_1);
		BLLeg.addChild(L_leg_2);

		MaemeModelRenderer BRLeg = new MaemeModelRenderer(this,
				"Back Right Leg");
		BRLeg.setRotationPoint(-2, 2, 3);
		MaemeModelRenderer _R_leg_1 = new MaemeModelRenderer(this, 35, 0);
		_R_leg_1.addBox(-1F, -1F, -1.733333F, 2, 3, 3);
		_R_leg_1.setTextureSize(128, 64);
		_R_leg_1.mirror = true;
		setRotation(_R_leg_1, -0.296706F, 0F, 0F);
		MaemeModelRenderer R_leg_2 = new MaemeModelRenderer(this, 46, 0);
		R_leg_2.addBox(-0.6F, 0.8666667F, -0.8F, 2, 3, 2);
		R_leg_2.setTextureSize(128, 64);
		R_leg_2.mirror = true;
		setRotation(R_leg_2, -0.0349066F, 0F, 0F);
		BRLeg.addChild(_R_leg_1);
		BRLeg.addChild(R_leg_2);

		MaemeModelRenderer Tail = new MaemeModelRenderer(this, "Tail");
		Tail.setRotationPoint(0, 0, 4);
		MaemeModelRenderer tail_1 = new MaemeModelRenderer(this, 116, 0);
		tail_1.addBox(-1.5F, -2F, -0.8666667F, 3, 4, 3);
		tail_1.setTextureSize(128, 64);
		tail_1.mirror = true;
		setRotation(tail_1, 0.715585F, 0F, 0F);
		MaemeModelRenderer tail_2 = new MaemeModelRenderer(this, 112, 8);
		tail_2.addBox(-2.5F, -2.533333F, -9.992007E-16F, 5, 5, 3);
		tail_2.setTextureSize(128, 64);
		tail_2.mirror = true;
		setRotation(tail_2, 0.6283185F, 0F, 0F);
		MaemeModelRenderer tail_3 = new MaemeModelRenderer(this, 114, 18);
		tail_3.addBox(-2F, -1.333333F, 2F, 4, 4, 3);
		tail_3.setTextureSize(128, 64);
		tail_3.mirror = true;
		setRotation(tail_3, 0.9075712F, 0F, 0F);
		MaemeModelRenderer tail_4 = new MaemeModelRenderer(this, 116, 27);
		tail_4.addBox(-1.533333F, -0.6F, 2.8F, 3, 3, 3);
		tail_4.setTextureSize(128, 64);
		tail_4.mirror = true;
		setRotation(tail_4, 1.029744F, 0F, 0F);
		MaemeModelRenderer tail_5 = new MaemeModelRenderer(this, 120, 35);
		tail_5.addBox(-1F, 0.5333334F, 4.6F, 2, 2, 2);
		tail_5.setTextureSize(128, 64);
		tail_5.mirror = true;
		setRotation(tail_5, 1.22173F, 0F, 0F);
		MaemeModelRenderer tail_tip = new MaemeModelRenderer(this, 101, 0);
		tail_tip.addBox(-1F, 0.5333334F, 4.6F, 1, 4, 4);
		tail_tip.setTextureSize(128, 64);
		tail_tip.mirror = true;
		setRotation(tail_tip, 1.37881F, 0F, 0F);
		Tail.addChild(tail_1);
		Tail.addChild(tail_2);
		Tail.addChild(tail_3);
		Tail.addChild(tail_4);
		Tail.addChild(tail_5);
		Tail.addChild(tail_tip);

		Body.addChild(Head);
		Body.addChild(FLLeg);
		Body.addChild(FRLeg);
		Body.addChild(BLLeg);
		Body.addChild(BRLeg);
		Body.addChild(Tail);

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

		skeleton = new SkeletonQuadruped(body, headModule, frontlegLModule,
				frontlegRModule, backlegLModule, backlegRModule, tailModule);

	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		Body.render(f5);
	}

	private void setRotation(MaemeModelRenderer model, float x, float y,
			float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}