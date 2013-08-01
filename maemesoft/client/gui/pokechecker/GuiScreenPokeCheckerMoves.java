package maemesoft.client.gui.pokechecker;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;

import org.lwjgl.opengl.GL11;

import maemesoft.client.gui.pc.GuiPC;
import maemesoft.common.EnumPackets;
import maemesoft.common.PacketCreator;
import maemesoft.common.MaemeDataPacket;
import maemesoft.db.DBMoves;
import cpw.mods.fml.common.network.PacketDispatcher;

public class GuiScreenPokeCheckerMoves extends GuiScreenPokeChecker {
	GuiButton nameButton;
	boolean renameButton;
	static int selectednumber = -1;
	static int attackClicked = -1;
	static boolean move1 = true;
	static boolean move2 = false;
	static boolean move3 = false;
	static boolean move4 = false;
	static boolean isPC;

	public GuiScreenPokeCheckerMoves(MaemeDataPacket pixelmonDataPacket, boolean b) {
		super(pixelmonDataPacket, b);
		targetPacket = pixelmonDataPacket;
		isPC = b;
	}

	public boolean doesGuiPauseGame() {
		return true;
	}

	public void initGui() {
		super.initGui();
		buttonList.clear();

		buttonList.add(new GuiPokeCheckerTabs(3, 0, width / 2 + 107, (int) height / 2 + 80, 17, 15, ""));
		buttonList.add(new GuiPokeCheckerTabs(0, 1, width / 2 - 127, (int) height / 2 + 80, 90, 15, "Summary"));
		buttonList.add(new GuiPokeCheckerTabs(2, 2, width / 2 + 36, (int) height / 2 + 80, 69, 15, "Stats"));
		buttonList.add(new GuiPokeCheckerTabs(4, 4, width / 2 - 44, (int) height / 2 - 107, 9, 9, "", targetPacket));
		buttonList.add(new GuiPokeCheckerTabs(7, 5, width / 2 - 44, (int) height / 2 - 14, 9, 8, "", targetPacket));
	}

	public void actionPerformed(GuiButton button) {
		switch (button.id) {
		case 0:
			if (!isPC)
				mc.thePlayer.closeScreen();
			else {
				GuiPC gui = new GuiPC(targetPacket);
				mc.displayGuiScreen(gui);
			}
			break;
		case 1:
			mc.displayGuiScreen(new GuiScreenPokeChecker(targetPacket, isPC));
			break;
		case 2:
			mc.displayGuiScreen(new GuiScreenPokeCheckerStats(targetPacket, isPC));
			break;
		case 3:
			mc.displayGuiScreen(new GuiRenamePokemon(targetPacket, this));
			break;
		case 4:
			mc.displayGuiScreen(new GuiScreenPokeCheckerWarning(targetPacket, 0));
			break;
		case 5:
			mc.displayGuiScreen(new GuiRenamePokemon(targetPacket, this));
			break;
		}
	}

	public void resetAll() {
		move1 = false;
		move2 = false;
		move3 = false;
		move4 = false;
	}

	public void drawGuiContainerForegroundLayer(int i, int i1) {
		GL11.glNormal3f(0.0F, -1.0F, 0.0F);
		for (int i2 = 0; i2 < targetPacket.numMoves; i2++) {
			drawCenteredString(fontRenderer, (targetPacket.moveset[i2]).attackName, 135, -6 + (i2 * 21), 0xcccccc);
			drawCenteredString(fontRenderer, String.valueOf((targetPacket.moveset[i2]).pp) + "/" + String.valueOf((targetPacket.moveset[i2]).ppBase), 193, -4
					+ (i2 * 21), 0xcccccc);
			mc.renderEngine.bindTexture("/maemesoft/gui/types.png");
			float x = targetPacket.moveset[i2].type.textureX;
			float y = targetPacket.moveset[i2].type.textureY;
			drawImageQuad(58, 22 * i2 - 15, 38, 21, x / 256f, y / 128f, (x + 38f) / 256f, (y + 21f) / 128f);
		}
		drawString(fontRenderer, "Lvl: " + targetPacket.lvl, 15, -14, 0xcccccc);
		drawString(fontRenderer, String.valueOf(targetPacket.getNationalPokedexNumber()), -30, -14, 0xcccccc);
		drawString(fontRenderer, "Effects", -10, 100, 0xcccccc);
		drawString(fontRenderer, "Description", 107, 100, 0xcccccc);
		drawString(fontRenderer, "Moves", 73, 166, -6250336);
		if (!isPC) {
			drawSelection(i, i1);
			drawSelectedRectBin(i, i1);
		}
	}

	public void switchMoves(int moveToChange2) {
		PacketDispatcher.sendPacketToServer(PacketCreator.createPacket(EnumPackets.SwapMove, targetPacket.pokemonID, selectednumber, moveToChange2));
		selectednumber = -1;
		mc.thePlayer.closeScreen();
	}

	public void drawSelection(int i, int i1) {
		mc.renderEngine.bindTexture("/maemesoft/gui/summaryMoves.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		if (targetPacket.numMoves > 0 && i > width / 2 - 31 && i < width / 2 + 123 && i1 > height / 2 - 100 && i1 < height / 2 - 76 || move1) {
			drawTexturedModalRect(58, -17, 1, 231, 153, 24);
			resetAll();
			move1 = true;
		}
		if (targetPacket.numMoves > 1 && i > width / 2 - 31 && i < width / 2 + 123 && i1 > height / 2 - 77 && i1 < height / 2 - 53 || move2) {
			drawTexturedModalRect(58, 6, 1, 231, 153, 24);
			resetAll();
			move2 = true;
		}
		if (targetPacket.numMoves > 2 && i > width / 2 - 31 && i < width / 2 + 123 && i1 > height / 2 - 54 && i1 < height / 2 - 31 || move3) {
			drawTexturedModalRect(58, 28, 1, 231, 153, 24);
			resetAll();
			move3 = true;
		}
		if (targetPacket.numMoves > 3 && i > width / 2 - 31 && i < width / 2 + 123 && i1 > height / 2 - 32 && i1 < height / 2 - 9 || move4) {
			drawTexturedModalRect(58, 50, 1, 231, 153, 24);
			resetAll();
			move4 = true;
		}
		drawSelectedRect();
	}

	protected void drawSelectedRect() {
		mc.renderEngine.bindTexture("/maemesoft/gui/summaryMoves.png");
		GL11.glColor3f(0.0F, 1.0F, 0.0F);// Gives the selection a light green
											// color.
		if (selectednumber == 0)
			drawTexturedModalRect(58, -17, 1, 231, 153, 24);
		else if (selectednumber == 1)
			drawTexturedModalRect(58, 6, 1, 231, 153, 24);
		else if (selectednumber == 2)
			drawTexturedModalRect(58, 28, 1, 231, 153, 24);
		else if (selectednumber == 3)
			drawTexturedModalRect(58, 50, 1, 231, 153, 24);
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
	}

	protected void drawSelectedRectBin(int i, int i1) {
		mc.renderEngine.bindTexture("/maemesoft/gui/summaryMoves.png");
		GL11.glColor3f(1.0F, 0.0F, 0.0F);// Gives the selection a light red
		// color.
		if (selectednumber >= targetPacket.numMoves && i > width / 2 + 130 && i < width / 2 + 158 && i1 > height / 2 - 25 && i1 < height / 2 + 9) {
			drawTexturedModalRect(220, 60, 230, 225, 26, 31);
		}
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
	}

	protected int moveClicked(int i, int i1) {
		if (targetPacket.numMoves > 0 && i > width / 2 - 31 && i < width / 2 + 123 && i1 > height / 2 - 100 && i1 < height / 2 - 76)
			return 0;
		else if (targetPacket.numMoves > 1 && i > width / 2 - 31 && i < width / 2 + 123 && i1 > height / 2 - 77 && i1 < height / 2 - 53)
			return 1;
		else if (targetPacket.numMoves > 2 && i > width / 2 - 31 && i < width / 2 + 123 && i1 > height / 2 - 54 && i1 < height / 2 - 31)
			return 2;
		else if (targetPacket.numMoves > 3 && i > width / 2 - 31 && i < width / 2 + 123 && i1 > height / 2 - 32 && i1 < height / 2 - 9)
			return 3;
		else
			return -1;
	}

	protected void selectMove(int i, int i1) {
		if (i > width / 2 - 31 && i < width / 2 + 123 && i1 > height / 2 - 100 && i1 < height / 2 - 9 && selectednumber != moveClicked(i, i1)) {
			if (selectednumber == -1) {
				selectednumber = moveClicked(i, i1);
			} else if (selectednumber != -1) {
				if (moveClicked(i, i1) != -1)
					switchMoves(moveClicked(i, i1));
			}
		} else
			selectednumber = -1;
	}

	protected void mouseClicked(int x, int y, int par3) {
		ScaledResolution var5 = new ScaledResolution(Minecraft.getMinecraft().gameSettings, Minecraft.getMinecraft().displayWidth,
				Minecraft.getMinecraft().displayHeight);
		int var6 = var5.getScaledWidth();
		int var7 = var5.getScaledHeight();
		super.mouseClicked(x, y, par3);
		if (selectednumber >= targetPacket.numMoves && x > var6 / 2 + 130 && x < var6 / 2 + 158 && y > var7 / 2 - 25 && y < var7 / 2 + 9) {
			mc.displayGuiScreen(new GuiScreenPokeCheckerWarning(targetPacket, 1, selectednumber));
		}
		if (!isPC) {
			selectMove(x, y);
		}
		if (x > var6 / 2 - 125 && x < var6 / 2 - 40 && y > var7 / 2 - 15 && y < var7 / 2 + 5) {
			if (par3 == 1 && !renameButton) {
				nameButton = new GuiButton(3, x, y, 50, 20, "Rename");
				buttonList.add(nameButton);
				renameButton = true;
			} else if (par3 != 1 && renameButton) {
				buttonList.remove(nameButton);
				renameButton = false;
			} else if (par3 == 1 && renameButton) {
				buttonList.remove(nameButton);
				nameButton = new GuiButton(3, x, y, 50, 20, "Rename");
				buttonList.add(nameButton);
			}
		}
	}

	public void drawGuiContainerBackgroundLayer(float f, int i, int i1) {
		ScaledResolution var5 = new ScaledResolution(Minecraft.getMinecraft().gameSettings, Minecraft.getMinecraft().displayWidth,
				Minecraft.getMinecraft().displayHeight);
		int var6 = var5.getScaledWidth();
		int var7 = var5.getScaledHeight();
		String numString = "";
		if (targetPacket.getNationalPokedexNumber() < 10)
			numString = "00" + targetPacket.getNationalPokedexNumber();
		else if (targetPacket.getNationalPokedexNumber() < 100)
			numString = "0" + targetPacket.getNationalPokedexNumber();
		else
			numString = "" + targetPacket.getNationalPokedexNumber();

		mc.renderEngine.bindTexture("/maemesoft/gui/summaryMoves.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect((width - xSize) / 2 - 40, (height - ySize) / 2 - 25, 0, 0, 256, 204);
		drawTexturedModalRect((width - xSize) / 2 + 220, (height - ySize) / 2 + 60, 203, 225, 26, 31);

		if (targetPacket.isShiny)
			mc.renderEngine.bindTexture("/maemesoft/sprites/shinypokemon/" + numString + ".png");
		else
			mc.renderEngine.bindTexture("/maemesoft/sprites/pokemon/" + numString + ".png");
		drawImageQuad(width / 2 - 123, height / 2 - 100, 84f, 84f, 0f, 0f, 1f, 1f);
		if (targetPacket.nickname.length() < 1)
			drawCenteredStringWithoutShadow(fontRenderer, String.valueOf(targetPacket.name), (width - xSize) / 2 + 7, (height - ySize) / 2 + 75, targetPacket
					.getType1().getColor());
		else {
			drawCenteredStringWithoutShadow(fontRenderer, "(" + String.valueOf(targetPacket.name) + ")", (width - xSize) / 2 + 7, (height - ySize) / 2 + 78,
					targetPacket.getType1().getColor());
			drawCenteredStringWithoutShadow(fontRenderer, String.valueOf(targetPacket.nickname), (width - xSize) / 2 + 7, (height - ySize) / 2 + 70,
					targetPacket.getType1().getColor());
		}

		drawArrows(i, i1);
	}

	public void drawCenteredStringWithoutShadow(FontRenderer par1FontRenderer, String par2Str, int par3, int par4, int par5) {
		par1FontRenderer.drawString(par2Str, par3 - par1FontRenderer.getStringWidth(par2Str) / 2, par4, par5);
	}

	private void drawImageQuad(int x, int y, float w, float h, float us, float vs, float ue, float ve) {
		// activate the specified texture

		float var7 = 0.00390625F;
		float var8 = 0.00390625F;
		Tessellator var9 = Tessellator.instance;
		var9.startDrawingQuads();
		var9.addVertexWithUV((double) (x + 0), (double) (y + h), (double) this.zLevel, (double) ((float) us), (double) ((float) ve));
		var9.addVertexWithUV((double) (x + w), (double) (y + h), (double) this.zLevel, (double) ((float) ue), (double) ((float) ve));
		var9.addVertexWithUV((double) (x + w), (double) (y + 0), (double) this.zLevel, (double) ((float) ue), (double) ((float) vs));
		var9.addVertexWithUV((double) (x + 0), (double) (y + 0), (double) this.zLevel, (double) ((float) us), (double) ((float) vs));
		var9.draw();
	}
}