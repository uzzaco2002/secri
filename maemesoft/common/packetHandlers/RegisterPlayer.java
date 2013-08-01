package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;
import maemesoft.Maeme;
import maemesoft.common.EnumPackets;
import maemesoft.enums.EnumGui;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerNotLoadedException;
import cpw.mods.fml.common.network.Player;

public class RegisterPlayer extends PacketHandlerBase {

	public RegisterPlayer() {
		packetsHandled.add(EnumPackets.RegisterPlayer);
	}

	@Override
	public void handlePacket(int index, Player pl, DataInputStream dataStream) throws IOException {
		EntityPlayerMP player = (EntityPlayerMP) pl;
		try {
			if (MaemeStorage.CardManager.getPlayerStorage(player).count() == 0) {
				player.openGui(Maeme.instance, EnumGui.ChooseStarter.getIndex(), player.worldObj, 0, 0, 0);
			}
		} catch (PlayerNotLoadedException e) {
		}
	}

}