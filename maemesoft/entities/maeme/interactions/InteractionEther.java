package maemesoft.entities.maeme.interactions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import maemesoft.api.interactions.IInteraction;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.items.ItemEther;

public class InteractionEther implements IInteraction {

	@Override
	public boolean interact(EntityMaeme entityPixelmon, EntityPlayer player) {
		if (player instanceof EntityPlayerMP) {
			if (entityPixelmon.getOwner() == player) {
				ItemStack itemstack = ((EntityPlayer) player).getCurrentEquippedItem();
				if (itemstack.getItem() instanceof ItemEther) {
					boolean canUseEther = false;
					if (canUseEther) {
						ItemEther ether = (ItemEther) itemstack.getItem();
						if (ether.type.restoresAllMoves()) {
							if (!player.capabilities.isCreativeMode)
								player.inventory.consumeInventoryItem(itemstack.itemID);
							return true;
						} else {

						}
					}
				}
			}
		}
		return false;
	}

}