package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import maemesoft.common.EnumPackets;
import maemesoft.common.packetHandlers.PC.PCData;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerComputerStorage;
import maemesoft.storage.PlayerNotLoadedException;
import maemesoft.storage.PlayerStorage;
import cpw.mods.fml.common.network.Player;

public class RenamePokemon extends PacketHandlerBase {

	public RenamePokemon() {
		packetsHandled.add(EnumPackets.RenamePokemon);
	}

	@Override
	public void handlePacket(int index, Player pl, DataInputStream dataStream) throws IOException {
		EntityPlayerMP player = (EntityPlayerMP) pl;
		int id = dataStream.readInt();
		try {
			if (MaemeStorage.CardManager.getPlayerStorage(player).EntityAlreadyExists(id, player.worldObj)) {
				PlayerStorage storage = MaemeStorage.CardManager.getPlayerStorage(player);
				storage.getAlreadyExists(id, player.worldObj).setNickname(Packet.readString(dataStream, 64));
				MaemeStorage.CardManager.savePlayer(storage);
			} else if (MaemeStorage.CardManager.getPlayerStorage(player).getNBT(id) != null) {
				NBTTagCompound nbt = MaemeStorage.CardManager.getPlayerStorage(player).getNBT(id);
				if (nbt != null) {
					nbt.setString("Nickname", Packet.readString(dataStream, 64));
				}
				MaemeStorage.CardManager.savePlayer(MaemeStorage.CardManager.getPlayerStorage(player));
			} else if (MaemeStorage.ComputerManager.getPlayerStorage(player).contains(id)) {
				PlayerComputerStorage comp = MaemeStorage.ComputerManager.getPlayerStorage(player);

				NBTTagCompound nbt = comp.getPokemonNBT(id);
				if (nbt != null) {
					nbt.setString("Nickname", Packet.readString(dataStream, 64));
					comp.updatePokemonNBT(id, nbt);
				}
			} else if (PCData.getMousePokemon(player).nbt.getInteger("pixelmonID") == id) {
				NBTTagCompound nbt = PCData.getMousePokemon(player).nbt;
				if (nbt != null) {
					nbt.setString("Nickname", Packet.readString(dataStream, 64));
				}
			}
		} catch (PlayerNotLoadedException e) {
		}
	}

}