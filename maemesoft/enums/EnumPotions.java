package maemesoft.enums;

import net.minecraft.item.Item;
import maemesoft.config.MaemeItems;

public enum EnumPotions {
	Potion(2, 20, 0, "potion"), SuperPotion(18, 50, 0, "superpotion"),
	HyperPotion(34, 200, 0, "hyperpotion"), MaxPotion(50, 0, 100, "maxpotion");

	private EnumPotions(int index, int healAmount, int healPercent, String filenamePrefix) {
		this.healAmount = healAmount;
		this.healPercent = healPercent;
		this.index = index;
		this.filenamePrefix = filenamePrefix;
	}

	private int healAmount;
	private int healPercent;
	private int index;
	private String filenamePrefix;

	public int getHealAmount() {
		return healAmount;
	}

	public int getHealPercent() {
		return healPercent;
	}

	public int getIndex() {
		return index;
	}

	public Item getItem() {
		if (index == 2)
			return MaemeItems.potion;
		if (index == 18)
			return MaemeItems.superPotion;
		if (index == 34)
			return MaemeItems.hyperPotion;
		if (index == 50)
			return MaemeItems.maxPotion;
		return MaemeItems.potion;
	}

	public String getTexture() {
		return filenamePrefix;
	}

	public static EnumPotions getFromIndex(int index) {
		if (index == 2)
			return EnumPotions.Potion;
		if (index == 18)
			return EnumPotions.SuperPotion;
		if (index == 34)
			return EnumPotions.HyperPotion;
		if (index == 50)
			return EnumPotions.MaxPotion;
		else
			return EnumPotions.Potion;
	}
}