package maemesoft.api.interactions;

import maemesoft.entities.maeme.EntityMaeme;
import net.minecraft.entity.player.EntityPlayer;

public interface IInteraction {
	boolean interact(EntityMaeme entityMaeme, EntityPlayer player);
}