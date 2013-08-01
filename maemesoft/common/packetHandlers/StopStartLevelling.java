package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import maemesoft.common.EnumPackets;
import maemesoft.common.packetHandlers.PC.PCData;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerComputerStorage;
import maemesoft.storage.PlayerNotLoadedException;
import maemesoft.storage.PlayerStorage;
import cpw.mods.fml.common.network.Player;

public class StopStartLevelling extends PacketHandlerBase {

	public StopStartLevelling() {
		packetsHandled.add(EnumPackets.StopStartLevelling);
	}

	@Override
	public void handlePacket(int index, Player pl, DataInputStream dataStream) throws IOException {
		EntityPlayerMP player = (EntityPlayerMP) pl;
		int id = dataStream.readInt();
		try {
			if (MaemeStorage.CardManager.getPlayerStorage(player).EntityAlreadyExists(id, player.worldObj)) {
				PlayerStorage storage = MaemeStorage.CardManager.getPlayerStorage(player);
				EntityMaeme pixelmon = storage.getAlreadyExists(id, player.worldObj);
				pixelmon.doesLevel = !pixelmon.doesLevel;
				storage.updateNBT(pixelmon);
				MaemeStorage.CardManager.savePlayer(storage);
			} else if (MaemeStorage.CardManager.getPlayerStorage(player).getNBT(id) != null) {
				NBTTagCompound nbt = MaemeStorage.CardManager.getPlayerStorage(player).getNBT(id);
				if (nbt != null) {
					if (nbt.hasKey("DoesLevel")) {
						if (nbt.getBoolean("DoesLevel"))
							nbt.setBoolean("DoesLevel", false);
						else
							nbt.setBoolean("DoesLevel", true);
					} else
						nbt.setBoolean("DoesLevel", true);
				}
				MaemeStorage.CardManager.savePlayer(MaemeStorage.CardManager.getPlayerStorage(player));
			} else if (MaemeStorage.ComputerManager.getPlayerStorage(player).contains(id)) {
				PlayerComputerStorage comp = MaemeStorage.ComputerManager.getPlayerStorage(player);
				if (!comp.contains(id))
					return;

				NBTTagCompound nbt = comp.getPokemonNBT(id);
				if (nbt != null) {
					if (nbt.hasKey("DoesLevel")) {
						if (nbt.getBoolean("DoesLevel"))
							nbt.setBoolean("DoesLevel", false);
						else
							nbt.setBoolean("DoesLevel", true);
					} else
						nbt.setBoolean("DoesLevel", true);

					comp.updatePokemonNBT(id, nbt);
				}
			} else if (PCData.getMousePokemon(player).nbt.getInteger("pixelmonID") == id) {
				NBTTagCompound nbt = PCData.getMousePokemon(player).nbt;
				if (nbt != null) {
					if (nbt.hasKey("DoesLevel")) {
						if (nbt.getBoolean("DoesLevel"))
							nbt.setBoolean("DoesLevel", false);
						else
							nbt.setBoolean("DoesLevel", true);
					} else
						nbt.setBoolean("DoesLevel", true);
				}
			}
		} catch (PlayerNotLoadedException e) {
		}
	}
}