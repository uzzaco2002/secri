package maemesoft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import maemesoft.config.MaemeItems;

public class ItemMaemeArmor extends ItemArmor implements IArmorTextureProvider{

    public ItemMaemeArmor(int i, int index, EnumArmorMaterial enumArmorMaterial, int k, int l, String textureName, String itemName)
    {
        super(i, enumArmorMaterial, k, l);
        this.setMaxDamage(enumArmorMaterial.getDurability(l));
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.textureName = textureName;
        setUnlocalizedName(itemName);
    }

	String textureName;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(textureName);
	}

	public String getArmorTextureFile(ItemStack itemstack) {
		if(itemstack.getItem() == MaemeItems.leggingsAluminium)
		return "/maemesoft/armor/aluminum_2.png";

				else{
					return "/maemesoft/armor/aluminum_1.png";
		}

		}
	}