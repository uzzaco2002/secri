package maemesoft.common.packetHandlers.PC;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;

import cpw.mods.fml.common.network.Player;
import maemesoft.common.EnumPackets;
import maemesoft.common.packetHandlers.PacketHandlerBase;

public class PCTrashPokemon extends PacketHandlerBase {

	public PCTrashPokemon() {
		packetsHandled.add(EnumPackets.PCTrashPokemon);
	}

	@Override
	public void handlePacket(int index, Player pl, DataInputStream data) throws IOException {
		EntityPlayer player = (EntityPlayer) pl;
		PCData.setMousePokemon(player, null);
	}

}
