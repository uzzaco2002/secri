package maemesoft.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import maemesoft.Maeme;
import maemesoft.client.models.fossils.ModelFossil;

public class ItemFossil extends MaemeItem {

	public String pokemon = "";
	public ModelFossil model;
	public String modelName;

	public ItemFossil(int Id, String pokemon, String modelName) {
		super(Id, "fossils/" + modelName.toLowerCase(), modelName);
		this.pokemon = pokemon;
		this.modelName = modelName;
		setUnlocalizedName(modelName);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(pokemon);
	}

	public String getPokemon() {
		return this.pokemon;
	}

	public String getModelName() {
		return this.modelName;
	}

	public ModelFossil getModel() {
		if (model == null)
			return Maeme.proxy.loadFossilModel(modelName);
		return model;
	}
}