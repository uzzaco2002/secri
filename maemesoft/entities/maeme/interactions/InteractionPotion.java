package maemesoft.entities.maeme.interactions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import maemesoft.api.interactions.IInteraction;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.items.ItemPotion;

public class InteractionPotion implements IInteraction {

	@Override
	public boolean interact(EntityMaeme entityPixelmon, EntityPlayer player) {
		if (player instanceof EntityPlayerMP) {
			ItemStack itemstack = ((EntityPlayer) player).getCurrentEquippedItem();
			if (itemstack.getItem() instanceof ItemPotion) {
				if (entityPixelmon.getHealth() < entityPixelmon.stats.HP) {
					((ItemPotion) itemstack.getItem()).healPokemon(entityPixelmon);
					if (!player.capabilities.isCreativeMode)
						player.inventory.consumeInventoryItem(itemstack.itemID);
					return true;
				}
			}
		}
		return false;
	}
}