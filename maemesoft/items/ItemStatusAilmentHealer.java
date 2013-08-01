package maemesoft.items;

import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.enums.EnumStatusAilmentHealers;

public class ItemStatusAilmentHealer extends MaemeItem {
	public EnumStatusAilmentHealers type;

	public ItemStatusAilmentHealer(int par1, EnumStatusAilmentHealers type, String itemName) {
		super(par1, "healingitems/" + getTextureName(itemName), itemName);
		SetUsableInBattle(true);
		this.type = type;
		setMaxStackSize(16);
	}

	private static String getTextureName(String itemName) {
		String texName = "";
		for (int i = 0; i < itemName.length(); i++)
			if (itemName.charAt(i) != ' ')
				texName += itemName.charAt(i);

		return texName.toLowerCase();
	}

	@Override
	public void useFromBag(EntityMaeme userPokemon, EntityMaeme targetPokemon) {
		if (this.type.healsHP()) {
			userPokemon.setEntityHealth(userPokemon.stats.HP);
		}
	}

}