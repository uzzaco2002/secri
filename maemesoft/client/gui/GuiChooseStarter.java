package maemesoft.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.network.packet.Packet250CustomPayload;
import maemesoft.StarterList;
import maemesoft.common.EnumPackets;
import maemesoft.common.PacketCreator;
import maemesoft.gui.ContainerEmpty;
import maemesoft.storage.PlayerStorage;
import cpw.mods.fml.common.network.PacketDispatcher;

public class GuiChooseStarter extends GuiContainer {

	String[] starterList; // 

	public GuiChooseStarter() {
		super(new ContainerEmpty());
		starterList = StarterList.getStarterStringList();
	}

	@SuppressWarnings("unchecked")
	public void initGui() {
		super.initGui();
		buttonList.clear();
		for (int i = 0; i < starterList.length; i++) { // starterList.length는 스트링갯수에 따라 달라짐
			buttonList.add(new GuiButton(i, width / 3 - 100, height / 6 + i * 20, starterList[i]));
		}
	}

	public void keyTyped(char i, int i1) {
	}

	public void actionPerformed(GuiButton button) {
		String pixelmonName = starterList[button.id];
		Packet250CustomPayload packet = PacketCreator.createPacket(EnumPackets.ChooseStarter, button.id);
		PacketDispatcher.sendPacketToServer(packet);
		//PlayerStorage.setCurrency(3000);
		mc.thePlayer.closeScreen();
	}

	public void drawGuiContainerBackgroundLayer(float par3, int par1, int par2) {
		drawDefaultBackground();
		drawCenteredString(fontRenderer, "매미의 궁궐에 당도한것을 환영하오.", width / 2, 10, 0xFFFFFF);
		drawCenteredString(fontRenderer, "나는 유저들을 굽어살피는 매미로다...", width / 2, 20, 0xFFFFFF);
		drawCenteredString(fontRenderer, "그건 그렇고 캐릭터나 골라잡으셈 ㅇㅇ", width / 2, 30, 0xFFFFFF);
	}
}