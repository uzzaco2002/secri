package maemesoft.items;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import maemesoft.config.MaemeConfig;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall;
import maemesoft.enums.EnumPokeballs;

public class ItemPokeBall extends MaemeItem {
	public EnumPokeballs type;

	public static HashMap<EntityPlayer, Integer> playerTimers;

	public ItemPokeBall(int i, EnumPokeballs type) {
		super(i, "pokeballs/" + type.toString().toLowerCase(), type.toString().substring(0, type.toString().indexOf("Ball")) + " Ball");
		SetUsableInBattle(true);
		maxStackSize = 64;
		setMaxDamage(0xf4240);
		this.type = type;
		playerTimers = new HashMap<EntityPlayer, Integer>();
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if (MaemeConfig.allowCapturingOutsideBattle) {
			if (!entityplayer.capabilities.isCreativeMode) {
				--itemstack.stackSize;
			}

			world.playSoundAtEntity(entityplayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!world.isRemote) {
				world.spawnEntityInWorld(new EntityPokeBall(world, entityplayer, type, !entityplayer.capabilities.isCreativeMode));
			}
		}
		return itemstack;
	}
}