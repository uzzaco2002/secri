package maemesoft.items.heldItems;

import maemesoft.common.ChatHandler;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.enums.heldItems.EnumHeldItems;
import maemesoft.items.ItemHeld;

public class ItemBerryOran extends ItemHeld {

	public ItemBerryOran(int id) {
		super(id, EnumHeldItems.oran, "oranberry", "Oran Berry");
		SetUsableInBattle(true);
	}

	public boolean effectEntity(EntityMaeme helper) {
		if (helper.getHealth() < (int) ((float) helper.getMaxHealth() / .3f)) {
			helper.setEntityHealth(helper.getHealth() + 10);
			ChatHandler.sendChat(helper.getOwner(), helper.getNickname() + " just consumed an Oran Berry and gained 10 health!");
			return true;
		}
		return false;
	}

	@Override
	public void useFromBag(EntityMaeme userPokemon, EntityMaeme targetPokemon) {
		if (userPokemon.getHealth()+10 > userPokemon.stats.HP)
			userPokemon.setEntityHealth(userPokemon.stats.HP);
		else
			userPokemon.setEntityHealth(userPokemon.getHealth() + 10);
		ChatHandler.sendChat(userPokemon.getOwner(), userPokemon.getNickname() + " gained 10 health!");
	}

}