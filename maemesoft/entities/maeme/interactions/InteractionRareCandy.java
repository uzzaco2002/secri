package maemesoft.entities.maeme.interactions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import maemesoft.api.interactions.IInteraction;
import maemesoft.config.MaemeItems;
import maemesoft.entities.maeme.EntityMaeme;

public class InteractionRareCandy implements IInteraction {

	@Override
	public boolean interact(EntityMaeme entityPixelmon, EntityPlayer player) {
		if (player instanceof EntityPlayerMP) {
			if (entityPixelmon.getOwner() == player) {
				ItemStack itemstack = ((EntityPlayer) player).getCurrentEquippedItem();
				if (itemstack.itemID == MaemeItems.rareCandy.itemID) {
					entityPixelmon.getLvl().awardEXP(entityPixelmon.getLvl().getExpToNextLevel() - entityPixelmon.getLvl().getExp());
					if (!player.capabilities.isCreativeMode)
						player.inventory.consumeInventoryItem(itemstack.itemID);
					return true;
				}
			}
		}
		return false;
	}

}