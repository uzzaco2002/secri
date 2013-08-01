package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import maemesoft.common.ChatHandler;
import maemesoft.common.EnumPackets;
import cpw.mods.fml.common.network.Player;

public class BagPacket extends PacketHandlerBase {

	public BagPacket() {
		packetsHandled.add(EnumPackets.BagPacket);
	}

	@Override
	public void handlePacket(int index, Player player, DataInputStream dataStream) throws IOException {
		int itemIndex = dataStream.readInt();
		int battleIndex = dataStream.readInt();
		int additionalInfo = dataStream.readInt();

		ItemStack usedStack = null;
		for (ItemStack i : ((EntityPlayer) player).inventory.mainInventory) {
		     if (i != null && i.getItem().itemID == itemIndex){
				usedStack = i;
				break;
		     }
		}

		if (usedStack == null) {
			ChatHandler.sendChat((EntityPlayer) player, "Item Could not be found!");
			return;
		}
	}

}