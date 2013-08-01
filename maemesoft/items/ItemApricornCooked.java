package maemesoft.items;

import maemesoft.enums.EnumApricorns;

public class ItemApricornCooked extends MaemeItem {
	public EnumApricorns apricorn;

	public ItemApricornCooked(int id, EnumApricorns apricorn) {
		super(id, "apricorns/cooked" + apricorn.toString().toLowerCase() + "apricorn", "Cooked " + apricorn.toString() + " Apricorn");
		this.apricorn = apricorn;
		SetUsableInBattle(false);
		maxStackSize = 64;
		setMaxDamage(0xf4240);
	}
}