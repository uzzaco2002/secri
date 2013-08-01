package maemesoft.client.models.maeme;

import net.minecraft.entity.Entity;
import maemesoft.client.models.MaemeModelBase;
import maemesoft.client.models.MaemeModelRenderer;
import maemesoft.client.models.animations.EnumArm;
import maemesoft.client.models.animations.EnumLeg;
import maemesoft.client.models.animations.EnumPhase;
import maemesoft.client.models.animations.ModuleArm;
import maemesoft.client.models.animations.ModuleHead;
import maemesoft.client.models.animations.ModuleLeg;
import maemesoft.client.models.animations.ModuleTailBasic;
import maemesoft.client.models.animations.biped.SkeletonBiped;

public class ModelSquirtle extends MaemeModelBase
{
  //fields
    MaemeModelRenderer Body;
  
  public ModelSquirtle()
  {
    textureWidth = 512;
    textureHeight = 512;
    
    
      Body = new MaemeModelRenderer(this, "Body");
      Body.setRotationPoint(0, 0, 0);
      MaemeModelRenderer Body1 = new MaemeModelRenderer(this, 0, 13);
      Body1.addBox(0F, 0F, 0F, 7, 9, 2);
      Body1.setRotationPoint(-3.5F, 10F, 2F);
      Body1.setTextureSize(512, 512);
      Body1.mirror = true;
      setRotation(Body1, 0F, 0F, 0F);
      MaemeModelRenderer   Body2 = new MaemeModelRenderer(this, 18, 13);
      Body2.addBox(0F, 0F, 0F, 8, 10, 2);
      Body2.setRotationPoint(-4F, 9.5F, 1F);
      Body2.setTextureSize(512, 512);
      Body2.mirror = true;
      setRotation(Body2, 0F, 0F, 0F);
      MaemeModelRenderer   Body3 = new MaemeModelRenderer(this, 38, 13);
      Body3.addBox(0F, 0F, 0F, 6, 8, 2);
      Body3.setRotationPoint(-3F, 10.5F, -0.5F);
      Body3.setTextureSize(512, 512);
      Body3.mirror = true;
      setRotation(Body3, 0F, 0F, 0F);
      MaemeModelRenderer   Body4 = new MaemeModelRenderer(this, 0, 24);
      Body4.addBox(0F, 0F, 0F, 4, 7, 1);
      Body4.setRotationPoint(-2F, 11F, -1.5F);
      Body4.setTextureSize(512, 512);
      Body4.mirror = true;
      setRotation(Body4, 0F, 0F, 0F);
      MaemeModelRenderer   Crouch = new MaemeModelRenderer(this, 0, 0);
      Crouch.addBox(0F, 0F, 0F, 2, 2, 1);
      Crouch.setRotationPoint(-1F, 19F, 2F);
      Crouch.setTextureSize(512, 512);
      Crouch.mirror = true;
      setRotation(Crouch, 0F, 0F, 0F);
      Body.addChild(Body1);
      Body.addChild(Body2);
      Body.addChild(Body3);
      Body.addChild(Body4);
      Body.addChild(Crouch);
      
      
      
      MaemeModelRenderer Head = new MaemeModelRenderer(this, "Head");
      Head.setRotationPoint(0, 9.5F, 2);
      MaemeModelRenderer   HeadMain = new MaemeModelRenderer(this, 66, 0);
      HeadMain.addBox(-3.5F, -7F, -2F, 7, 7, 6);
      HeadMain.setTextureSize(512, 512);
      HeadMain.mirror = true;
      setRotation(HeadMain, 0F, 0F, 0F);
      MaemeModelRenderer   HeadLeft = new MaemeModelRenderer(this, 0, 0);
      HeadLeft.addBox(0F, 0F, 0F, 1, 5, 4);
      HeadLeft.setRotationPoint(-4F, -5.5F, -1F);
      HeadLeft.setTextureSize(512, 512);
      HeadLeft.mirror = true;
      setRotation(HeadLeft, 0F, 0F, 0F);
      MaemeModelRenderer   HeadRight = new MaemeModelRenderer(this, 0, 0);
      HeadRight.addBox(0F, 0F, 0F, 1, 5, 4);
      HeadRight.setRotationPoint(3F, -5.5F, -1F);
      HeadRight.setTextureSize(512, 512);
      HeadRight.mirror = true;
      setRotation(HeadRight, 0F, 0F, 0F);
      Head.addChild(HeadMain);
      Head.addChild(HeadLeft);
      Head.addChild(HeadRight);
      Body.addChild(Head);
      
      
      
      MaemeModelRenderer   LeftArm = new MaemeModelRenderer(this, 0, 0);
      LeftArm.addBox(-2F, 0F, 0F, 2, 2, 5);
      LeftArm.setRotationPoint(-2F, 10F, 3F);
      LeftArm.setTextureSize(512, 512);
      LeftArm.mirror = true;
      setRotation(LeftArm, -0.0569039F, -0.3490659F, 0F);
      Body.addChild(LeftArm);
      
      
      
      MaemeModelRenderer   RightArm = new MaemeModelRenderer(this, 0, 0);
      RightArm.addBox(0F, 0F, 0F, 2, 2, 5);
      RightArm.setRotationPoint(2F, 10F, 3F);
      RightArm.setTextureSize(512, 512);
      RightArm.mirror = true;
      setRotation(RightArm, -0.1563567F, 0.4036978F, 0F);
      Body.addChild(RightArm);
      
      
      
      MaemeModelRenderer   LeftLeg = new MaemeModelRenderer(this, 51, 0);
      LeftLeg.addBox(-1.5F, 0F, -1.5F, 3, 4, 3);
      LeftLeg.setRotationPoint(-3F, 18F, 3F);
      LeftLeg.setTextureSize(512, 512);
      LeftLeg.mirror = true;
      setRotation(LeftLeg, 0F, 0F, -0.0872665F);
      Body.addChild(LeftLeg);
      
      
      
      MaemeModelRenderer   RightLeg = new MaemeModelRenderer(this, 51, 0);
      RightLeg.addBox(-1.5F, 0F, -1.5F, 3, 4, 3);
      RightLeg.setRotationPoint(3F, 18F, 3F);
      RightLeg.setTextureSize(512, 512);
      RightLeg.mirror = true;
      setRotation(RightLeg, 0F, 0F, -0.0872665F);
      Body.addChild(RightLeg);
      
      
      MaemeModelRenderer Tail = new MaemeModelRenderer(this, "Tail");
      Tail.setRotationPoint(0, 19, 2);
      MaemeModelRenderer   TailBase = new MaemeModelRenderer(this, 0, 0);
      TailBase.addBox(-1.5F, 0F, -4F, 3, 2, 4);
      TailBase.setTextureSize(512, 512);
      TailBase.mirror = true;
      setRotation(TailBase, 0F, 0F, 0F);
      MaemeModelRenderer   Tail2 = new MaemeModelRenderer(this, 28, 0);
      Tail2.addBox(0F, 0F, 0F, 3, 3, 4);
      Tail2.setRotationPoint(-1.5F, -2F, -6F);
      Tail2.setTextureSize(512, 512);
      Tail2.mirror = true;
      setRotation(Tail2, -0.3847986F, 0F, 0F);
      MaemeModelRenderer   Tail3 = new MaemeModelRenderer(this, 43, 0);
      Tail3.addBox(0F, 0F, 0F, 1, 2, 4);
      Tail3.setRotationPoint(1F, -1.5F, -6F);
      Tail3.setTextureSize(512, 512);
      Tail3.mirror = true;
      setRotation(Tail3, -0.3839724F, 0F, 0F);
      MaemeModelRenderer   Tail4 = new MaemeModelRenderer(this, 41, 0);
      Tail4.addBox(0F, 0F, 0F, 1, 2, 4);
      Tail4.setRotationPoint(-2F, -1.6F, -6F);
      Tail4.setTextureSize(512, 512);
      Tail4.mirror = true;
      setRotation(Tail4, -0.3839724F, 0F, 0F);
      Tail.addChild(TailBase);
      Tail.addChild(Tail2);
      Tail.addChild(Tail3);
      Tail.addChild(Tail4);
      Body.addChild(Tail);
      
      
      ModuleArm leftArmModule = new ModuleArm(LeftArm, EnumArm.Left, 0, 0, 0);
		ModuleArm rightArmModule = new ModuleArm(RightArm, EnumArm.Right, 0, 0, 0);

		ModuleHead headModule = new ModuleHead(Head);

		float legspeed = 0.5F;
		float legRotationLimit = 1.4F;

		ModuleLeg leftLegModule = new ModuleLeg(LeftLeg, EnumLeg.FrontLeft,
				EnumPhase.InPhase, legRotationLimit, legspeed);
		ModuleLeg rightLegModule = new ModuleLeg(RightLeg, EnumLeg.FrontRight,
				EnumPhase.InPhase, legRotationLimit, legspeed);
		ModuleTailBasic tailModule = new ModuleTailBasic(Tail, .2F, .05F, legspeed);

		skeleton = new SkeletonBiped(Body, headModule, leftArmModule, rightArmModule,
				leftLegModule, rightLegModule, tailModule);
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
    Body.rotateAngleY = (float) Math.toRadians(180);
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
  }

}