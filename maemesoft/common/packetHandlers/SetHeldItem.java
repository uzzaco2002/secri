package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import maemesoft.common.EnumPackets;
import maemesoft.config.MaemeItems;
import maemesoft.config.MaemeItemsHeld;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerNotLoadedException;
import maemesoft.storage.PlayerStorage;
import cpw.mods.fml.common.network.Player;

public class SetHeldItem extends PacketHandlerBase {

	public SetHeldItem() {
		packetsHandled.add(EnumPackets.SetHeldItem);
	}

	@Override
	public void handlePacket(int index, Player player, DataInputStream dataStream) throws IOException {
		int pokemonId = dataStream.readInt();
		int itemId = dataStream.readInt();
		try {
			PlayerStorage storage = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player);
			int oldItemId = storage.getNBT(pokemonId).getInteger("HeldItem");
			if (storage.EntityAlreadyExists(pokemonId, ((EntityPlayerMP) player).worldObj)) {
				EntityMaeme pixelmon = storage.getAlreadyExists(pokemonId, ((EntityPlayerMP) player).worldObj);
				Item heldItem = MaemeItemsHeld.getHeldItem(itemId);
				if (heldItem != null)
					pixelmon.heldItem = new ItemStack(heldItem);
				else
					pixelmon.heldItem = null;
				storage.updateNBT(pixelmon);
			} else {
				storage.getNBT(pokemonId).setInteger("HeldItem", itemId);
			}

			ItemStack currentItem = ((EntityPlayerMP) player).inventory.getItemStack();
			if (currentItem != null)
				currentItem.stackSize--;
			if (oldItemId == -1) {
				if (currentItem == null || currentItem.stackSize <= 0)
					((EntityPlayerMP) player).inventory.setItemStack(null);
				else
					((EntityPlayerMP) player).inventory.setItemStack(currentItem);
			} else {
				if (itemId == -1) {
					((EntityPlayerMP) player).inventory.setItemStack(new ItemStack(MaemeItemsHeld.getHeldItem(oldItemId)));
				} else if (itemId != oldItemId) {
					if (currentItem == null || currentItem.stackSize <= 0)
						((EntityPlayerMP) player).inventory.setItemStack(new ItemStack(MaemeItemsHeld.getHeldItem(oldItemId)));
					else {
						((EntityPlayerMP) player).inventory.setItemStack(currentItem);
						Item item = MaemeItemsHeld.getHeldItem(oldItemId);
						if (item != null)
							((EntityPlayerMP) player).dropPlayerItem(new ItemStack(item));
					}
				} else {
					if (currentItem != null)
						currentItem.stackSize++;
					((EntityPlayerMP) player).inventory.setItemStack(currentItem);
				}
			}
		} catch (PlayerNotLoadedException e) {
		}
	}
}