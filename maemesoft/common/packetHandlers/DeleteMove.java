package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;
import maemesoft.common.ChatHandler;
import maemesoft.common.EnumPackets;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerNotLoadedException;
import maemesoft.storage.PlayerStorage;
import cpw.mods.fml.common.network.Player;

public class DeleteMove extends PacketHandlerBase {

	public DeleteMove() {
		packetsHandled.add(EnumPackets.DeleteMove);
	}

	@Override
	public void handlePacket(int index, Player pl, DataInputStream dataStream) throws IOException {
		int pokemonID = dataStream.readInt();
		int removeIndex = dataStream.readInt();

		EntityPlayerMP player = (EntityPlayerMP) pl;
		try {
			PlayerStorage storage = MaemeStorage.CardManager.getPlayerStorage(player);
			EntityMaeme p;
			if (storage.EntityAlreadyExists(pokemonID, player.worldObj))
				p = storage.getAlreadyExists(pokemonID, player.worldObj);
			else
				p = storage.sendOut(pokemonID, player.worldObj);
			storage.updateNBT(p);
		} catch (PlayerNotLoadedException e) {
		}
	}
}