package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;
import maemesoft.common.EnumPackets;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerComputerStorage;
import maemesoft.storage.PlayerNotLoadedException;
import maemesoft.storage.PlayerStorage;
import cpw.mods.fml.common.network.Player;

public class SwapMove extends PacketHandlerBase {

	public SwapMove() {
		packetsHandled.add(EnumPackets.SwapMove);
	}

	@Override
	public void handlePacket(int index, Player pl, DataInputStream dataStream) throws IOException {
		int pokemonID = dataStream.readInt();
		int selected = dataStream.readInt();
		int clicked = dataStream.readInt();

		EntityPlayerMP player = (EntityPlayerMP) pl;
		try {
			if (MaemeStorage.CardManager.getPlayerStorage(player).contains(pokemonID)) {
				PlayerStorage storage = MaemeStorage.CardManager.getPlayerStorage(player);
				EntityMaeme p;
				if (storage.EntityAlreadyExists(pokemonID, player.worldObj))
					p = storage.getAlreadyExists(pokemonID, player.worldObj);
				else
					p = storage.sendOut(pokemonID, player.worldObj);
				storage.updateNBT(p);
			} else if (MaemeStorage.ComputerManager.getPlayerStorage(player).contains(pokemonID)) {
				PlayerComputerStorage compStore = MaemeStorage.ComputerManager.getPlayerStorage(player);
				EntityMaeme p = compStore.getPokemonEntity(pokemonID);
				compStore.updatePokemonEntry(p);
			}
		} catch (PlayerNotLoadedException e) {
		}
	}
}