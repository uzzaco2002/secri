package maemesoft.items;

import net.minecraft.item.ItemStack;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.enums.heldItems.EnumHeldItems;

/**
 * 
 * IF THE ITEM IS TO BE HELD BY A PIXELMON, USE THIS AND EDIT WHAT YOU NEED
 * 
 * @author Gerald -xkyouchoux-
 * 
 */

public abstract class ItemHeld extends MaemeItem {
	private EnumHeldItems heldItemType;
	private boolean usableInBattle;
	private boolean affectsBattles;

	public ItemHeld(int id, EnumHeldItems heldItemType, String textureName, String itemName) {
		super(id, "helditems/" + textureName, itemName);
		isEquippable = true;
		this.heldItemType = heldItemType;
		usableInBattle = heldItemType.getUsableInBattle();
		affectsBattles = heldItemType.getAffectsBattle();
	}

	public EnumHeldItems getHeldItemType() {
		return heldItemType;
	}

	public boolean usableInBattle() {
		return usableInBattle;
	}

	public boolean getAffectsBattle() {
		return affectsBattles;
	}

	public static void useItem(EntityMaeme user, EntityMaeme target, EnumHeldItems item) {
		if (user.getHeldItem() != null && user.getHeldItem().getItem() != null && user.getHeldItem().getItem() instanceof ItemHeld) {
			if (((ItemHeld) user.getHeldItem().getItem()).heldItemType == item && ((ItemHeld) user.getHeldItem().getItem()).effectEntity(user)) {
				user.setHeldItem(null);
			}
		}
	}

	public static boolean isItemOfType(ItemStack item, EnumHeldItems type) {
		if (item == null || (item != null && (item.getItem() == null || !(item.getItem() instanceof ItemHeld)))) {
			return false;
		} else
			return ((ItemHeld) item.getItem()).heldItemType == type;
	}

	public boolean effectEntity(EntityMaeme helper1) {
		return false;
	}

	public static void useBattleItems(EntityMaeme user, EntityMaeme target) {
		for (EnumHeldItems item : EnumHeldItems.values()) {
			if (!item.getUsableInBattle()) {
				continue;
			}
			useItem(user, target, item);
		}
	}
}