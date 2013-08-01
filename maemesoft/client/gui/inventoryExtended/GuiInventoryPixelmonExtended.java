package maemesoft.client.gui.inventoryExtended;

import java.awt.Rectangle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import maemesoft.Maeme;
import maemesoft.client.ServerStorageDisplay;
import maemesoft.client.gui.GuiMaemeOverlay;
import maemesoft.client.gui.pokechecker.GuiPokeCheckerTabs;
import maemesoft.client.gui.pokechecker.GuiScreenPokeChecker;
import maemesoft.client.gui.pokechecker.GuiScreenPokeCheckerMoves;
import maemesoft.common.EnumPackets;
import maemesoft.common.PacketCreator;
import maemesoft.common.MaemeDataPacket;
import maemesoft.config.MaemeItems;
import maemesoft.config.MaemeItemsHeld;
import maemesoft.enums.EnumGui;
import maemesoft.items.ItemHeld;
import maemesoft.storage.PlayerStorage;
import cpw.mods.fml.common.network.PacketDispatcher;

public class GuiInventoryPixelmonExtended extends GuiInventory {

	public SlotInventoryMaeme[] pixelmonSlots;

	GuiMaemeOverlay overlay = new GuiMaemeOverlay();
	boolean pixelmonMenuOpen;
	int menuX;
	int menuY;
	GuiButton pMenuButtonSumm;
	GuiButton pMenuButtonMove;
	GuiButton pMenuButtonStat;
	MaemeDataPacket selected;

	private float xSize_lo, ySize_lo;

	public GuiInventoryPixelmonExtended(EntityPlayer par1EntityPlayer) {
		super(par1EntityPlayer);
		pixelmonMenuOpen = false;
		pixelmonSlots = new SlotInventoryMaeme[6];
	}

	@Override
	public void initGui() {
		super.initGui();
		ScaledResolution var5 = new ScaledResolution(Minecraft.getMinecraft().gameSettings, Minecraft.getMinecraft().displayWidth,
				Minecraft.getMinecraft().displayHeight);
		int width = var5.getScaledWidth();
		int height = var5.getScaledHeight();
		for (int i = 0; i < pixelmonSlots.length; i++) {
			pixelmonSlots[i] = null;
		}
		for (MaemeDataPacket p : ServerStorageDisplay.pokemon) {
			int offset = 0;
			if (p != null) {
				int i = p.order;
				int x = width / 2 - 121;
				int y = height / 2 + i * 18 - 65;
				pixelmonSlots[i] = new SlotInventoryMaeme(x, y, p);
			}
		}
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		super.drawScreen(par1, par2, par3);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.xSize_lo = (float) par1;
		this.ySize_lo = (float) par2;
		if (pixelmonMenuOpen) {
			this.drawCenteredString(fontRenderer, selected.name, menuX - 40, menuY - 8, 0xffffff);
		}
	}

	public void drawButtonContainer() {
		if (pixelmonMenuOpen) {
			mc.renderEngine.bindTexture("/maemesoft/gui/pokecheckerPopup.png");
			this.drawTexturedModalRect(menuX - 73, menuY - 10, 0, 0, 67, 76);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		this.mc.renderEngine.bindTexture("/gui/inventory.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		this.mc.renderEngine.bindTexture("/maemesoft/gui/pixelmonOverlayExtended2.png");
		this.drawTexturedModalRect(width / 2 - 130, height / 2 - 83, 0, 0, 46, 167);

		ScaledResolution var5 = new ScaledResolution(Minecraft.getMinecraft().gameSettings, Minecraft.getMinecraft().displayWidth,
				Minecraft.getMinecraft().displayHeight);
		int var6 = var5.getScaledWidth();
		int var7 = var5.getScaledHeight();
		int textureIndex;
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_FOG);
		Tessellator var2 = Tessellator.instance;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().entityRenderer.setupOverlayRendering();

		fontRenderer.setUnicodeFlag(true);

		for (SlotInventoryMaeme slot : pixelmonSlots) {
			if (slot == null) {
				continue;
			}
			MaemeDataPacket p = slot.pokemonData;
			int offset = 0;
			if (p != null) {
				String numString = "";
				if (p.getNationalPokedexNumber() < 10)
					numString = "00" + p.getNationalPokedexNumber();
				else if (p.getNationalPokedexNumber() < 100)
					numString = "0" + p.getNationalPokedexNumber();
				else
					numString = "" + p.getNationalPokedexNumber();

				if (p.isShiny)
					mc.renderEngine.bindTexture("/mods/Maeme/sprites/shinypokemon/" + numString + ".png");
				else
					mc.renderEngine.bindTexture("/mods/Maeme/sprites/pokemon/" + numString + ".png");
				drawImageQuad(slot.x, slot.y, 16f, 16f, 0f, 0f, 1f, 1f);

				if (p.heldItemId != -1) {
					ItemHeld heldItem = (ItemHeld) MaemeItemsHeld.getHeldItem(p.heldItemId);
					if (heldItem != null) {
						Icon icon = heldItem.getIconIndex(new ItemStack(heldItem));
						mc.renderEngine.bindTexture("/gui/items.png");
						drawIcon(slot.heldItemX, slot.heldItemY, icon, 16, 16);
					}
				} else {
					Minecraft.getMinecraft().renderEngine.bindTexture("/maemesoft/image/helditem.png");
					drawImageQuad(slot.heldItemX + 3, slot.heldItemY + 3, 10f, 10f, 0f, 0f, 1f, 1f);
				}
			}
			drawButtonContainer();
		}

		int mouseX = Mouse.getX() * this.width / this.mc.displayWidth;
		int mouseY = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
		if (!pixelmonMenuOpen) {
			for (SlotInventoryMaeme s : pixelmonSlots) {
				if (s != null) {
					if (s.getBounds().contains(mouseX, mouseY)) {
						drawPokemonInfo(mouseX, mouseY, s);
					}
					if (s.getHeldItemBounds().contains(mouseX, mouseY) && heldItemQualifies(s)) {
						mc.renderEngine.bindTexture("/maemesoft/gui/pixelmonOverlayExtended2.png");
						drawImageQuad(s.heldItemX - 2, s.heldItemY - 2, 20, 20, 58f / 256f, 185f / 256f, 78f / 256f, 205f / 256f);
					}
				}
			}
		}
		//this.fontRenderer.drawString(StatCollector.translateToLocal(PlayerStorage.getCurrency() + ""), -29, 154, 0xFFFFFF);

		fontRenderer.setUnicodeFlag(false);
		RenderHelper.disableStandardItemLighting();

		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_DEPTH_TEST);

		drawPlayerOnGui(this.mc, guiLeft + 51, guiTop + 75, 30, (float) (guiLeft + 51) - this.xSize_lo, (float) (guiTop + 75 - 50) - this.ySize_lo);

	}

	public void drawIcon(int x, int y, Icon par3Icon, int width, int height) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV((double) (x + 0), (double) (y + height), (double) this.zLevel, (double) par3Icon.getMinU(),
				(double) par3Icon.getMaxV());
		tessellator.addVertexWithUV((double) (x + width), (double) (y + height), (double) this.zLevel, (double) par3Icon.getMaxU(),
				(double) par3Icon.getMaxV());
		tessellator.addVertexWithUV((double) (x + width), (double) (y + 0), (double) this.zLevel, (double) par3Icon.getMaxU(),
				(double) par3Icon.getMinV());
		tessellator.addVertexWithUV((double) (x + 0), (double) (y + 0), (double) this.zLevel, (double) par3Icon.getMinU(),
				(double) par3Icon.getMinV());
		tessellator.draw();
	}

	private boolean heldItemQualifies(SlotInventoryMaeme s) {
		InventoryPlayer inv = mc.thePlayer.inventory;
		if (inv.getItemStack() == null && s.pokemonData.heldItemId != -1)
			return true;
		else if (inv.getItemStack() == null)
			return false;
		if (MaemeItemsHeld.getHeldItem(inv.getItemStack().itemID) != null)
			return true;
		return false;
	}

	private void drawPokemonInfo(int x, int y, SlotInventoryMaeme s) {
		if (s == null)
			return;
		this.drawGradientRect(s.x - 84, s.y - 2, s.x - 4, s.y + 20, -13158600, -13158600);
		MaemeDataPacket p = s.pokemonData;
		String displayName = p.name;
		if (!p.nickname.equals(""))
			displayName = p.nickname;
		fontRenderer.drawString(displayName, s.x - 82, s.y, 0xFFFFFF);
		Minecraft.getMinecraft().renderEngine.bindTexture("/maemesoft/gui/pixelmonOverlay.png");
		if (p.isMale)
			this.drawTexturedModalRect(fontRenderer.getStringWidth(displayName) + s.x - 81, s.y, 33, 208, 5, 9);
		else
			this.drawTexturedModalRect(fontRenderer.getStringWidth(displayName) + s.x - 81, s.y, 33, 218, 5, 9);
		fontRenderer.drawString("Lvl " + p.lvl, s.x + -81, s.y + fontRenderer.FONT_HEIGHT + 1, 0xFFFFFF);
		if (p.health <= 0) {
			fontRenderer.drawString("Fainted", s.x - 77 + fontRenderer.getStringWidth("Lvl " + p.lvl), s.y + fontRenderer.FONT_HEIGHT + 1, 0xFFFFFF);
		} else {
			fontRenderer.drawString("HP " + p.health + "/" + p.hp, s.x - 77 + fontRenderer.getStringWidth("Lvl " + p.lvl), s.y + fontRenderer.FONT_HEIGHT + 1,
					0xFFFFFF);
		}

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

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		super.actionPerformed(par1GuiButton);
	}

	Rectangle buttonBounds;
	Rectangle buttonBoundsMoves;
	Rectangle buttonBoundsStat;

	@Override
	protected void mouseClicked(int x, int y, int par3) {
		if (par3 == 0) {
			if (pixelmonMenuOpen && buttonBounds.contains(x, y)) {
				GuiScreenPokeChecker poke = new GuiScreenPokeChecker(selected, false);
				mc.thePlayer.openGui(Maeme.instance, EnumGui.PokeChecker.getIndex(), mc.theWorld, selected.pokemonID, 0, 0);
			}
			if (pixelmonMenuOpen && buttonBoundsMoves.contains(x, y)) {
				GuiScreenPokeChecker poke = new GuiScreenPokeCheckerMoves(selected, false);
				mc.thePlayer.openGui(Maeme.instance, EnumGui.PokeCheckerMoves.getIndex(), mc.theWorld, selected.pokemonID, 0, 0);
			}
			if (pixelmonMenuOpen && buttonBoundsStat.contains(x, y)) {
				GuiScreenPokeChecker poke = new GuiScreenPokeChecker(selected, false);
				mc.thePlayer.openGui(Maeme.instance, EnumGui.PokeCheckerStats.getIndex(), mc.theWorld, selected.pokemonID, 0, 0);
			}
			if (pixelmonMenuOpen) {
				buttonList.remove(pMenuButtonSumm);
				buttonList.remove(pMenuButtonMove);
				buttonList.remove(pMenuButtonStat);
				pMenuButtonSumm = null;
				pMenuButtonMove = null;
				pMenuButtonStat = null;
				pixelmonMenuOpen = false;
				selected = null;
			}
		}
		for (SlotInventoryMaeme s : pixelmonSlots) {
			if (s != null) {
				if (s.getBounds().contains(x, y)) { // click on a pokemon sprite
					if (par3 == 1) {
						if (pixelmonMenuOpen) {
							buttonList.remove(pMenuButtonSumm);
							buttonList.remove(pMenuButtonMove);
							buttonList.remove(pMenuButtonStat);
							pMenuButtonSumm = null;
							pMenuButtonMove = null;
							pMenuButtonStat = null;
							pixelmonMenuOpen = false;
							selected = null;
						}
						pMenuButtonSumm = new GuiPokeCheckerTabs(6, 3, x - 63, y + 5, 47, 13, "Summary");
						pMenuButtonMove = new GuiPokeCheckerTabs(6, 4, x - 63, y + 24, 47, 13, "Moves");
						pMenuButtonStat = new GuiPokeCheckerTabs(6, 5, x - 63, y + 43, 47, 13, "Stats");
						menuX = x;
						menuY = y;
						buttonBounds = new Rectangle(x - 63, y + 5, 47, 13);
						buttonBoundsMoves = new Rectangle(x - 63, y + 24, 47, 13);
						buttonBoundsStat = new Rectangle(x - 63, y + 43, 47, 13);
						buttonList.add(pMenuButtonSumm);
						buttonList.add(pMenuButtonMove);
						buttonList.add(pMenuButtonStat);
						pixelmonMenuOpen = true;
						selected = s.pokemonData;
						return;
					} else if (par3 == 0) {

					}
				}
				if (s.getHeldItemBounds().contains(x, y) && heldItemQualifies(s)) {
					InventoryPlayer inventory = mc.thePlayer.inventory;
					ItemStack currentItem = inventory.getItemStack();
					int oldItemId = s.pokemonData.heldItemId;
					int itemId = currentItem == null ? -1 : currentItem.itemID;

					s.pokemonData.heldItemId = itemId;

					if (currentItem != null)
						currentItem.stackSize--;
					if (oldItemId == -1 || MaemeItemsHeld.getHeldItem(oldItemId) == null) {
						if (currentItem == null || currentItem.stackSize <= 0)
							inventory.setItemStack(null);
						else
							inventory.setItemStack(currentItem);
					} else {
						if (itemId == -1) {
							inventory.setItemStack(new ItemStack(MaemeItemsHeld.getHeldItem(oldItemId)));
						} else if (itemId != oldItemId) {
							if (currentItem.stackSize <= 0)
								inventory.setItemStack(new ItemStack(MaemeItemsHeld.getHeldItem(oldItemId)));
							else
								inventory.setItemStack(currentItem);
						} else {
							currentItem.stackSize++;
							inventory.setItemStack(currentItem);
						}
					}
					if (currentItem != null)
						PacketDispatcher.sendPacketToServer(PacketCreator.createPacket(EnumPackets.SetHeldItem, s.pokemonData.pokemonID, currentItem.itemID));
					else
						PacketDispatcher.sendPacketToServer(PacketCreator.createPacket(EnumPackets.SetHeldItem, s.pokemonData.pokemonID, -1));
					return;
				}
			}
		}
		if (x > width / 2 - 130 && x < width / 2 - 84 && y > height / 2 - 83 && y < height / 2 + 83)
			return;
		super.mouseClicked(x, y, par3);
	}
}