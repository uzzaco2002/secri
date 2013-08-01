package maemesoft.api;

import maemesoft.Maeme;
import maemesoft.api.interactions.IInteraction;
import maemesoft.client.ClientProxy;
import maemesoft.entities.maeme.EntityMaeme;

public class MaemeApi {
	public static void addInteraction(IInteraction interaction){
		EntityMaeme.interactionList.add(interaction);
	}

	public static void addModelLibrary(String location){
		ClientProxy.modelPaths.add(0, location);
	}
}