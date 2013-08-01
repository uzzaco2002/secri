package maemesoft.client.render.tileEntities;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import maemesoft.blocks.TileEntityAnvil;
import maemesoft.client.models.ModelAnvil;
import maemesoft.client.models.discs.ModelDiscFlat;
import maemesoft.client.models.discs.ModelDiscHemiSphere;
import maemesoft.client.models.discs.ModelDiscStage1;
import maemesoft.client.models.discs.ModelDiscStage2;
import maemesoft.client.models.plates.ModelIngot;
import maemesoft.client.models.plates.ModelPlate;
import maemesoft.client.models.plates.ModelPlateStage2;
import maemesoft.client.models.plates.ModelPlateStage3;
import maemesoft.config.MaemeItems;
import maemesoft.config.MaemeItemsPokeballs;
import maemesoft.items.ItemPokeballDisc;
import maemesoft.items.ItemPokeballLid;

public class RenderTileEntityAnvil extends TileEntitySpecialRenderer {
	private ModelAnvil model;
	private ModelDiscFlat modelDiscFlat;
	private ModelDiscHemiSphere modelDiscHemiSphere;
	private ModelDiscStage1 modelDiscStage1;
	private ModelDiscStage2 modelDiscStage2;
	private ModelIngot modelPlateIngot;
	private ModelPlate modelPlate;
	private ModelPlateStage2 modelPlateStage2;
	private ModelPlateStage3 modelPlateStage3;

	public RenderTileEntityAnvil() {
		model = new ModelAnvil();
		modelDiscFlat = new ModelDiscFlat();
		modelDiscHemiSphere = new ModelDiscHemiSphere();
		modelDiscStage1 = new ModelDiscStage1();
		modelDiscStage2 = new ModelDiscStage2();
		modelPlateIngot = new ModelIngot();
		modelPlate = new ModelPlate();
		modelPlateStage2 = new ModelPlateStage2();
		modelPlateStage3  = new ModelPlateStage3();
	}

	public void renderAModelAt(TileEntityAnvil tile, double d, double d1, double d2, float f) {
		int i = tile.getBlockMetadata(); // this is for rotation
		int j = 0;

		if (i == 0) {
			j = 0;
		}

		if (i == 1) {
			j = 90;
		}

		if (i == 2) {
			j = 180;
		}

		if (i == 3) {
			j = 270;
		}

		if (i < 0)
			return;

		bindTextureByName("/maemesoft/texture/blocks/anvil.png"); // texture
		GL11.glPushMatrix(); // start
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F); // size
		GL11.glRotatef(j, 0.0F, 1.0F, 0.0F); // rotate based on metadata
		GL11.glScalef(1.0F, -1F, -1F); // if you read this comment out this line
										// and you can see what happens
		model.renderModel(tile, 0.0625F); // renders and yes 0.0625 is a random
											// number
		if (tile.itemOnAnvil != -1) {
			GL11.glTranslatef((float) 0, (float) 0.03F, (float) 0); // size
			Item itemToRender = MaemeItemsPokeballs.getItemFromID(tile.itemOnAnvil);
			if (tile.itemOnAnvil == MaemeItems.aluminiumIngot.itemID)
			{
				bindTextureByName("/maemesoft/texture/aluminum/ingot.png");
				if (tile.state == 0)
					modelPlateIngot.renderModel(0.0625f);
				else if (tile.state == 1)
					modelPlateStage2.renderModel(0.0625f);
				else if (tile.state == 2)
					modelPlateStage3.renderModel(0.0625f);
			}
			else
				if(tile.itemOnAnvil == MaemeItems.aluminiumPlate.itemID){
					bindTextureByName("/maemesoft/texture/aluminum/ingot.png");
					modelPlate.renderModel(0.0625f);
				}
			if (itemToRender instanceof ItemPokeballDisc || itemToRender == MaemeItemsPokeballs.ironDisc) {
				if (itemToRender == MaemeItemsPokeballs.ironDisc)
					bindTextureByName("/maemesoft/textures/pokeballs/irondisc.png");
				else
					bindTextureByName("/maemesoft/textures/pokeballs/" + ((ItemPokeballDisc) itemToRender).pokeball.getTexture());
				if (tile.state == 0)
					modelDiscFlat.renderModel(0.0625f);
				else if (tile.state == 1)
					modelDiscStage1.renderModel(0.0625f);
				else if (tile.state == 2)
					modelDiscStage2.renderModel(0.0625f);
				}
				else if (itemToRender instanceof ItemPokeballLid || itemToRender == MaemeItemsPokeballs.ironBase) {
				if (itemToRender == MaemeItemsPokeballs.ironBase)
					bindTextureByName("/maemesoft/textures/pokeballs/irondisc.png");
				else bindTextureByName("/maemesoft/textures/pokeballs/" + ((ItemPokeballLid) itemToRender).pokeball.getTexture());
				modelDiscHemiSphere.renderModel(0.0625f);
			}
		}
		GL11.glPopMatrix(); // end

	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {
		renderAModelAt((TileEntityAnvil) tileentity, d, d1, d2, f); // where to
																	// render
	}
}