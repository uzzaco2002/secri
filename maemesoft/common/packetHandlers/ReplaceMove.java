package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;
import maemesoft.common.ChatHandler;
import maemesoft.common.EnumPackets;
import maemesoft.db.DBMoves;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerNotLoadedException;
import maemesoft.storage.PlayerStorage;
import cpw.mods.fml.common.network.Player;

public class ReplaceMove extends PacketHandlerBase {
	public static int tmID = -1;

	public ReplaceMove() {
		packetsHandled.add(EnumPackets.ReplaceMove);
	}

	@Override
	public void handlePacket(int index, Player pl, DataInputStream dataStream) throws IOException {
		int pokemonID = dataStream.readInt();
		int moveToLearnIndex = dataStream.readInt();
		int replaceIndex = dataStream.readInt();

		EntityPlayerMP player = (EntityPlayerMP) pl;
		try {
			PlayerStorage storage = MaemeStorage.CardManager.getPlayerStorage(player);
			EntityMaeme p;
			if (storage.EntityAlreadyExists(pokemonID, player.worldObj))
				p = storage.getAlreadyExists(pokemonID, player.worldObj);
			else
				p = storage.sendOut(pokemonID, player.worldObj);
			storage.updateNBT(p);
			if (tmID != -1) {
				if (!player.capabilities.isCreativeMode)
					player.inventory.consumeInventoryItem(tmID);
			}
		} catch (PlayerNotLoadedException e) {
		}
	}
}