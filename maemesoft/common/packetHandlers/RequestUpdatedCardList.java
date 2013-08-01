package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;

import maemesoft.common.EnumPackets;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerNotLoadedException;
import maemesoft.storage.CardManager;

import cpw.mods.fml.common.network.Player;

public class RequestUpdatedCardList extends PacketHandlerBase {

	public RequestUpdatedCardList() {
		packetsHandled.add(EnumPackets.RequestUpdatedPokemonList);
	}

	@Override
	public void handlePacket(int index, Player player, DataInputStream dataStream) throws IOException {
		try {
			MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player).sendUpdatedList();
		} catch (PlayerNotLoadedException e) {
		}
	}

}