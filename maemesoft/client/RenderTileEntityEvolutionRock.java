package maemesoft.client;

import org.lwjgl.opengl.GL11;

import maemesoft.blocks.BlockEvolutionRock;
import maemesoft.blocks.TileEntityEvolutionRock;
import maemesoft.config.MaemeBlocks;
import maemesoft.enums.EnumEvolutionRock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderTileEntityEvolutionRock extends TileEntitySpecialRenderer {

	IModelCustom icyRockModel;
	IModelCustom mossyRockModel;

	public RenderTileEntityEvolutionRock() {
		icyRockModel = AdvancedModelLoader.loadModel("/maemesoft/models/icyrock/icyrock.obj");
		mossyRockModel = AdvancedModelLoader.loadModel("/maemesoft/models/mossyrock/mossyrock.obj");
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double d, double d1, double d2, float f) {
		if (Minecraft.getMinecraft().theWorld.getBlockId(tile.xCoord, tile.yCoord-1, tile.zCoord) == MaemeBlocks.pc.blockID) return;
		BlockEvolutionRock block = (BlockEvolutionRock)((TileEntityEvolutionRock)tile).blockType;
		GL11.glPushMatrix(); // start
		GL11.glTranslatef((float) d + 0.5F, (float) d1+0.04f, (float) d2 + 0.5F); // size
		GL11.glRotatef(180, 1, 0, 0);
		GL11.glScalef(1.0F, -1F, -1F); // if you read this comment out this line

		if (block.rockType == EnumEvolutionRock.MossyRock){
			bindTextureByName("/maemesoft/models/mossyrock/mossrocktex.png"); 
			mossyRockModel.renderAll();
		}else if (block.rockType == EnumEvolutionRock.IcyRock){
			bindTextureByName("/maemesoft/models/icyrock/icyrocktex.png"); 
			icyRockModel.renderAll();
		}
		GL11.glPopMatrix(); // end

	}

}