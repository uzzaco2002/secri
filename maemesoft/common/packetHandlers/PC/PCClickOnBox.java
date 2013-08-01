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

public class PCClickOnBox extends PacketHandlerBase {

	public PCClickOnBox() {
		packetsHandled.add(EnumPackets.PCClickOnBox);
	}

	@Override
	public void handlePacket(int index, Player pl, DataInputStream data) throws IOException {
		EntityPlayer player = (EntityPlayer) pl;
		int box = data.readInt();
		int boxPos = data.readInt();
		NBTTagCompound n1 = null;
		if (PCData.getMousePokemon(player) != null)
			n1 = PCData.getMousePokemon(player).nbt;
		NBTTagCompound n = MaemeStorage.ComputerManager.getPlayerStorage(player).getBox(box).getNBTByPosition(boxPos);
		PCData.setMousePokemon(player, new MapEntry(n, box, boxPos));
		MaemeStorage.ComputerManager.getPlayerStorage(player).changePokemon(box, boxPos, n1);
		return;
	}

}