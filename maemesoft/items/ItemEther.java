package maemesoft.items;

import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.enums.EnumEthers;

public class ItemEther extends MaemeItem {
	public EnumEthers type;

	public ItemEther(int par1, EnumEthers type, String itemName) {
		super(par1, "healingitems/" + type.getTexture(), itemName);
		SetUsableInBattle(true);
		this.type = type;
		setMaxStackSize(16);
	}

	@Override
	public void useFromBag(EntityMaeme userPokemon, EntityMaeme targetPokemon, int selectedMove) {
	}

}