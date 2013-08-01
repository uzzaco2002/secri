package maemesoft.items;

import net.minecraft.entity.player.EntityPlayerMP;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.enums.EnumPotions;
import maemesoft.storage.MaemeStorage;

public class ItemPotion extends MaemeItem {
	public EnumPotions type;

	public ItemPotion(int par1, EnumPotions type, String itemName) {
		super(par1, "healingitems/" + type.getTexture(), itemName);
		SetUsableInBattle(true);
		this.type = type;
		setMaxStackSize(16);
	}

	private int healAmount(EntityMaeme userPokemon) {
		if (this.type.getHealAmount() != 0) {
			return this.type.getHealAmount();
		} else if (this.type.getHealPercent() != 0) {
			return (int) Math.ceil(((double)userPokemon.stats.HP) * this.type.getHealPercent() / 100);
		} else {
			return 0;
		}
	}

	public void healPokemon(EntityMaeme pxm) {
		int newHP = pxm.getHealth() + healAmount(pxm);
		pxm.setEntityHealth(newHP);
		if (pxm.getOwner() != null)
			pxm.updateNBT();
	}

	@Override
	public void useFromBag(EntityMaeme userPokemon, EntityMaeme targetPokemon) {
		healPokemon(userPokemon);
	}

}