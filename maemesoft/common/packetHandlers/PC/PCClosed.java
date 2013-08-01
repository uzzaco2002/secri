package maemesoft.common.packetHandlers.PC;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import maemesoft.common.EnumPackets;
import maemesoft.common.packetHandlers.PacketHandlerBase;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerNotLoadedException;
import cpw.mods.fml.common.network.Player;

public class PCClosed extends PacketHandlerBase {

	public PCClosed() {
		packetsHandled.add(EnumPackets.PCClosed);
	}

	@Override
	public void handlePacket(int index, Player pl, DataInputStream dataStream) throws IOException {
		EntityPlayer player = (EntityPlayer) pl;
		PCData.guiOpen.put(player, false);
		if (PCData.getMousePokemon(player) == null || PCData.getMousePokemon(player).nbt == null)
			return;
		MapEntry e = PCData.getMousePokemon(player);
		try {
			if (MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player).EntityAlreadyExists(e.nbt.getInteger("pixelmonID"), player.worldObj)) {
				EntityMaeme pixelmon = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player).getAlreadyExists(
						e.nbt.getInteger("pixelmonID"), player.worldObj);
				MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player).retrieve(pixelmon);
				pixelmon.catchInPokeball();
			}
			PCData.setMousePokemon(player, null);
			if (e.originalBox == -1)
				MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player).addToFirstEmptySpace(e.nbt);
			else
				MaemeStorage.ComputerManager.getPlayerStorage(player).addToBox(e.originalBox, e.nbt);
		} catch (PlayerNotLoadedException ex) {
		}
		return;
	}

}