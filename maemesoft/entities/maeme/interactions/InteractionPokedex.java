package maemesoft.entities.maeme.interactions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import maemesoft.api.interactions.IInteraction;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerNotLoadedException;

public class InteractionPokedex implements IInteraction {

	@Override
	public boolean interact(EntityMaeme entityPixelmon, EntityPlayer player) {
		ItemStack itemstack = ((EntityPlayer) player).getCurrentEquippedItem();
		return false;
	}

}