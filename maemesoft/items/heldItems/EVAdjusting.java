package maemesoft.items.heldItems;

import maemesoft.entities.maeme.stats.EVsStore;
import maemesoft.enums.heldItems.EnumEvAdjustingItems;
import maemesoft.enums.heldItems.EnumHeldItems;
import maemesoft.items.ItemHeld;

public class EVAdjusting extends ItemHeld {

	public EnumEvAdjustingItems type;

	public EVAdjusting(int id, EnumEvAdjustingItems type, String itemName) {
		super(id, EnumHeldItems.evAdjusting, type.toString().toLowerCase(), itemName);
		this.type = type;
	}
}