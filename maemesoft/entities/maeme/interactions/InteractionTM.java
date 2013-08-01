package maemesoft.entities.maeme.interactions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import maemesoft.api.interactions.IInteraction;
import maemesoft.common.ChatHandler;
import maemesoft.common.EnumPackets;
import maemesoft.common.PacketCreator;
import maemesoft.common.packetHandlers.ReplaceMove;
import maemesoft.db.DBMoves;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.items.ItemTM;
import maemesoft.storage.MaemeStorage;

public class InteractionTM implements IInteraction {

	@Override
	public boolean interact(EntityMaeme entityPixelmon, EntityPlayer player) {
		if (player instanceof EntityPlayerMP) {
			ItemStack itemstack = ((EntityPlayer) player).getCurrentEquippedItem();
			if (itemstack.getItem() instanceof ItemTM) {
				if (player != entityPixelmon.getOwner())
					return true;
				return true;
			}
		}
		return false;
	}

}