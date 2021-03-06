package maemesoft.client.models.maeme;

import net.minecraft.entity.Entity;
import maemesoft.client.models.MaemeModelBase;
import maemesoft.client.models.MaemeModelRenderer;
import maemesoft.client.models.animations.ModuleHead;
import maemesoft.client.models.animations.SkeletonBase;
import maemesoft.client.models.animations.serpent.SkeletonSerpent;

public class ModelAbra extends MaemeModelBase
{
  //fields
    MaemeModelRenderer Body;
    
  
  public ModelAbra()
  {
    textureWidth = 128;
    textureHeight = 64;
    
    
      Body = new MaemeModelRenderer(this, "Body");
      Body.setRotationPoint(0, 18, 0);
      MaemeModelRenderer  Body_Middle = new MaemeModelRenderer(this, 0, 0);
      Body_Middle.addBox(-2.5F, -6F, -1.5F, 5, 12, 3);
      Body_Middle.setTextureSize(128, 64);
      Body_Middle.mirror = true;
      setRotation(Body_Middle, 0F, 0F, 0F);
      MaemeModelRenderer  Body_Front = new MaemeModelRenderer(this, 16, 0);
      Body_Front.addBox(-2.5F, -5F, -2.5F, 5, 10, 1);
      Body_Front.setTextureSize(128, 64);
      Body_Front.mirror = true;
      setRotation(Body_Front, 0F, 0F, 0F);
      MaemeModelRenderer  Body_Back = new MaemeModelRenderer(this, 28, 0);
      Body_Back.addBox(-2.5F, -5F, 1.5F, 5, 10, 1);
      Body_Back.setTextureSize(128, 64);
      Body_Back.mirror = true;
      setRotation(Body_Back, 0F, 0F, 0F);
      MaemeModelRenderer  Body_Left = new MaemeModelRenderer(this, 0, 15);
      Body_Left.addBox(2.5F, -5F, -1.5F, 1, 10, 3);
      Body_Left.setTextureSize(128, 64);
      Body_Left.mirror = true;
      setRotation(Body_Left, 0F, 0F, 0F);
      MaemeModelRenderer  Body_Right = new MaemeModelRenderer(this, 8, 15);
      Body_Right.addBox(-3.5F, -5F, -1.5F, 1, 10, 3);
      Body_Right.setTextureSize(128, 64);
      Body_Right.mirror = true;
      setRotation(Body_Right, 0F, 0F, 0F);
      Body.addChild(Body_Middle);
      Body.addChild(Body_Front);
      Body.addChild(Body_Back);
      Body.addChild(Body_Left);
      Body.addChild(Body_Right);
      
      
      
      MaemeModelRenderer LeftLeg = new MaemeModelRenderer(this, "Left Leg");
      LeftLeg.setRotationPoint(2.5F, 4.5F, -1.5F);
      MaemeModelRenderer  Leg_Base_Left = new MaemeModelRenderer(this, 0, 28);
      Leg_Base_Left.addBox(-1F, -1F, -4F, 2, 2, 4);
      Leg_Base_Left.setTextureSize(128, 64);
      Leg_Base_Left.mirror = true;
      setRotation(Leg_Base_Left, 0F, -0.5235988F, 0F);
      MaemeModelRenderer  Leg_Middle_Left = new MaemeModelRenderer(this, 0, 34);
      Leg_Middle_Left.addBox(-1.5F, -2.5F, -4.5F, 3, 4, 1);
      Leg_Middle_Left.setTextureSize(128, 64);
      Leg_Middle_Left.mirror = true;
      setRotation(Leg_Middle_Left, 0F, -0.5235988F, 0F);
      MaemeModelRenderer  Leg_Front_Left = new MaemeModelRenderer(this, 0, 39);
      Leg_Front_Left.addBox(-1.5F, -1.5F, -8.5F, 3, 3, 4);
      Leg_Front_Left.setTextureSize(128, 64);
      Leg_Front_Left.mirror = true;
      setRotation(Leg_Front_Left, 0F, -0.5235988F, 0F);
      MaemeModelRenderer  Toe_Top_Left_Left = new MaemeModelRenderer(this, 0, 46);
      Toe_Top_Left_Left.addBox(-1.5F, -9F, -5.5F, 1, 3, 1);
      Toe_Top_Left_Left.setTextureSize(128, 64);
      Toe_Top_Left_Left.mirror = true;
      setRotation(Toe_Top_Left_Left, 0.7853982F, -0.5235988F, 0F);
      MaemeModelRenderer  Toe_Top_Left_Tip_Left = new MaemeModelRenderer(this, 0, 50);
      Toe_Top_Left_Tip_Left.addBox(-1.5F, 7F, -7.5F, 1, 1, 1);
      Toe_Top_Left_Tip_Left.setTextureSize(128, 64);
      Toe_Top_Left_Tip_Left.mirror = true;
      setRotation(Toe_Top_Left_Tip_Left, -1.047198F, -0.5235988F, 0F);
      MaemeModelRenderer  Toe_Top_Right_Left = new MaemeModelRenderer(this, 4, 46);
      Toe_Top_Right_Left.addBox(0.5F, -9F, -5.5F, 1, 3, 1);
      Toe_Top_Right_Left.setTextureSize(128, 64);
      Toe_Top_Right_Left.mirror = true;
      setRotation(Toe_Top_Right_Left, 0.7853982F, -0.5235988F, 0F);
      MaemeModelRenderer  Toe_Top_Right_Tip_Left = new MaemeModelRenderer(this, 4, 50);
      Toe_Top_Right_Tip_Left.addBox(0.5F, 7F, -7.5F, 1, 1, 1);
      Toe_Top_Right_Tip_Left.setTextureSize(128, 64);
      Toe_Top_Right_Tip_Left.mirror = true;
      setRotation(Toe_Top_Right_Tip_Left, -1.047198F, -0.5235988F, 0F);
      MaemeModelRenderer  Toe_Bottom_Left = new MaemeModelRenderer(this, 8, 46);
      Toe_Bottom_Left.addBox(-0.5F, -10F, -1.5F, 1, 3, 1);
      Toe_Bottom_Left.setTextureSize(128, 64);
      Toe_Bottom_Left.mirror = true;
      setRotation(Toe_Bottom_Left, 1.570796F, -0.5235988F, 0F);
      MaemeModelRenderer  Toe_Bottom_Tip_Left = new MaemeModelRenderer(this, 8, 50);
      Toe_Bottom_Tip_Left.addBox(-0.5F, -8.9F, -6.3F, 1, 1, 1);
      Toe_Bottom_Tip_Left.setTextureSize(128, 64);
      Toe_Bottom_Tip_Left.mirror = true;
      setRotation(Toe_Bottom_Tip_Left, 1.047198F, -0.5235988F, 0F);
      LeftLeg.addChild(Leg_Base_Left);
      LeftLeg.addChild(Leg_Middle_Left);
      LeftLeg.addChild(Leg_Front_Left);
      LeftLeg.addChild(Toe_Top_Left_Left);
      LeftLeg.addChild(Toe_Top_Left_Tip_Left);
      LeftLeg.addChild(Toe_Top_Right_Left);
      LeftLeg.addChild(Toe_Top_Right_Tip_Left);
      LeftLeg.addChild(Toe_Bottom_Left);
      LeftLeg.addChild(Toe_Bottom_Tip_Left);
      Body.addChild(LeftLeg);
      
      
      
      
      MaemeModelRenderer LeftArm = new MaemeModelRenderer(this, "Left Arm");
      LeftArm.setRotationPoint(3, -3.5F, 0);
      MaemeModelRenderer  Shoulder_Top_Left = new MaemeModelRenderer(this, 0, 52);
      Shoulder_Top_Left.addBox(0F, -2F, -1.5F, 3, 1, 3);
      Shoulder_Top_Left.setTextureSize(128, 64);
      Shoulder_Top_Left.mirror = true;
      setRotation(Shoulder_Top_Left, 0F, 0F, 0F);
      MaemeModelRenderer  Shoulder_Front_Left = new MaemeModelRenderer(this, 12, 52);
      Shoulder_Front_Left.addBox(0F, -1F, -1.5F, 3, 2, 1);
      Shoulder_Front_Left.setTextureSize(128, 64);
      Shoulder_Front_Left.mirror = true;
      setRotation(Shoulder_Front_Left, 0F, 0F, 0F);
      MaemeModelRenderer  Shoulder_Back_Left = new MaemeModelRenderer(this, 12, 55);
      Shoulder_Back_Left.addBox(0F, -1F, 0.5F, 3, 2, 1);
      Shoulder_Back_Left.setTextureSize(128, 64);
      Shoulder_Back_Left.mirror = true;
      setRotation(Shoulder_Back_Left, 0F, 0F, 0F);
      MaemeModelRenderer  Shoulder_Tip_Left = new MaemeModelRenderer(this, 8, 58);
      Shoulder_Tip_Left.addBox(2.1F, 0.4F, -1F, 1, 2, 2);
      Shoulder_Tip_Left.setTextureSize(128, 64);
      Shoulder_Tip_Left.mirror = true;
      setRotation(Shoulder_Tip_Left, 0F, 0F, -0.5235988F);
      MaemeModelRenderer  Arm_Base_Left = new MaemeModelRenderer(this, 0, 58);
      Arm_Base_Left.addBox(1F, 0F, -0.5F, 1, 5, 1);
      Arm_Base_Left.setTextureSize(128, 64);
      Arm_Base_Left.mirror = true;
      setRotation(Arm_Base_Left, 0F, 0F, -0.2617994F);
      MaemeModelRenderer  Arm_Middle_Left = new MaemeModelRenderer(this, 16, 22);
      Arm_Middle_Left.addBox(0.5F, 4F, -1F, 2, 1, 2);
      Arm_Middle_Left.setTextureSize(128, 64);
      Arm_Middle_Left.mirror = true;
      setRotation(Arm_Middle_Left, 0F, 0F, -0.2617994F);
      MaemeModelRenderer  Arm_Main_Left = new MaemeModelRenderer(this, 16, 11);
      Arm_Main_Left.addBox(0.5F, 5F, -1.5F, 2, 4, 3);
      Arm_Main_Left.setTextureSize(128, 64);
      Arm_Main_Left.mirror = true;
      setRotation(Arm_Main_Left, 0F, 0F, -0.2617994F);
      MaemeModelRenderer  Finger_Middle_Left = new MaemeModelRenderer(this, 16, 18);
      Finger_Middle_Left.addBox(-3F, 7F, -0.5F, 1, 3, 1);
      Finger_Middle_Left.setTextureSize(128, 64);
      Finger_Middle_Left.mirror = true;
      setRotation(Finger_Middle_Left, 0F, 0F, -0.7853982F);
      MaemeModelRenderer  Finger_Front_Left = new MaemeModelRenderer(this, 20, 18);
      Finger_Front_Left.addBox(-3F, 7F, 0.5F, 1, 3, 1);
      Finger_Front_Left.setTextureSize(128, 64);
      Finger_Front_Left.mirror = true;
      setRotation(Finger_Front_Left, 0F, 0.5235988F, -0.7853982F);
      MaemeModelRenderer  Finger_Back_Left = new MaemeModelRenderer(this, 24, 18);
      Finger_Back_Left.addBox(-3F, 7F, -1.5F, 1, 3, 1);
      Finger_Back_Left.setTextureSize(128, 64);
      Finger_Back_Left.mirror = true;
      setRotation(Finger_Back_Left, 0F, -0.5235988F, -0.7853982F);
      LeftArm.addChild(Shoulder_Top_Left);
      LeftArm.addChild(Shoulder_Front_Left);
      LeftArm.addChild(Shoulder_Back_Left);
      LeftArm.addChild(Shoulder_Tip_Left);
      LeftArm.addChild(Arm_Base_Left);
      LeftArm.addChild(Arm_Middle_Left);
      LeftArm.addChild(Arm_Main_Left);
      LeftArm.addChild(Finger_Middle_Left);
      LeftArm.addChild(Finger_Front_Left);
      LeftArm.addChild(Finger_Back_Left);
      Body.addChild(LeftArm);
      
      
      MaemeModelRenderer Tail = new MaemeModelRenderer(this, "Tail");
      Tail.setRotationPoint(0, 3, 2.5F);
      MaemeModelRenderer  Tail_Base = new MaemeModelRenderer(this, 58, 0);
      Tail_Base.addBox(-2F, -2F, 0F, 4, 4, 4);
      Tail_Base.setTextureSize(128, 64);
      Tail_Base.mirror = true;
      setRotation(Tail_Base, 0F, 0F, 0F);
      MaemeModelRenderer  Tail_Middle = new MaemeModelRenderer(this, 74, 0);
      Tail_Middle.addBox(-1.5F, -0.5F, 3F, 3, 3, 4);
      Tail_Middle.setTextureSize(128, 64);
      Tail_Middle.mirror = true;
      setRotation(Tail_Middle, 0.5235988F, 0F, 0F);
      MaemeModelRenderer  Tail_Back = new MaemeModelRenderer(this, 88, 0);
      Tail_Back.addBox(-1F, 3F, 5F, 2, 2, 4);
      Tail_Back.setTextureSize(128, 64);
      Tail_Back.mirror = true;
      setRotation(Tail_Back, 1.047198F, 0F, 0F);
      MaemeModelRenderer  Tail_Tip = new MaemeModelRenderer(this, 100, 0);
      Tail_Tip.addBox(-0.5F, 7F, 5.5F, 1, 1, 2);
      Tail_Tip.setTextureSize(128, 64);
      Tail_Tip.mirror = true;
      setRotation(Tail_Tip, 1.570796F, 0F, 0F);
      MaemeModelRenderer  Neck = new MaemeModelRenderer(this, 40, 0);
      Tail.addChild(Tail_Base);
      Tail.addChild(Tail_Middle);
      Tail.addChild(Tail_Back);
      Tail.addChild(Tail_Tip);
      Body.addChild(Tail);
      
      
      
      MaemeModelRenderer Head = new MaemeModelRenderer(this, "Head");
      Head.setRotationPoint(0, -6, 0);
      Neck.addBox(-2F, -1F, -2F, 4, 1, 5);
      Neck.setTextureSize(128, 64);
      Neck.mirror = true;
      setRotation(Neck, 0F, 0F, 0F);
      MaemeModelRenderer  Head_Base = new MaemeModelRenderer(this, 52, 8);
      Head_Base.addBox(-4F, -4.5F, -3.5F, 8, 4, 7);
      Head_Base.setTextureSize(128, 64);
      Head_Base.mirror = true;
      setRotation(Head_Base, 0F, 0F, 0F);
      MaemeModelRenderer  Head_Middle = new MaemeModelRenderer(this, 52, 19);
      Head_Middle.addBox(-3.5F, -6F, -3F, 7, 2, 6);
      Head_Middle.setTextureSize(128, 64);
      Head_Middle.mirror = true;
      setRotation(Head_Middle, 0F, 0F, 0F);
      MaemeModelRenderer  Head_Top = new MaemeModelRenderer(this, 52, 27);
      Head_Top.addBox(-2F, -6.5F, -1.5F, 4, 1, 3);
      Head_Top.setTextureSize(128, 64);
      Head_Top.mirror = true;
      setRotation(Head_Top, 0F, 0F, 0F);
      MaemeModelRenderer  Mouth = new MaemeModelRenderer(this, 52, 31);
      Mouth.addBox(-2F, -0.5F, -3.5F, 4, 1, 1);
      Mouth.setTextureSize(128, 64);
      Mouth.mirror = true;
      setRotation(Mouth, 0F, 0F, 0F);
      MaemeModelRenderer  Mouth_Tip = new MaemeModelRenderer(this, 52, 33);
      Mouth_Tip.addBox(-1F, 0.5F, -3.5F, 2, 1, 1);
      Mouth_Tip.setTextureSize(128, 64);
      Mouth_Tip.mirror = true;
      setRotation(Mouth_Tip, 0F, 0F, 0F);
      MaemeModelRenderer  Mouth_Left = new MaemeModelRenderer(this, 62, 31);
      Mouth_Left.addBox(-0.3F, 0.8F, -3.5F, 3, 1, 1);
      Mouth_Left.setTextureSize(128, 64);
      Mouth_Left.mirror = true;
      setRotation(Mouth_Left, 0F, 0F, -0.7853982F);
      MaemeModelRenderer  Mouth_Right = new MaemeModelRenderer(this, 70, 31);
      Mouth_Right.addBox(-0.3F, -1.8F, -3.5F, 3, 1, 1);
      Mouth_Right.setTextureSize(128, 64);
      Mouth_Right.mirror = true;
      setRotation(Mouth_Right, 0F, 0F, -2.356194F);
      MaemeModelRenderer  Head_Left = new MaemeModelRenderer(this, 82, 8);
      Head_Left.addBox(3.5F, -3.5F, -2.5F, 1, 3, 5);
      Head_Left.setTextureSize(128, 64);
      Head_Left.mirror = true;
      setRotation(Head_Left, 0F, 0F, 0F);
      MaemeModelRenderer  Head_Right = new MaemeModelRenderer(this, 94, 8);
      Head_Right.addBox(-4.5F, -3.5F, -2.5F, 1, 3, 5);
      Head_Right.setTextureSize(128, 64);
      Head_Right.mirror = true;
      setRotation(Head_Right, 0F, 0F, 0F);
      MaemeModelRenderer  Ear_Base_Left = new MaemeModelRenderer(this, 52, 35);
      Ear_Base_Left.addBox(-1.5F, -2F, -1F, 3, 2, 2);
      Ear_Base_Left.setRotationPoint(2.5F, -5F, 0F);
      Ear_Base_Left.setTextureSize(128, 64);
      Ear_Base_Left.mirror = true;
      setRotation(Ear_Base_Left, 0F, -0.5235988F, 0.7853982F);
      MaemeModelRenderer  Ear_Tip_Left = new MaemeModelRenderer(this, 52, 39);
      Ear_Tip_Left.addBox(-1F, -3.5F, -1F, 2, 2, 1);
      Ear_Tip_Left.setRotationPoint(2.5F, -5F, 0F);
      Ear_Tip_Left.setTextureSize(128, 64);
      Ear_Tip_Left.mirror = true;
      setRotation(Ear_Tip_Left, 0F, -0.5235988F, 0.7853982F);
      MaemeModelRenderer  Ear_Base_Right = new MaemeModelRenderer(this, 62, 35);
      Ear_Base_Right.addBox(-1.5F, -2F, -1F, 3, 2, 2);
      Ear_Base_Right.setRotationPoint(-2.5F, -5F, 0F);
      Ear_Base_Right.setTextureSize(128, 64);
      Ear_Base_Right.mirror = true;
      setRotation(Ear_Base_Right, 0F, 0.5235988F, -0.7853982F);
      MaemeModelRenderer  Ear_Tip_Right = new MaemeModelRenderer(this, 58, 39);
      Ear_Tip_Right.addBox(-1F, -3.5F, -1F, 2, 2, 1);
      Ear_Tip_Right.setRotationPoint(-2.5F, -5F, 0F);
      Ear_Tip_Right.setTextureSize(128, 64);
      Ear_Tip_Right.mirror = true;
      setRotation(Ear_Tip_Right, 0F, 0.5235988F, -0.7853982F);
      Head.addChild(Neck);
      Head.addChild(Head_Base);
      Head.addChild(Head_Middle);
      Head.addChild(Head_Top);
      Head.addChild(Mouth);
      Head.addChild(Mouth_Tip);
      Head.addChild(Mouth_Left);
      Head.addChild(Mouth_Right);
      Head.addChild(Head_Left);
      Head.addChild(Head_Right);
      Head.addChild(Ear_Base_Left);
      Head.addChild(Ear_Tip_Left);
      Head.addChild(Ear_Base_Right);
      Head.addChild(Ear_Tip_Right);
      Body.addChild(Head);
      
      
      MaemeModelRenderer RightLeg = new MaemeModelRenderer(this, "Right Leg");
      RightLeg.setRotationPoint(-2.5F, 4.5F, -1.5F);
      MaemeModelRenderer  Leg_Base_Right = new MaemeModelRenderer(this, 12, 28);
      Leg_Base_Right.addBox(-1F, -1F, -4F, 2, 2, 4);
      Leg_Base_Right.setTextureSize(128, 64);
      Leg_Base_Right.mirror = true;
      setRotation(Leg_Base_Right, 0F, 0.5235988F, 0F);
      MaemeModelRenderer  Leg_Middle_Right = new MaemeModelRenderer(this, 8, 34);
      Leg_Middle_Right.addBox(-1.5F, -2.5F, -4.5F, 3, 4, 1);
      Leg_Middle_Right.setTextureSize(128, 64);
      Leg_Middle_Right.mirror = true;
      setRotation(Leg_Middle_Right, 0F, 0.5235988F, 0F);
      MaemeModelRenderer  Leg_Front_Right = new MaemeModelRenderer(this, 14, 39);
      Leg_Front_Right.addBox(-1.5F, -1.5F, -8.5F, 3, 3, 4);
      Leg_Front_Right.setTextureSize(128, 64);
      Leg_Front_Right.mirror = true;
      setRotation(Leg_Front_Right, 0F, 0.5235988F, 0F);
      MaemeModelRenderer  Toe_Top_Right_Right = new MaemeModelRenderer(this, 12, 46);
      Toe_Top_Right_Right.addBox(0.5F, -9F, -5.5F, 1, 3, 1);
      Toe_Top_Right_Right.setTextureSize(128, 64);
      Toe_Top_Right_Right.mirror = true;
      setRotation(Toe_Top_Right_Right, 0.7853982F, 0.5235988F, 0F);
      MaemeModelRenderer  Toe_Top_Right_Tip_Right = new MaemeModelRenderer(this, 12, 50);
      Toe_Top_Right_Tip_Right.addBox(0.5F, 7F, -7.5F, 1, 1, 1);
      Toe_Top_Right_Tip_Right.setTextureSize(128, 64);
      Toe_Top_Right_Tip_Right.mirror = true;
      setRotation(Toe_Top_Right_Tip_Right, -1.047198F, 0.5235988F, 0F);
      MaemeModelRenderer  Toe_Top_Left_Right = new MaemeModelRenderer(this, 16, 46);
      Toe_Top_Left_Right.addBox(-1.5F, -9F, -5.5F, 1, 3, 1);
      Toe_Top_Left_Right.setTextureSize(128, 64);
      Toe_Top_Left_Right.mirror = true;
      setRotation(Toe_Top_Left_Right, 0.7853982F, 0.5235988F, 0F);
      MaemeModelRenderer  Toe_Top_Left_Tip_Right = new MaemeModelRenderer(this, 16, 50);
      Toe_Top_Left_Tip_Right.addBox(-1.5F, 7F, -7.5F, 1, 1, 1);
      Toe_Top_Left_Tip_Right.setTextureSize(128, 64);
      Toe_Top_Left_Tip_Right.mirror = true;
      setRotation(Toe_Top_Left_Tip_Right, -1.047198F, 0.5235988F, 0F);
      MaemeModelRenderer  Toe_Bottom_Right = new MaemeModelRenderer(this, 20, 46);
      Toe_Bottom_Right.addBox(-0.5F, -10F, -1.5F, 1, 3, 1);
      Toe_Bottom_Right.setTextureSize(128, 64);
      Toe_Bottom_Right.mirror = true;
      setRotation(Toe_Bottom_Right, 1.570796F, 0.5235988F, 0F);
      MaemeModelRenderer  Toe_Bottom_Tip_Right = new MaemeModelRenderer(this, 20, 50);
      Toe_Bottom_Tip_Right.addBox(-0.5F, -8.9F, -6.3F, 1, 1, 1);
      Toe_Bottom_Tip_Right.setTextureSize(128, 64);
      Toe_Bottom_Tip_Right.mirror = true;
      setRotation(Toe_Bottom_Tip_Right, 1.047198F, 0.5235988F, 0F);
      RightLeg.addChild(Leg_Base_Right);
      RightLeg.addChild(Leg_Middle_Right);
      RightLeg.addChild(Leg_Front_Right);
      RightLeg.addChild(Toe_Top_Right_Right);
      RightLeg.addChild(Toe_Top_Right_Tip_Right);
      RightLeg.addChild(Toe_Top_Left_Right);
      RightLeg.addChild(Toe_Top_Left_Tip_Right);
      RightLeg.addChild(Toe_Bottom_Right);
      RightLeg.addChild(Toe_Bottom_Tip_Right);
      Body.addChild(RightLeg);
      
      
      
      MaemeModelRenderer RightArm = new MaemeModelRenderer(this, "Right Arm");
      RightArm.setRotationPoint(-3, -3.5F, 0);
      MaemeModelRenderer  Shoulder_Top_Right = new MaemeModelRenderer(this, 20, 52);
      Shoulder_Top_Right.addBox(-3F, -2F, -1.5F, 3, 1, 3);
      Shoulder_Top_Right.setTextureSize(128, 64);
      Shoulder_Top_Right.mirror = true;
      setRotation(Shoulder_Top_Right, 0F, 0F, 0F);
      MaemeModelRenderer  Shoulder_Front_Right = new MaemeModelRenderer(this, 20, 56);
      Shoulder_Front_Right.addBox(-3F, -1F, -1.5F, 3, 2, 1);
      Shoulder_Front_Right.setTextureSize(128, 64);
      Shoulder_Front_Right.mirror = true;
      setRotation(Shoulder_Front_Right, 0F, 0F, 0F);
      MaemeModelRenderer  Shoulder_Back_Right = new MaemeModelRenderer(this, 20, 59);
      Shoulder_Back_Right.addBox(-3F, -1F, 0.5F, 3, 2, 1);
      Shoulder_Back_Right.setTextureSize(128, 64);
      Shoulder_Back_Right.mirror = true;
      setRotation(Shoulder_Back_Right, 0F, 0F, 0F);
      MaemeModelRenderer  Shoulder_Tip_Right = new MaemeModelRenderer(this, 14, 58);
      Shoulder_Tip_Right.addBox(-3.1F, 0.4F, -1F, 1, 2, 2);
      Shoulder_Tip_Right.setTextureSize(128, 64);
      Shoulder_Tip_Right.mirror = true;
      setRotation(Shoulder_Tip_Right, 0F, 0F, 0.5235988F);
      MaemeModelRenderer  Arm_Base_Right = new MaemeModelRenderer(this, 4, 58);
      Arm_Base_Right.addBox(-2F, 0F, -0.5F, 1, 5, 1);
      Arm_Base_Right.setTextureSize(128, 64);
      Arm_Base_Right.mirror = true;
      setRotation(Arm_Base_Right, 0F, 0F, 0.2617994F);
      MaemeModelRenderer  Arm_Middle_Right = new MaemeModelRenderer(this, 24, 22);
      Arm_Middle_Right.addBox(-2.5F, 4F, -1F, 2, 1, 2);
      Arm_Middle_Right.setTextureSize(128, 64);
      Arm_Middle_Right.mirror = true;
      setRotation(Arm_Middle_Right, 0F, 0F, 0.2617994F);
      MaemeModelRenderer  Arm_Main_Right = new MaemeModelRenderer(this, 26, 11);
      Arm_Main_Right.addBox(-2.5F, 5F, -1.5F, 2, 4, 3);
      Arm_Main_Right.setTextureSize(128, 64);
      Arm_Main_Right.mirror = true;
      setRotation(Arm_Main_Right, 0F, 0F, 0.2617994F);
      MaemeModelRenderer  Finger_Middle_Right = new MaemeModelRenderer(this, 28, 18);
      Finger_Middle_Right.addBox(2F, 7F, -0.5F, 1, 3, 1);
      Finger_Middle_Right.setTextureSize(128, 64);
      Finger_Middle_Right.mirror = true;
      setRotation(Finger_Middle_Right, 0F, 0F, 0.7853982F);
      MaemeModelRenderer  Finger_Front_Right = new MaemeModelRenderer(this, 32, 18);
      Finger_Front_Right.addBox(2F, 7F, 0.5F, 1, 3, 1);
      Finger_Front_Right.setTextureSize(128, 64);
      Finger_Front_Right.mirror = true;
      setRotation(Finger_Front_Right, 0F, -0.5235988F, 0.7853982F);
      MaemeModelRenderer  Finger_Back_Right = new MaemeModelRenderer(this, 36, 18);
      Finger_Back_Right.addBox(2F, 7F, -1.5F, 1, 3, 1);
      Finger_Back_Right.setTextureSize(128, 64);
      Finger_Back_Right.mirror = true;
      setRotation(Finger_Back_Right, 0F, 0.5235988F, 0.7853982F);
      RightArm.addChild(Shoulder_Top_Right);
      RightArm.addChild(Shoulder_Front_Right);
      RightArm.addChild(Shoulder_Back_Right);
      RightArm.addChild(Shoulder_Tip_Right);
      RightArm.addChild(Arm_Base_Right);
      RightArm.addChild(Arm_Middle_Right);
      RightArm.addChild(Arm_Main_Right);
      RightArm.addChild(Finger_Middle_Right);
      RightArm.addChild(Finger_Front_Right);
      RightArm.addChild(Finger_Back_Right);
      Body.addChild(RightArm);
      
      
      
      ModuleHead headModule = new ModuleHead(Head);
      skeleton = new SkeletonSerpent(Body, headModule);
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