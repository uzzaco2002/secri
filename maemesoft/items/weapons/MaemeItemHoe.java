package maemesoft.items.weapons;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;

public class MaemeItemHoe extends ItemHoe {

	public MaemeItemHoe(int par1, EnumToolMaterial par2EnumToolMaterial, String textureName) {
		super(par1, par2EnumToolMaterial);
		this.textureName = textureName;
		setUnlocalizedName("Aluminium Hoe");
	}

	String textureName;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(textureName);
	}
}