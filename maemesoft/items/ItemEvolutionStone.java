package maemesoft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import maemesoft.config.MaemeConfig;
import maemesoft.db.DBStats;
import maemesoft.db.EvolutionInfo;
import maemesoft.db.EvolutionInfo.InfoMode;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.enums.EnumEvolutionStone;

public class ItemEvolutionStone extends MaemeItem {

	private EnumEvolutionStone stoneType;

	public ItemEvolutionStone(int id, EnumEvolutionStone stoneType, String itemName) {
		super(id, "evolutionstones/" + stoneType.toString().toLowerCase(), itemName);
		this.stoneType = stoneType;
		setCreativeTab(CreativeTabs.tabMisc);
	}

	public EnumEvolutionStone getType() {
		return stoneType;
	}

	public boolean useOnEntity(ItemStack itemstack, EntityMaeme pixelmon, EntityPlayer player) {
		ItemEvolutionStone i = (ItemEvolutionStone) itemstack.getItem();
		for (EvolutionInfo e : DBStats.getEvolveList(pixelmon.getName())) {
			if (e.mode == InfoMode.stone) {
				if (e.evolutionStone == i.getType()) {
					String evolveTo = e.pokemonName;
					if (evolveTo == null) {
						if (MaemeConfig.printErrors)
							System.out.println(e.pokemonName + " isn't coded yet");
						return false;
					}
					pixelmon.evolve(evolveTo);
					itemstack.stackSize--;
					return true;
				}
			}
		}
		return false;
	}

}