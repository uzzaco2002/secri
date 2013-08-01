package maemesoft.entities.maeme.interactions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import maemesoft.api.interactions.IInteraction;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.items.ItemEvolutionStone;

public class InteractionEvolutionStone implements IInteraction {

	@Override
	public boolean interact(EntityMaeme entityPixelmon, EntityPlayer player) {
		if (player instanceof EntityPlayerMP) {
			if (entityPixelmon.getOwner() == player) {
				ItemStack itemstack = ((EntityPlayer) player).getCurrentEquippedItem();
				if (itemstack.getItem() instanceof ItemEvolutionStone) {
					ItemEvolutionStone i = (ItemEvolutionStone) itemstack.getItem();
					return i.useOnEntity(itemstack, entityPixelmon, player);
				}
			}
		}
		return false;
	}

}