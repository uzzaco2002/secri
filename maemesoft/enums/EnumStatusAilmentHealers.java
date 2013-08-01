package maemesoft.enums;

import net.minecraft.item.Item;
import maemesoft.config.MaemeItems;

public enum EnumStatusAilmentHealers {
	FullRestore(66, "all", true, "fullrestore"), Antidote(82, "Poison", false, "antidote"), ParlyzHeal(98, "Paralysis", false, "parlyzheal"), 
	Awakening(114, "Sleep", false, "awakening"), BurnHeal(130, "Burn", false, "burn"), IceHeal(146, "Freeze", false, "iceheal"), 
	FullHeal(162, "all", false, "fullheal");

	private EnumStatusAilmentHealers(int index, String status, boolean healsHP, String filenamePrefix) {
		this.index = index;
		this.filenamePrefix = filenamePrefix;
		this.healsHP = healsHP;
	}
	private boolean healsHP;
	private int index;
	private String filenamePrefix;

	public boolean healsHP() {
		return healsHP;
	}

	public int getIndex() {
		return index;
	}

	public Item getItem() {
		if (index == 66)
			return MaemeItems.fullRestore;
		if (index == 82)
			return MaemeItems.antidote;
		if (index == 98)
			return MaemeItems.parlyzHeal;
		if (index == 114)
			return MaemeItems.awakening;
		if (index == 130)
			return MaemeItems.burnHeal;
		if (index == 146)
			return MaemeItems.iceHeal;
		if (index == 162)
			return MaemeItems.fullHeal;
		return MaemeItems.potion;
	}

	public String getTexture() {
		return filenamePrefix;
	}

	public static EnumStatusAilmentHealers getFromIndex(int index) {
		if (index == 66)
			return EnumStatusAilmentHealers.FullRestore;
		if (index == 82)
			return EnumStatusAilmentHealers.Antidote;
		if (index == 98)
			return EnumStatusAilmentHealers.ParlyzHeal;
		if (index == 114)
			return EnumStatusAilmentHealers.Awakening;
		if (index == 130)
			return EnumStatusAilmentHealers.BurnHeal;
		if (index == 146)
			return EnumStatusAilmentHealers.IceHeal;
		if (index == 162)
			return EnumStatusAilmentHealers.FullHeal;
		else
			return EnumStatusAilmentHealers.FullRestore;
	}
}