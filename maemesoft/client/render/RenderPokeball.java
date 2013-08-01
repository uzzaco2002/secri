package maemesoft.client.render;

//수정일 : 7/10 11:03 (현재 인벤토리 오류 수정중)

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.ForgeHooksClient;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import maemesoft.client.models.ModelPokeball;
import maemesoft.entities.pokeballs.EntityPokeBall;

public class RenderPokeball extends Render {
	ModelPokeball model;

	public RenderPokeball() {
		model = new ModelPokeball();
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float f, float f1) {
		doRender((EntityPokeBall) entity, x, y, z, f, f1);
	}

	private void doRender(EntityPokeBall pokeball, double x, double y, double z, float f, float f1) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180, 1, 0, 1);
		if (pokeball.getIsCaptured()) {
			Minecraft.getMinecraft().renderEngine.bindTexture("/mods/Maeme/textures/pokeballs/" + pokeball.getType().getCaptureTexture());
		} else if (pokeball.flashRed) {
			Minecraft.getMinecraft().renderEngine.bindTexture("/mods/Maeme/textures/pokeballs/" + pokeball.getType().getFlashRedTexture());
		} else {
			Minecraft.getMinecraft().renderEngine.bindTexture("/mods/Maeme/textures/pokeballs/" + pokeball.getType().getTexture());
		}
		RenderHelper.enableStandardItemLighting();
		float factor = (float) (1.0 / 16.0);
		GL11.glPushMatrix();
		model.setRotationAngles(pokeball.rotationPitch, pokeball.rotationYaw);
		model.render(pokeball, factor);
		GL11.glPopMatrix();
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}
}