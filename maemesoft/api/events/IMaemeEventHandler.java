package maemesoft.api.events;

import net.minecraft.entity.player.EntityPlayer;

public interface IMaemeEventHandler {
	public void eventFired(EventType eventType, EntityPlayer player);
}