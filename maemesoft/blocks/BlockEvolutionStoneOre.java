package maemesoft.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import maemesoft.config.MaemeBlocks;
import maemesoft.config.MaemeItems;
import maemesoft.enums.EnumEvolutionStone;

public class BlockEvolutionStoneOre extends Block {

	private EnumEvolutionStone type = null;
	private Icon icon;

	public BlockEvolutionStoneOre(int id, EnumEvolutionStone type, float hardness, String itemName) {
		super(id, Material.rock);
		this.type = type;
		setHardness(hardness);
		setStepSound(Block.soundStoneFootstep);
		if (id == MaemeBlocks.waterStoneOreId)
			setLightValue(0.5f);
		setUnlocalizedName(itemName);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		icon = par1IconRegister.registerIcon("pixelmon:" + type.toString().toLowerCase());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int par2, int par3, int par4, int par5) {
		return icon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return icon;
	}

	public boolean isOpaqueCube() {
		return !(type == EnumEvolutionStone.Leafstone);
	}

	@Override
	public int getRenderType() {
		return 0;
	}

	@SuppressWarnings("incomplete-switch")
	public int idDropped(int i, Random rand, int j) {
		int result = 0;
		switch (type) {
		case Thunderstone:
			result = MaemeItems.thunderStoneShard.itemID;
			break;
		case Leafstone:
			result = MaemeItems.leafStoneShard.itemID;
			break;
		case Waterstone:
			result = MaemeItems.waterStoneShard.itemID;
			break;
		case Firestone:
			result = MaemeItems.fireStoneShard.itemID;
			break;
		}

		return result;
	}

}