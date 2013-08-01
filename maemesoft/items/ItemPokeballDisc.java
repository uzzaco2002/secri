package maemesoft.items;

import maemesoft.enums.EnumPokeballs;

public class ItemPokeballDisc extends MaemeItem {

	public EnumPokeballs pokeball;

	public ItemPokeballDisc(int id, EnumPokeballs type) {
		super(id, "pokeballs/" + type.toString().toLowerCase() + "disc", type.toString().substring(0, type.toString().indexOf("Ball")) + " Ball Disc");
		this.pokeball = type;
		SetUsableInBattle(false);
		maxStackSize = 64;
		setMaxDamage(0xf4240);
	}

}