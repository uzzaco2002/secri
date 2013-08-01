package maemesoft;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import maemesoft.api.MaemeApi;
import maemesoft.client.models.fossils.ModelFossil;
import maemesoft.entities.npcs.NPCType;
import maemesoft.entities.maeme.helpers.DropItemHelper;
import maemesoft.entities.maeme.interactions.InteractionEther;
import maemesoft.entities.maeme.interactions.InteractionEvolutionStone;
import maemesoft.entities.maeme.interactions.InteractionHeldItem;
import maemesoft.entities.maeme.interactions.InteractionPokedex;
import maemesoft.entities.maeme.interactions.InteractionPotion;
import maemesoft.entities.maeme.interactions.InteractionRareCandy;
import maemesoft.entities.maeme.interactions.InteractionStatusAilment;
import maemesoft.entities.maeme.interactions.InteractionTM;
import maemesoft.gui.GuiHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {
	public void registerRenderers() {
	}

	public World GetClientWorld() {
		return null;
	}

	public GuiHandler guiHandler = new GuiHandler();

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return guiHandler.getServerGuiElement(ID, player, world, x, y, z);
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	public int addArmor(String name){
		return RenderingRegistry.addNewArmourRendererPrefix(name);
	}

	public void registerPacketHandlers() {
	}

	public void registerKeyBindings() {
	}

	public ModelBase loadModel(String name) {
		return null;
	}

	public ModelBase getNPCModel(NPCType type, String model) {
		return null;
	}

	public void registerSounds() {
	}

	public void registerTickHandlers() {
	}

	public void loadEvents() {
	}

	public Object[] getModels() {
		return null;
	}

	public ModelFossil loadFossilModel(String modelName) {
		return null;
	}

	public void registerBossDropItem(Item item){
		DropItemHelper.bossDropItems.add(item);
	}

	public void registerInteractions(){
		MaemeApi.addInteraction(new InteractionPokedex());
		MaemeApi.addInteraction(new InteractionTM());
		MaemeApi.addInteraction(new InteractionEther());
		MaemeApi.addInteraction(new InteractionEvolutionStone());
		MaemeApi.addInteraction(new InteractionHeldItem());
		MaemeApi.addInteraction(new InteractionPotion());
		MaemeApi.addInteraction(new InteractionRareCandy());
		MaemeApi.addInteraction(new InteractionStatusAilment());
	}
}