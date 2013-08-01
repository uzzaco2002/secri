package maemesoft.items.heldItems;

import maemesoft.enums.heldItems.EnumChoiceItems;
import maemesoft.enums.heldItems.EnumHeldItems;
import maemesoft.items.ItemHeld;

public class ChoiceItem extends ItemHeld {

	private EnumChoiceItems choiceItemType;

	public ChoiceItem(int id, EnumChoiceItems choiceItemType, String itemName) {
		super(id, EnumHeldItems.choiceItem, choiceItemType.toString().toLowerCase(), itemName);
		this.choiceItemType = choiceItemType;
	}

	public double affectAttack(double attack) {
		if (choiceItemType == EnumChoiceItems.ChoiceBand)
			attack *= 1.5;
		return attack;
	}

	public double affectSpecialAttack(double attack) {
		if (choiceItemType == EnumChoiceItems.ChoiceSpecs)
			attack *= 1.5;
		return attack;
	}

	public double affectSpeed(int speed) {
		if (choiceItemType == EnumChoiceItems.ChoiceScarf)
			speed *= 1.5;
		return speed;
	}

}