package maemesoft.client.models;

import maemesoft.blocks.TileEntityFossilCleaner;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFossilCleaner extends ModelBase {
	// fields
	ModelRenderer Main;
	ModelRenderer Top;
	ModelRenderer Glass;

	public ModelFossilCleaner() {
		textureWidth = 128;
		textureHeight = 64;

		Main = new ModelRenderer(this, 0, 0);
		Main.addBox(-8F, 0F, -8F, 16, 5, 16);
		Main.setRotationPoint(0F, 19F, 0F);
		Main.setTextureSize(128, 64);
		Main.mirror = true;
		setRotation(Main, 0F, 0F, 0F);

		Glass = new ModelRenderer(this, 0, 22);
		Glass.addBox(-6.5F, -10F, -6.5F, 13, 8, 13);
		Glass.setRotationPoint(0F, 19F, 0F);
		Glass.setTextureSize(128, 64);
		Glass.mirror = true;
		setRotation(Glass, 0F, 0F, 0F);

		Top = new ModelRenderer(this, "Top");
		Top.setRotationPoint(0F, 19F, 0F);
		ModelRenderer Gearnorthwest = new ModelRenderer(this, 0, 44);
		Gearnorthwest.addBox(-1F, -2F, 1F, 2, 1, 6);
		Gearnorthwest.setTextureSize(128, 64);
		Gearnorthwest.mirror = true;
		setRotation(Gearnorthwest, 0F, -0.7853982F, 0F);
		Top.addChild(Gearnorthwest);
		ModelRenderer Gearsoutheast = new ModelRenderer(this, 0, 44);
		Gearsoutheast.addBox(-1F, -2F, -7F, 2, 1, 6);
		Gearsoutheast.setTextureSize(128, 64);
		Gearsoutheast.mirror = true;
		setRotation(Gearsoutheast, 0F, -0.7853982F, 0F);
		Top.addChild(Gearsoutheast);
		ModelRenderer Gearnortheast = new ModelRenderer(this, 0, 52);
		Gearnortheast.addBox(1F, -2F, -1F, 6, 1, 2);
		Gearnortheast.setTextureSize(128, 64);
		Gearnortheast.mirror = true;
		setRotation(Gearnortheast, 0F, -0.7853982F, 0F);
		Top.addChild(Gearnortheast);
		ModelRenderer Gearwest = new ModelRenderer(this, 0, 52);
		Gearwest.addBox(-7F, -2F, -1F, 6, 1, 2);
		Gearwest.setTextureSize(128, 64);
		Gearwest.mirror = true;
		setRotation(Gearwest, 0F, 0F, 0F);
		Top.addChild(Gearwest);
		ModelRenderer Gearsouthwest = new ModelRenderer(this, 0, 52);
		Gearsouthwest.addBox(-7F, -2F, -1F, 6, 1, 2);
		Gearsouthwest.setTextureSize(128, 64);
		Gearsouthwest.mirror = true;
		setRotation(Gearsouthwest, 0F, -0.7853982F, 0F);
		Top.addChild(Gearsouthwest);
		ModelRenderer Gearsouth = new ModelRenderer(this, 0, 44);
		Gearsouth.addBox(-1F, -2F, -7F, 2, 1, 6);
		Gearsouth.setTextureSize(128, 64);
		Gearsouth.mirror = true;
		setRotation(Gearsouth, 0F, 0F, 0F);
		Top.addChild(Gearsouth);
		ModelRenderer Geareast = new ModelRenderer(this, 0, 52);
		Geareast.addBox(1F, -2F, -1F, 6, 1, 2);
		Geareast.setTextureSize(128, 64);
		Geareast.mirror = true;
		setRotation(Geareast, 0F, 0F, 0F);
		Top.addChild(Geareast);
		ModelRenderer Gearnorth = new ModelRenderer(this, 0, 44);
		Gearnorth.addBox(-1F, -2F, 1F, 2, 1, 6);
		Gearnorth.setTextureSize(128, 64);
		Gearnorth.mirror = true;
		setRotation(Gearnorth, 0F, 0F, 0F);
		Top.addChild(Gearnorth);
		ModelRenderer Geareastfiller = new ModelRenderer(this, 17, 52);
		Geareastfiller.addBox(-1F, -2F, -1F, 6, 1, 2);
		Geareastfiller.setTextureSize(128, 64);
		Geareastfiller.mirror = true;
		setRotation(Geareastfiller, 0F, -0.4014257F, 0F);
		Top.addChild(Geareastfiller);
		ModelRenderer Gearsoutheastfiller = new ModelRenderer(this, 17, 52);
		Gearsoutheastfiller.addBox(-1F, -2F, -1F, 6, 1, 2);
		Gearsoutheastfiller.setTextureSize(128, 64);
		Gearsoutheastfiller.mirror = true;
		setRotation(Gearsoutheastfiller, 0F, 0.4014257F, 0F);
		Top.addChild(Gearsoutheastfiller);
		ModelRenderer Gearsouthfiller = new ModelRenderer(this, 17, 44);
		Gearsouthfiller.addBox(-1F, -2F, -5F, 2, 1, 6);
		Gearsouthfiller.setTextureSize(128, 64);
		Gearsouthfiller.mirror = true;
		setRotation(Gearsouthfiller, 0F, -0.4014257F, 0F);
		Top.addChild(Gearsouthfiller);
		ModelRenderer Gearsouthwestfiller = new ModelRenderer(this, 17, 44);
		Gearsouthwestfiller.addBox(-1F, -2F, -5F, 2, 1, 6);
		Gearsouthwestfiller.setTextureSize(128, 64);
		Gearsouthwestfiller.mirror = true;
		setRotation(Gearsouthwestfiller, 0F, 0.4014257F, 0F);
		Top.addChild(Gearsouthwestfiller);
		ModelRenderer Gearnorthwestfiller = new ModelRenderer(this, 17, 52);
		Gearnorthwestfiller.addBox(-5F, -2F, -1F, 6, 1, 2);
		Gearnorthwestfiller.setTextureSize(128, 64);
		Gearnorthwestfiller.mirror = true;
		setRotation(Gearnorthwestfiller, 0F, 0.4014257F, 0F);
		Top.addChild(Gearnorthwestfiller);
		ModelRenderer Gearwestfiller = new ModelRenderer(this, 17, 52);
		Gearwestfiller.addBox(-5F, -2F, -1F, 6, 1, 2);
		Gearwestfiller.setTextureSize(128, 64);
		Gearwestfiller.mirror = true;
		setRotation(Gearwestfiller, 0F, -0.4014257F, 0F);
		Top.addChild(Gearwestfiller);
		ModelRenderer Gearnortheastfiller = new ModelRenderer(this, 17, 44);
		Gearnortheastfiller.addBox(-1F, -2F, -1F, 2, 1, 6);
		Gearnortheastfiller.setTextureSize(128, 64);
		Gearnortheastfiller.mirror = true;
		setRotation(Gearnortheastfiller, 0F, 0.4014257F, 0F);
		Top.addChild(Gearnortheastfiller);
		ModelRenderer Gearnorthfiller = new ModelRenderer(this, 17, 44);
		Gearnorthfiller.addBox(-1F, -2F, -1F, 2, 1, 6);
		Gearnorthfiller.setTextureSize(128, 64);
		Gearnorthfiller.mirror = true;
		setRotation(Gearnorthfiller, 0F, -0.4014257F, 0F);
		Top.addChild(Gearnorthfiller);
		ModelRenderer Cogeast = new ModelRenderer(this, 65, 0);
		Cogeast.addBox(-0.5F, -1F, -1F, 4, 1, 2);
		Cogeast.setTextureSize(128, 64);
		Cogeast.mirror = true;
		setRotation(Cogeast, 0F, 0F, 0F);
		Top.addChild(Cogeast);
		ModelRenderer Cogwest = new ModelRenderer(this, 65, 0);
		Cogwest.addBox(-3.5F, -1F, -1F, 4, 1, 2);
		Cogwest.setTextureSize(128, 64);
		Cogwest.mirror = true;
		setRotation(Cogwest, 0F, 0F, 0F);
		Top.addChild(Cogwest);
		ModelRenderer Cognorth = new ModelRenderer(this, 65, 4);
		Cognorth.addBox(-1F, -1F, -0.5F, 2, 1, 4);
		Cognorth.setTextureSize(128, 64);
		Cognorth.mirror = true;
		setRotation(Cognorth, 0F, 0F, 0F);
		Top.addChild(Cognorth);
		ModelRenderer Cogsouth = new ModelRenderer(this, 65, 4);
		Cogsouth.addBox(-1F, -1F, -3.5F, 2, 1, 4);
		Cogsouth.setTextureSize(128, 64);
		Cogsouth.mirror = true;
		setRotation(Cogsouth, 0F, 0F, 0F);
		Top.addChild(Cogsouth);
		ModelRenderer Cogsouthwest = new ModelRenderer(this, 65, 4);
		Cogsouthwest.addBox(-1F, -1F, -3.5F, 2, 1, 4);
		Cogsouthwest.setTextureSize(128, 64);
		Cogsouthwest.mirror = true;
		setRotation(Cogsouthwest, 0F, 0.5235988F, 0F);
		Top.addChild(Cogsouthwest);
		ModelRenderer Cogwestsouth = new ModelRenderer(this, 65, 0);
		Cogwestsouth.addBox(-3.5F, -1F, -1F, 4, 1, 2);
		Cogwestsouth.setTextureSize(128, 64);
		Cogwestsouth.mirror = true;
		setRotation(Cogwestsouth, 0F, -0.5235988F, 0F);
		Top.addChild(Cogwestsouth);
		ModelRenderer Cognorthwest = new ModelRenderer(this, 65, 4);
		Cognorthwest.addBox(-1F, -1F, -0.5F, 2, 1, 4);
		Cognorthwest.setTextureSize(128, 64);
		Cognorthwest.mirror = true;
		setRotation(Cognorthwest, 0F, -0.5235988F, 0F);
		Top.addChild(Cognorthwest);
		ModelRenderer Cogwestnorth = new ModelRenderer(this, 65, 0);
		Cogwestnorth.addBox(-3.5F, -1F, -1F, 4, 1, 2);
		Cogwestnorth.setTextureSize(128, 64);
		Cogwestnorth.mirror = true;
		setRotation(Cogwestnorth, 0F, 0.5235988F, 0F);
		Top.addChild(Cogwestnorth);
		ModelRenderer Cogsoutheast = new ModelRenderer(this, 65, 4);
		Cogsoutheast.addBox(-1F, -1F, -3.5F, 2, 1, 4);
		Cogsoutheast.setTextureSize(128, 64);
		Cogsoutheast.mirror = true;
		setRotation(Cogsoutheast, 0F, -0.5235988F, 0F);
		Top.addChild(Cogsoutheast);
		ModelRenderer Cogeastsouth = new ModelRenderer(this, 65, 0);
		Cogeastsouth.addBox(-0.5F, -1F, -1F, 4, 1, 2);
		Cogeastsouth.setTextureSize(128, 64);
		Cogeastsouth.mirror = true;
		setRotation(Cogeastsouth, 0F, 0.5235988F, 0F);
		Top.addChild(Cogeastsouth);
		ModelRenderer Cogeastnorth = new ModelRenderer(this, 65, 0);
		Cogeastnorth.addBox(-0.5F, -1F, -1F, 4, 1, 2);
		Cogeastnorth.setTextureSize(128, 64);
		Cogeastnorth.mirror = true;
		setRotation(Cogeastnorth, 0F, -0.5235988F, 0F);
		Top.addChild(Cogeastnorth);
		ModelRenderer Cognortheast = new ModelRenderer(this, 65, 4);
		Cognortheast.addBox(-1F, -1F, -0.5F, 2, 1, 4);
		Cognortheast.setTextureSize(128, 64);
		Cognortheast.mirror = true;
		setRotation(Cognortheast, 0F, 0.5235988F, 0F);
		Top.addChild(Cognortheast);
		ModelRenderer Tankclipwest = new ModelRenderer(this, 41, 44);
		Tankclipwest.addBox(-7F, -3F, -1F, 1, 1, 2);
		Tankclipwest.setTextureSize(128, 64);
		Tankclipwest.mirror = true;
		setRotation(Tankclipwest, 0F, 0F, 0F);
		Top.addChild(Tankclipwest);
		ModelRenderer Tankclipsouth = new ModelRenderer(this, 41, 49);
		Tankclipsouth.addBox(-1F, -3F, -7F, 2, 1, 1);
		Tankclipsouth.setTextureSize(128, 64);
		Tankclipsouth.mirror = true;
		setRotation(Tankclipsouth, 0F, 0F, 0F);
		Top.addChild(Tankclipsouth);
		ModelRenderer Tankclipeast = new ModelRenderer(this, 34, 44);
		Tankclipeast.addBox(6F, -3F, -1F, 1, 1, 2);
		Tankclipeast.setTextureSize(128, 64);
		Tankclipeast.mirror = true;
		setRotation(Tankclipeast, 0F, 0F, 0F);
		Top.addChild(Tankclipeast);
		ModelRenderer Tankclipnorth = new ModelRenderer(this, 34, 49);
		Tankclipnorth.addBox(-1F, -3F, 6F, 2, 1, 1);
		Tankclipnorth.setTextureSize(128, 64);
		Tankclipnorth.mirror = true;
		setRotation(Tankclipnorth, 0F, 0F, 0F);
		Top.addChild(Tankclipnorth);

		ModelRenderer Tank = new ModelRenderer(this, "Tank");
		ModelRenderer Tankfront = new ModelRenderer(this, 53, 23);
		Tankfront.addBox(-6.5F, -10.1F, -6.5F, 13, 8, 0);
		Tankfront.setTextureSize(128, 64);
		Tankfront.mirror = true;
		setRotation(Tankfront, 0F, 0F, 0F);
		Tank.addChild(Tankfront);
		ModelRenderer Tankright = new ModelRenderer(this, 53, 32);
		Tankright.addBox(-6.5F, -10.1F, -6.5F, 0, 8, 13);
		Tankright.setTextureSize(128, 64);
		Tankright.mirror = true;
		setRotation(Tankright, 0F, 0F, 0F);
		Tank.addChild(Tankright);
		ModelRenderer Tankleft = new ModelRenderer(this, 53, 32);
		Tankleft.addBox(6.5F, -10.1F, -6.5F, 0, 8, 13);
		Tankleft.setTextureSize(128, 64);
		Tankleft.mirror = true;
		setRotation(Tankleft, 0F, 0F, 0F);
		Tank.addChild(Tankleft);
		ModelRenderer Tankback = new ModelRenderer(this, 53, 23);
		Tankback.addBox(-6.5F, -10.1F, 6.5F, 13, 8, 0);
		Tankback.setTextureSize(128, 64);
		Tankback.mirror = true;
		setRotation(Tankback, 0F, 0F, 0F);
		Tank.addChild(Tankback);
		ModelRenderer Tanktop = new ModelRenderer(this, 75, 9);
		Tanktop.addBox(-6.5F, -10.1F, -6.5F, 13, 0, 13);
		Tanktop.setTextureSize(128, 64);
		Tanktop.mirror = true;
		setRotation(Tanktop, 0F, 0F, 0F);
		Tank.addChild(Tanktop);
		ModelRenderer Tankbottom = new ModelRenderer(this, 75, 9);
		Tankbottom.addBox(-6.5F, -2.1F, -6.5F, 13, 0, 13);
		Tankbottom.setTextureSize(128, 64);
		Tankbottom.mirror = true;
		setRotation(Tankbottom, 0F, 0F, 0F);
		Tank.addChild(Tankbottom);
		Top.addChild(Tank);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Main.render(f5);
		Top.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
	}

	public void renderModel(TileEntityFossilCleaner tileEntity, float f) {
		Main.render(f);
		Top.render(f);
	}

	public void rotateModel(TileEntityFossilCleaner tileEntity) {
		Top.rotateAngleY = tileEntity.timer / 1.5f;
		Glass.rotateAngleY = tileEntity.timer / 1.5f;
	}

	public void renderGlass(TileEntityFossilCleaner tileEntity, float f) {
		Glass.render(f);
	}

	public void clearRotation() {
		Top.rotateAngleY = Glass.rotateAngleY = 0;

	}

}