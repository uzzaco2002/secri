package maemesoft.client.models.npcs;

import maemesoft.entities.maeme.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelDoctor extends ModelBase {
	// fields
	ModelRenderer Body;
	ModelRenderer Head;
	ModelRenderer LeftArm;
	ModelRenderer RightArm;
	ModelRenderer LeftLeg;
	ModelRenderer RightLeg;

	public ModelDoctor() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this, "Body");
		Body.setRotationPoint(0, -1, 0);
		ModelRenderer body = new ModelRenderer(this, 18, 15);
		body.addBox(-4F, 0F, -2.5F, 8, 11, 5);
		body.setTextureSize(64, 64);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		Body.addChild(body);

		Head = new ModelRenderer(this, "Head");
		Head.setRotationPoint(0, -0.5F, 0);
		ModelRenderer head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.5F, -8F, -3.5F, 7, 8, 7);
		head.setTextureSize(64, 64);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		Head.addChild(head);
		ModelRenderer main1 = new ModelRenderer(this, 0, 51);
		main1.addBox(-4F, -1F, -6F, 8, 1, 12);
		main1.setRotationPoint(0F, -5F, 0F);
		main1.setTextureSize(64, 64);
		main1.mirror = true;
		setRotation(main1, 0F, 0F, 0F);
		Head.addChild(main1);
		ModelRenderer main2 = new ModelRenderer(this, 0, 53);
		main2.addBox(-5F, -1F, -5F, 10, 1, 10);
		main2.setRotationPoint(0F, -5F, 0F);
		main2.setTextureSize(64, 64);
		main2.mirror = true;
		setRotation(main2, 0F, 0F, 0F);
		Head.addChild(main2);
		ModelRenderer sideL = new ModelRenderer(this, 0, 55);
		sideL.addBox(0F, -1F, -4F, 2, 1, 8);
		sideL.setRotationPoint(5F, -5.5F, 0F);
		sideL.setTextureSize(64, 64);
		sideL.mirror = true;
		setRotation(sideL, 0F, 0F, -0.6981317F);
		Head.addChild(sideL);
		ModelRenderer SideR = new ModelRenderer(this, 0, 55);
		SideR.addBox(-2F, -1F, -4F, 2, 1, 8);
		SideR.setRotationPoint(-5F, -5.5F, 0F);
		SideR.setTextureSize(64, 64);
		SideR.mirror = true;
		setRotation(SideR, 0F, 0F, 0.6981317F);
		Head.addChild(SideR);
		ModelRenderer neck = new ModelRenderer(this, 28, 0);
		neck.addBox(-2.5F, -1F, -2.5F, 5, 2, 5);
		neck.setTextureSize(64, 64);
		neck.mirror = true;
		setRotation(neck, 0F, 0F, 0F);
		Head.addChild(neck);
		Body.addChild(Head);

		RightArm = new ModelRenderer(this, "Right Arm");
		RightArm.setRotationPoint(-7, 1, 0);
		ModelRenderer arm_R = new ModelRenderer(this, 44, 15);
		arm_R.addBox(-3F, -1.2F, -2F, 3, 13, 4);
		arm_R.setTextureSize(64, 64);
		arm_R.mirror = true;
		setRotation(arm_R, 0F, 3.14159265F, 0.074351F);
		RightArm.addChild(arm_R);
		Body.addChild(RightArm);

		LeftArm = new ModelRenderer(this, "Left Arm");
		LeftArm.setRotationPoint(4, 1, 0);
		ModelRenderer arm_L = new ModelRenderer(this, 44, 15);
		arm_L.addBox(0F, -1F, -2F, 3, 13, 4);
		arm_L.setTextureSize(64, 64);
		arm_L.mirror = true;
		setRotation(arm_L, 0F, 0F, -0.074351F);
		LeftArm.addChild(arm_L);
		Body.addChild(LeftArm);

		LeftLeg = new ModelRenderer(this, "Left Leg");
		LeftLeg.setRotationPoint(2, 11, 0);
		ModelRenderer Leg_L = new ModelRenderer(this, 0, 15);
		Leg_L.addBox(-2F, 0F, -2.5F, 4, 12, 5);
		Leg_L.setTextureSize(64, 64);
		Leg_L.mirror = true;
		setRotation(Leg_L, 0F, 0F, -0.0174533F);
		LeftLeg.addChild(Leg_L);
		ModelRenderer feet_L = new ModelRenderer(this, 20, 32);
		feet_L.addBox(-2F, 11F, -4.5F, 4, 3, 7);
		feet_L.setTextureSize(64, 64);
		feet_L.mirror = true;
		setRotation(feet_L, 0F, 0F, -0.0174533F);
		LeftLeg.addChild(feet_L);
		Body.addChild(LeftLeg);

		RightLeg = new ModelRenderer(this, "Right Leg");
		RightLeg.setRotationPoint(-2, 11, 0);
		ModelRenderer leg_R = new ModelRenderer(this, 0, 15);
		leg_R.addBox(-2F, 0F, -2.5F, 4, 12, 5);
		leg_R.setTextureSize(64, 64);
		leg_R.mirror = true;
		setRotation(leg_R, 0F, 0F, 0.0174533F);
		RightLeg.addChild(leg_R);
		ModelRenderer feet_R = new ModelRenderer(this, 20, 32);
		feet_R.addBox(-2F, 11F, -4.5F, 4, 3, 7);
		feet_R.setTextureSize(64, 64);
		feet_R.mirror = true;
		setRotation(feet_R, 0F, 0F, 0.0174533F);
		RightLeg.addChild(feet_R);
		Body.addChild(RightLeg);

		ModelRenderer belt_L = new ModelRenderer(this, 24, 47);
		belt_L.addBox(0F, -4F, 0F, 1, 4, 0);
		belt_L.setRotationPoint(1F, 3.55F, -3F);
		belt_L.setTextureSize(64, 64);
		belt_L.mirror = true;
		setRotation(belt_L, -0.1396263F, 0F, 0.418879F);
		Body.addChild(belt_L);
		ModelRenderer belt_R = new ModelRenderer(this, 24, 47);
		belt_R.addBox(-1F, -4F, 0F, 1, 4, 0);
		belt_R.setRotationPoint(-1F, 3.55F, -3F);
		belt_R.setTextureSize(64, 64);
		belt_R.mirror = true;
		setRotation(belt_R, -0.1396263F, 0F, -0.418879F);
		Body.addChild(belt_R);
		ModelRenderer adjustor = new ModelRenderer(this, 40, 50);
		adjustor.addBox(-0.5F, -0.5F, -1F, 1, 3, 1);
		adjustor.setRotationPoint(0F, 4F, -3.5F);
		adjustor.setTextureSize(64, 64);
		adjustor.mirror = true;
		setRotation(adjustor, 0F, 0F, 0F);
		Body.addChild(adjustor);
		ModelRenderer holder = new ModelRenderer(this, 40, 54);
		holder.addBox(-1F, 0F, -1.5F, 2, 2, 2);
		holder.setRotationPoint(0F, 4F, -3.5F);
		holder.setTextureSize(64, 64);
		holder.mirror = true;
		setRotation(holder, 0F, 0F, 0F);
		Body.addChild(holder);
		ModelRenderer look_L = new ModelRenderer(this, 44, 51);
		look_L.addBox(0F, -1.5F, -0.5F, 1, 2, 1);
		look_L.setRotationPoint(0.9F, 3.5F, -4F);
		look_L.setTextureSize(64, 64);
		look_L.mirror = true;
		setRotation(look_L, 0F, -0.2094395F, 0F);
		Body.addChild(look_L);
		ModelRenderer spy_L = new ModelRenderer(this, 40, 58);
		spy_L.addBox(-0.2F, 0F, -1F, 2, 4, 2);
		spy_L.setRotationPoint(0.9F, 3.5F, -4F);
		spy_L.setTextureSize(64, 64);
		spy_L.mirror = true;
		setRotation(spy_L, 0F, -0.2094395F, 0F);
		Body.addChild(spy_L);
		ModelRenderer look_R = new ModelRenderer(this, 44, 51);
		look_R.addBox(-1F, -1.5F, -0.5F, 1, 2, 1);
		look_R.setRotationPoint(-0.9F, 3.5F, -4F);
		look_R.setTextureSize(64, 64);
		look_R.mirror = true;
		setRotation(look_R, 0F, 0.2094395F, 0F);
		Body.addChild(look_R);
		ModelRenderer spy_R = new ModelRenderer(this, 40, 58);
		spy_R.addBox(-1.8F, 0F, -1F, 2, 4, 2);
		spy_R.setRotationPoint(-0.9F, 3.5F, -4F);
		spy_R.setTextureSize(64, 64);
		spy_R.mirror = true;
		setRotation(spy_R, 0F, 0.2094395F, 0F);
		Body.addChild(spy_R);
		ModelRenderer backpack = new ModelRenderer(this, 0, 34);
		backpack.addBox(-3.5F, 0F, 0F, 7, 8, 3);
		backpack.setRotationPoint(0F, 1F, 2.5F);
		backpack.setTextureSize(64, 64);
		backpack.mirror = true;
		setRotation(backpack, 0F, 0F, 0F);
		Body.addChild(backpack);
		ModelRenderer sleepbag = new ModelRenderer(this, 0, 45);
		sleepbag.addBox(-4.5F, -1.5F, -1.5F, 9, 3, 3);
		sleepbag.setRotationPoint(0F, 0.5F, 4.5F);
		sleepbag.setTextureSize(64, 64);
		sleepbag.mirror = true;
		setRotation(sleepbag, 0.7853982F, 0F, 0F);
		Body.addChild(sleepbag);

	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);

		Body.render(f5);

	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		RightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		LeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		RightLeg.rotateAngleY = 0.0F;
		LeftLeg.rotateAngleY = 0.0F;
		RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * .5F * f1;
		LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * .5F * f1;
	}

}