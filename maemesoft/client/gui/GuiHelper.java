package maemesoft.client.gui;

import net.minecraft.client.renderer.Tessellator;

public class GuiHelper {
	public static void drawImageQuad(int x, int y, float w, float h, float us, float vs, float ue, float ve, float zLevel) {
		float var7 = 0.00390625F;
		float var8 = 0.00390625F;
		Tessellator var9 = Tessellator.instance;
		var9.startDrawingQuads();
		var9.addVertexWithUV((double) (x + 0), (double) (y + h), (double) zLevel, (double) ((float) us), (double) ((float) ve));
		var9.addVertexWithUV((double) (x + w), (double) (y + h), (double) zLevel, (double) ((float) ue), (double) ((float) ve));
		var9.addVertexWithUV((double) (x + w), (double) (y + 0), (double) zLevel, (double) ((float) ue), (double) ((float) vs));
		var9.addVertexWithUV((double) (x + 0), (double) (y + 0), (double) zLevel, (double) ((float) us), (double) ((float) vs));
		var9.draw();
	}
}