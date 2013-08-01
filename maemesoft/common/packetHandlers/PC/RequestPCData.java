package maemesoft.common.packetHandlers.PC;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

import maemesoft.common.EnumPackets;
import maemesoft.common.MaemeDataPacket;
import maemesoft.common.packetHandlers.PacketHandlerBase;
import maemesoft.storage.ComputerBox;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerComputerStorage;

import cpw.mods.fml.common.network.Player;

public class RequestPCData extends PacketHandlerBase {

	public RequestPCData() {
		packetsHandled.add(EnumPackets.RequestPCData);
	}

	@Override
	public void handlePacket(int index, Player player, DataInputStream dataStream) throws IOException {
		PCData.guiOpen.put((EntityPlayer) player, true);
		PlayerComputerStorage s = MaemeStorage.ComputerManager.getPlayerStorage((EntityPlayerMP) player);
		for (ComputerBox b : s.getBoxList()) {
			for (NBTTagCompound n : b.getStoredPokemon()) {
				if (n != null) {
					MaemeDataPacket p = new MaemeDataPacket(n, EnumPackets.AddToTempStore);
					((EntityPlayerMP) player).playerNetServerHandler.sendPacketToPlayer(p.getPacket());
				}
			}
		}
	}

}