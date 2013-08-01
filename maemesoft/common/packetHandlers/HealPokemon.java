package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import maemesoft.common.EnumPackets;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerNotLoadedException;
import cpw.mods.fml.common.network.Player;

public class HealPokemon extends PacketHandlerBase {

	public HealPokemon() {
		packetsHandled.add(EnumPackets.HealPokemon);
	}

	@Override
	public void handlePacket(int index, Player pl, DataInputStream dataStream) throws IOException {
		EntityPlayer player = (EntityPlayer) pl;
		int ind = dataStream.readInt();
		try {
			if (ind == -1)
				MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player).healAllPokemon();
			else
				MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player).heal(ind);
		} catch (PlayerNotLoadedException e) {
		}
	}
}