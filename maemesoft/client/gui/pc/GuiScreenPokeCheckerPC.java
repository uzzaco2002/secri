package maemesoft.client.gui.pc;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import maemesoft.client.gui.pokechecker.GuiRenamePokemon;
import maemesoft.client.gui.pokechecker.GuiScreenPokeChecker;
import maemesoft.client.gui.pokechecker.GuiScreenPokeCheckerMoves;
import maemesoft.client.gui.pokechecker.GuiScreenPokeCheckerStats;
import maemesoft.client.gui.pokechecker.GuiScreenPokeCheckerWarning;
import maemesoft.common.EnumPackets;
import maemesoft.common.PacketCreator;
import maemesoft.common.MaemeDataPacket;
import cpw.mods.fml.common.network.PacketDispatcher;

public class GuiScreenPokeCheckerPC extends GuiScreenPokeChecker {

	private int index, box;

	public GuiScreenPokeCheckerPC(MaemeDataPacket packet, int box, int index) {
		super(packet, true);
		this.index = index;
		this.box = box;
	}

	public void initGui() {
		super.initGui();
	}

	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
	}

	public void actionPerformed(GuiButton button) {
		switch (button.id) {
		case 0:
			GuiPC gui = new GuiPC(targetPacket);
			mc.displayGuiScreen(gui);
			break;
		case 1:
			mc.displayGuiScreen(new GuiScreenPokeCheckerMoves(targetPacket, true));
			break;
		case 2:
			mc.displayGuiScreen(new GuiScreenPokeCheckerStats(targetPacket, true));
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

	public void keyTyped(char c, int i) {
		if (i == 1) {
			GuiPC gui = new GuiPC(targetPacket);
			mc.displayGuiScreen(gui);
		}
	}

}