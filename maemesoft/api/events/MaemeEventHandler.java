package maemesoft.api.events;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;

public class MaemeEventHandler {
	private static ArrayList<IMaemeEventHandler> eventHandlers = new ArrayList<IMaemeEventHandler>();

	public static void registerEventHandler(IMaemeEventHandler e){
		eventHandlers.add(e);
	}

	public static void deRegisterEventHandler(IMaemeEventHandler e){
		eventHandlers.remove(e);
	}

	public static void fireEvent(EventType e, EntityPlayer player){
		for (int i =0; i < eventHandlers.size(); i++){
			eventHandlers.get(i).eventFired(e, player);
		}
	}
}