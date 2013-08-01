package maemesoft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.IArmorTextureProvider;
import maemesoft.config.MaemeItems;
import maemesoft.migration.Maeme;

public class ItemMaemeBoots extends ItemArmor implements IArmorTextureProvider{

    public ItemMaemeBoots(int i, int index, EnumArmorMaterial enumArmorMaterial, int k, int l, String textureName, String itemName)
    {
        super(i, enumArmorMaterial, k, l);
        this.setMaxDamage(400);
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.textureName = textureName;
        setUnlocalizedName(itemName);
    }
    public static int bootLastX = 0;
    public static int bootLastZ = 0;
    
    String textureName;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(textureName);
	}

	public String getArmorTextureFile(ItemStack itemstack) {
		if(itemstack.getItem() == MaemeItems.newRunningShoes)
		{
					return"/maemesoft/armor/running_1.png";
				}else{
					return "/maemesoft/armor/oldrunning_1.png";
		}

		}
	}