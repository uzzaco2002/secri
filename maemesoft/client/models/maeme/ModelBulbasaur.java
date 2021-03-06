package maemesoft.client.models.maeme;

import net.minecraft.entity.Entity;
import maemesoft.client.models.MaemeModelBase;
import maemesoft.client.models.MaemeModelRenderer;
import maemesoft.client.models.animations.EnumLeg;
import maemesoft.client.models.animations.EnumPhase;
import maemesoft.client.models.animations.ModuleHead;
import maemesoft.client.models.animations.ModuleLeg;
import maemesoft.client.models.animations.quadruped.SkeletonQuadruped;

public class ModelBulbasaur extends MaemeModelBase
{
  //fields
    MaemeModelRenderer Body;
  
  public ModelBulbasaur()
  {
    textureWidth = 128;
    textureHeight = 64;
    
    
      Body = new MaemeModelRenderer(this, "Body");
      Body.setRotationPoint(0, 17, 1.2F);
      MaemeModelRenderer  Body_Middle = new MaemeModelRenderer(this, 0, 0);
      Body_Middle.addBox(-4F, -1F, -5F, 8, 5, 10);
      Body_Middle.setTextureSize(128, 64);
      Body_Middle.mirror = true;
      setRotation(Body_Middle, -0.2617994F, 0F, 0F);
      MaemeModelRenderer  Body_Top = new MaemeModelRenderer(this, 36, 0);
      Body_Top.addBox(-3F, -2F, -5F, 6, 1, 10);
      Body_Top.setTextureSize(128, 64);
      Body_Top.mirror = true;
      setRotation(Body_Top, -0.2617994F, 0F, 0F);
      MaemeModelRenderer  Body_Bottom = new MaemeModelRenderer(this, 68, 0);
      Body_Bottom.addBox(-3F, 3.5F, -5F, 6, 1, 10);
      Body_Bottom.setTextureSize(128, 64);
      Body_Bottom.mirror = true;
      setRotation(Body_Bottom, -0.2617994F, 0F, 0F);
      MaemeModelRenderer  Body_Back = new MaemeModelRenderer(this, 36, 11);
      Body_Back.addBox(-3F, -1F, 5F, 6, 5, 1);
      Body_Back.setTextureSize(128, 64);
      Body_Back.mirror = true;
      setRotation(Body_Back, -0.2617994F, 0F, 0F);
      Body.addChild(Body_Middle);
      Body.addChild(Body_Top);
      Body.addChild(Body_Bottom);
      Body.addChild(Body_Back);
      
      
      MaemeModelRenderer Head = new MaemeModelRenderer(this, "Head");
      Head.setRotationPoint(0, -1.5F, -4.2F);
      MaemeModelRenderer  Head_Top = new MaemeModelRenderer(this, 100, 26);
      Head_Top.addBox(-3F, -3.5F, -4F, 6, 1, 4);
      Head_Top.setTextureSize(128, 64);
      Head_Top.mirror = true;
      setRotation(Head_Top, 0F, 0F, 0F);
      MaemeModelRenderer  Head_Front = new MaemeModelRenderer(this, 100, 11);
      Head_Front.addBox(-4F, -5.7F, -4.4F, 8, 3, 6);
      Head_Front.setTextureSize(128, 64);
      Head_Front.mirror = true;
      setRotation(Head_Front, 1.308997F, 0F, 0F);
      MaemeModelRenderer  Head_Bottom = new MaemeModelRenderer(this, 100, 20);
      Head_Bottom.addBox(-3.5F, 2.6F, -5F, 7, 1, 5);
      Head_Bottom.setTextureSize(128, 64);
      Head_Bottom.mirror = true;
      setRotation(Head_Bottom, 0F, 0F, 0F);
      MaemeModelRenderer  Head_Back = new MaemeModelRenderer(this, 100, 0);
      Head_Back.addBox(-4F, -3F, -5F, 8, 6, 5);
      Head_Back.setTextureSize(128, 64);
      Head_Back.mirror = true;
      setRotation(Head_Back, 0F, 0F, 0F);
      MaemeModelRenderer  Ear_Left = new MaemeModelRenderer(this, 96, 11);
      Ear_Left.addBox(-0.5F, 0F, 0F, 1, 3, 1);
      Ear_Left.setRotationPoint(3.5F, -4.5F, -1.5F);
      Ear_Left.setTextureSize(128, 64);
      Ear_Left.mirror = true;
      setRotation(Ear_Left, -0.3490659F, 0F, 0F);
      MaemeModelRenderer  Ear_Tip_Left = new MaemeModelRenderer(this, 96, 15);
      Ear_Tip_Left.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
      Ear_Tip_Left.setRotationPoint(3.5F, -4.5F, -1F);
      Ear_Tip_Left.setTextureSize(128, 64);
      Ear_Tip_Left.mirror = true;
      setRotation(Ear_Tip_Left, 0F, 0F, 0F);
      MaemeModelRenderer  Ear_Right = new MaemeModelRenderer(this, 92, 11);
      Ear_Right.addBox(-0.5F, 0F, 0F, 1, 3, 1);
      Ear_Right.setRotationPoint(-3.5F, -4.5F, -1.5F);
      Ear_Right.setTextureSize(128, 64);
      Ear_Right.mirror = true;
      setRotation(Ear_Right, -0.3490659F, 0F, 0F);
      MaemeModelRenderer  Ear_Tip_Right = new MaemeModelRenderer(this, 92, 15);
      Ear_Tip_Right.addBox(-0.5F, 0F, -0.5F, 1, 2, 1);
      Ear_Tip_Right.setRotationPoint(-3.5F, -4.5F, -1F);
      Ear_Tip_Right.setTextureSize(128, 64);
      Ear_Tip_Right.mirror = true;
      setRotation(Ear_Tip_Right, 0F, 0F, 0F);
      Head.addChild(Head_Top);
      Head.addChild(Head_Front);
      Head.addChild(Head_Bottom);
      Head.addChild(Head_Back);
      Head.addChild(Ear_Left);
      Head.addChild(Ear_Tip_Left);
      Head.addChild(Ear_Right);
      Head.addChild(Ear_Tip_Right);
      Body.addChild(Head);
      
      
      
      MaemeModelRenderer  Front_Leg_Left = new MaemeModelRenderer(this, 0, 27);
      Front_Leg_Left.addBox(-1F, 0F, -1.5F, 2, 7, 3);
      Front_Leg_Left.setRotationPoint(4F, 0F, -3.2F);
      Front_Leg_Left.setTextureSize(128, 64);
      Front_Leg_Left.mirror = true;
      setRotation(Front_Leg_Left, 0F, 0F, 0F);
      Body.addChild(Front_Leg_Left);
      
      
      MaemeModelRenderer Front_Leg_Right = new MaemeModelRenderer(this, 10, 27);
      Front_Leg_Right.addBox(-1F, 0F, -1.5F, 2, 7, 3);
      Front_Leg_Right.setRotationPoint(-4F, 0F, -3.2F);
      Front_Leg_Right.setTextureSize(128, 64);
      Front_Leg_Right.mirror = true;
      setRotation(Front_Leg_Right, 0F, 0F, 0F);
      Body.addChild(Front_Leg_Right);
      
      
      
      
      MaemeModelRenderer BLLeg = new MaemeModelRenderer(this, "Back Left Leg");
      BLLeg.setRotationPoint(4.5F, 2, 2.8F);
      MaemeModelRenderer  Rear_Leg_Top_Left = new MaemeModelRenderer(this, 0, 37);
      Rear_Leg_Top_Left.addBox(-1F, -1F, -1.5F, 2, 1, 3);
      Rear_Leg_Top_Left.setTextureSize(128, 64);
      Rear_Leg_Top_Left.mirror = true;
      setRotation(Rear_Leg_Top_Left, 0F, 0F, 0F);
      MaemeModelRenderer  Rear_Leg_Middle_Left = new MaemeModelRenderer(this, 0, 15);
      Rear_Leg_Middle_Left.addBox(-1.5F, 0F, -2F, 3, 4, 4);
      Rear_Leg_Middle_Left.setTextureSize(128, 64);
      Rear_Leg_Middle_Left.mirror = true;
      setRotation(Rear_Leg_Middle_Left, 0F, 0F, 0F);
      MaemeModelRenderer  Rear_Leg_Bottom_Left = new MaemeModelRenderer(this, 0, 23);
      Rear_Leg_Bottom_Left.addBox(-1F, 4F, -1.5F, 2, 1, 3);
      Rear_Leg_Bottom_Left.setTextureSize(128, 64);
      Rear_Leg_Bottom_Left.mirror = true;
      setRotation(Rear_Leg_Bottom_Left, 0F, 0F, 0F);
      BLLeg.addChild(Rear_Leg_Top_Left);
      BLLeg.addChild(Rear_Leg_Middle_Left);
      BLLeg.addChild(Rear_Leg_Bottom_Left);
      Body.addChild(BLLeg);
      
      
      
      MaemeModelRenderer BRLeg = new MaemeModelRenderer(this, "Back Right Leg");
      BRLeg.setRotationPoint(-4.5F, 2, 2.8F);
      MaemeModelRenderer   Rear_Leg_Top_Right = new MaemeModelRenderer(this, 10, 37);
      Rear_Leg_Top_Right.addBox(-1F, -1F, -1.5F, 2, 1, 3);
      Rear_Leg_Top_Right.setTextureSize(128, 64);
      Rear_Leg_Top_Right.mirror = true;
      setRotation(Rear_Leg_Top_Right, 0F, 0F, 0F);
      MaemeModelRenderer   Rear_Leg_Middle_Right = new MaemeModelRenderer(this, 14, 15);
      Rear_Leg_Middle_Right.addBox(-1.5F, 0F, -2F, 3, 4, 4);
      Rear_Leg_Middle_Right.setTextureSize(128, 64);
      Rear_Leg_Middle_Right.mirror = true;
      setRotation(Rear_Leg_Middle_Right, 0F, 0F, 0F);
      MaemeModelRenderer   Rear_Leg_Bottom_Right = new MaemeModelRenderer(this, 10, 23);
      Rear_Leg_Bottom_Right.addBox(-1F, 4F, -1.5F, 2, 1, 3);
      Rear_Leg_Bottom_Right.setTextureSize(128, 64);
      Rear_Leg_Bottom_Right.mirror = true;
      setRotation(Rear_Leg_Bottom_Right, 0F, 0F, 0F);
      BRLeg.addChild(Rear_Leg_Top_Right);
      BRLeg.addChild(Rear_Leg_Middle_Right);
      BRLeg.addChild(Rear_Leg_Bottom_Right);
      Body.addChild(BRLeg);
      
      
      
      
      MaemeModelRenderer  Bulb_Bottom_Middle = new MaemeModelRenderer(this, 36, 17);
      Bulb_Bottom_Middle.addBox(-3F, -4F, -4F, 6, 4, 8);
      Bulb_Bottom_Middle.setRotationPoint(0F, -0.9F, 1.2F);
      Bulb_Bottom_Middle.setTextureSize(128, 64);
      Bulb_Bottom_Middle.mirror = true;
      setRotation(Bulb_Bottom_Middle, 0F, -0.7853982F, 0F);
      MaemeModelRenderer  Bulb_Bottom_Left = new MaemeModelRenderer(this, 36, 29);
      Bulb_Bottom_Left.addBox(-4F, -4F, -3F, 1, 4, 6);
      Bulb_Bottom_Left.setRotationPoint(0F, -0.9F, 1.2F);
      Bulb_Bottom_Left.setTextureSize(128, 64);
      Bulb_Bottom_Left.mirror = true;
      setRotation(Bulb_Bottom_Left, 0F, -0.7853982F, 0F);
      MaemeModelRenderer  Bulb_Bottom_Right = new MaemeModelRenderer(this, 50, 29);
      Bulb_Bottom_Right.addBox(3F, -4F, -3F, 1, 4, 6);
      Bulb_Bottom_Right.setRotationPoint(0F, -0.9F, 1.2F);
      Bulb_Bottom_Right.setTextureSize(128, 64);
      Bulb_Bottom_Right.mirror = true;
      setRotation(Bulb_Bottom_Right, 0F, -0.7853982F, 0F);
      MaemeModelRenderer  Bulb_Middle_Middle = new MaemeModelRenderer(this, 36, 39);
      Bulb_Middle_Middle.addBox(-2F, -6F, -3F, 4, 2, 6);
      Bulb_Middle_Middle.setRotationPoint(0F, -0.9F, 1.2F);
      Bulb_Middle_Middle.setTextureSize(128, 64);
      Bulb_Middle_Middle.mirror = true;
      setRotation(Bulb_Middle_Middle, 0F, -0.7853982F, 0F);
      MaemeModelRenderer  Bulb_Middle_Left = new MaemeModelRenderer(this, 36, 47);
      Bulb_Middle_Left.addBox(-3F, -6F, -2F, 1, 2, 4);
      Bulb_Middle_Left.setRotationPoint(0F, -0.9F, 1.2F);
      Bulb_Middle_Left.setTextureSize(128, 64);
      Bulb_Middle_Left.mirror = true;
      setRotation(Bulb_Middle_Left, 0F, -0.7853982F, 0F);
      MaemeModelRenderer  Bulb_Middle_Right = new MaemeModelRenderer(this, 46, 47);
      Bulb_Middle_Right.addBox(2F, -6F, -2F, 1, 2, 4);
      Bulb_Middle_Right.setRotationPoint(0F, -0.9F, 1.2F);
      Bulb_Middle_Right.setTextureSize(128, 64);
      Bulb_Middle_Right.mirror = true;
      setRotation(Bulb_Middle_Right, 0F, -0.7853982F, 0F);
      MaemeModelRenderer  Bulb_Top = new MaemeModelRenderer(this, 36, 53);
      Bulb_Top.addBox(-1.5F, -6.5F, -1.5F, 3, 1, 3);
      Bulb_Top.setRotationPoint(0F, -0.9F, 1.2F);
      Bulb_Top.setTextureSize(128, 64);
      Bulb_Top.mirror = true;
      setRotation(Bulb_Top, 0F, -0.7853982F, 0F);
      MaemeModelRenderer  Bulb_Tip = new MaemeModelRenderer(this, 36, 57);
      Bulb_Tip.addBox(-1F, -8.5F, -1F, 2, 2, 2);
      Bulb_Tip.setRotationPoint(0F, -0.9F, 1.2F);
      Bulb_Tip.setTextureSize(128, 64);
      Bulb_Tip.mirror = true;
      setRotation(Bulb_Tip, 0F, -0.7853982F, 0F);
      Body.addChild(Bulb_Bottom_Middle);
      Body.addChild(Bulb_Bottom_Left);
      Body.addChild(Bulb_Bottom_Right);
      Body.addChild(Bulb_Middle_Middle);
      Body.addChild(Bulb_Middle_Left);
      Body.addChild(Bulb_Middle_Right);
      Body.addChild(Bulb_Top);
      Body.addChild(Bulb_Tip);
      
      
      float legspeed = 0.8F;
		float legRotationLimit = 1.1F;
    ModuleLeg frontlegLModule = new ModuleLeg(Front_Leg_Left, EnumLeg.FrontLeft,
				EnumPhase.OutPhase, legRotationLimit, legspeed);
		ModuleLeg frontlegRModule = new ModuleLeg(Front_Leg_Right, EnumLeg.FrontRight,
				EnumPhase.OutPhase, legRotationLimit, legspeed);
		ModuleLeg backlegLModule = new ModuleLeg(BLLeg, EnumLeg.BackLeft,
				EnumPhase.OutPhase, legRotationLimit, legspeed);
		ModuleLeg backlegRModule = new ModuleLeg(BRLeg, EnumLeg.BackRight,
				EnumPhase.OutPhase, legRotationLimit, legspeed);
    
    
    
    ModuleHead headModule = new ModuleHead(Head);
		skeleton = new SkeletonQuadruped(Body, headModule, frontlegLModule, frontlegRModule, 
				backlegLModule, backlegRModule, null);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Body.render(f5);
  }
  
  private void setRotation(MaemeModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
  }

}