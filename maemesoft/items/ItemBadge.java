package maemesoft.items;

import maemesoft.enums.EnumBadges;

public class ItemBadge extends MaemeItem {
	public EnumBadges badge;

	public ItemBadge(int id, EnumBadges badges) {
		super(id, "badges/" + badges.toString().toLowerCase(), badges.toString().substring(0, badges.toString().indexOf("badge")) + " Badge");
		String badgeName = badges.toString();
		badgeName = badgeName.substring(0, badgeName.indexOf("badge"));
		this.badge = badges;
		SetUsableInBattle(false);
		maxStackSize = 64;
		setMaxDamage(0xf4240);
	}

}