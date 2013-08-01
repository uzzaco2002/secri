package maemesoft.common.packetHandlers.PC;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

import cpw.mods.fml.common.network.Player;
import maemesoft.common.EnumPackets;
import maemesoft.common.packetHandlers.PacketHandlerBase;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerNotLoadedException;

public class PCClickOnParty extends PacketHandlerBase {

	public PCClickOnParty() {
		packetsHandled.add(EnumPackets.PCClickOnParty);
	}

	@Override
	public void handlePacket(int index, Player pl, DataInputStream data) throws IOException {
		EntityPlayer player = (EntityPlayer) pl;
		int pos = data.readInt();
		try {
			int id = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player).getIDFromPosition(pos);
			NBTTagCompound n = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player).getNBT(id);
			NBTTagCompound n1 = null;
			if (PCData.getMousePokemon(player) != null)
				n1 = PCData.getMousePokemon(player).nbt;
			PCData.setMousePokemon(player, new MapEntry(n, -1, pos));
			MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player).changePokemon(pos, n1);

			if (PCData.getMousePokemon(player) != null) {
				n1 = PCData.getMousePokemon(player).nbt;
				if (n1 != null
						&& MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player).EntityAlreadyExists(n1.getInteger("pixelmonID"),
								player.worldObj)) {
					EntityMaeme pixelmon = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player).getAlreadyExists(
							n1.getInteger("pixelmonID"), player.worldObj);
					MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player).retrieve(pixelmon);
					pixelmon.catchInPokeball();
				}
			}
		} catch (PlayerNotLoadedException e) {
		}
	}

}