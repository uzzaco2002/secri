package maemesoft.entities.maeme.interactions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import maemesoft.api.interactions.IInteraction;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.items.ItemHeld;
import maemesoft.storage.MaemeStorage;

public class InteractionHeldItem implements IInteraction {

	@Override
	public boolean interact(EntityMaeme entityPixelmon, EntityPlayer player) {
		if (player instanceof EntityPlayerMP) {
			if (entityPixelmon.getOwner() == player) {
				ItemStack itemstack = ((EntityPlayer) player).getCurrentEquippedItem();
				if (itemstack.getItem() instanceof ItemHeld) {
					if (entityPixelmon.getHeldItem() != null) {
						if (!entityPixelmon.worldObj.isRemote) {
							entityPixelmon.entityDropItem(entityPixelmon.heldItem.copy(), 1f);
						}
						entityPixelmon.setHeldItem(null);
					}
					ItemStack itemstack1 = itemstack.copy();
					itemstack1.stackSize = 1;
					player.inventory.consumeInventoryItem(itemstack.itemID);
					entityPixelmon.setHeldItem(itemstack1);
					entityPixelmon.updateNBT();
					return true;
				}
			}
		}
		return false;
	}

}