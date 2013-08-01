package maemesoft.items;

import net.minecraft.item.Item;

public class ItemCoveredFossil extends MaemeItem {

	public ItemFossil cleanedFossil;

	public ItemCoveredFossil(int par1, ItemFossil cleanedFossil) {
		super(par1, "fossils/covered" + cleanedFossil.modelName.toLowerCase(), "Covered Fossil");
		this.cleanedFossil = cleanedFossil;
	}

}