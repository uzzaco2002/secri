package maemesoft.items;

import maemesoft.enums.EnumPokeballs;

public class ItemPokeballLid extends MaemeItem {

	public EnumPokeballs pokeball;

	public ItemPokeballLid(int id, EnumPokeballs type) {
		super(id, "pokeballs/" + type.toString().toLowerCase() + "lid", type.toString().substring(0, type.toString().indexOf("Ball")) + " Ball Lid");
		this.pokeball = type;
		SetUsableInBattle(false);
		maxStackSize = 64;
		setMaxDamage(0xf4240);
	}

}