package maemesoft.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityDaylightDetector;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;
import maemesoft.CommonProxy;
import maemesoft.blocks.TileEntityAnvil;
import maemesoft.blocks.TileEntityEvolutionRock;
import maemesoft.blocks.TileEntityFossilCleaner;
import maemesoft.blocks.TileEntityFossilMachine;
import maemesoft.blocks.TileEntityHealer;
import maemesoft.blocks.TileEntityPC;
import maemesoft.blocks.TileEntityTradeMachine;
import maemesoft.client.KeyBindings.MinimizeMaximizeOverlayKey;
import maemesoft.client.KeyBindings.MovementHandler;
import maemesoft.client.KeyBindings.PreviousPokemonKey;
import maemesoft.client.KeyBindings.SendPokemonKey;
import maemesoft.client.gui.*;
import maemesoft.client.gui.inventoryExtended.InventoryDetectionTickHandler;
import maemesoft.client.gui.pc.GuiPC;
import maemesoft.client.gui.pokechecker.*;
import maemesoft.client.KeyBindings.*;
import maemesoft.client.models.fossils.ModelFossil;
import maemesoft.client.models.objHandling.Object3D;
import maemesoft.client.render.*;
import maemesoft.client.render.tileEntities.*;
import maemesoft.config.MaemeConfig;
import maemesoft.entities.npcs.EntityDoctor;
import maemesoft.entities.npcs.EntityTrainer;
import maemesoft.entities.npcs.NPCType;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall;
import maemesoft.enums.EnumGui;
import maemesoft.enums.EnumPokeballs;
import maemesoft.sounds.Sounds;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityPokeBall.class, new RenderPokeball());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHealer.class, new RenderTileEntityHealer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPC.class, new RenderTileEntityPC());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, new RenderTileEntityAnvil());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilMachine.class, new RenderTileFossilMachine());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFossilCleaner.class, new RenderTileFossilCleaner());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTradeMachine.class, new RenderTileEntityTradingMachine());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEvolutionRock.class, new RenderTileEntityEvolutionRock());

		addPokemonRenderers();
		MinecraftForge.EVENT_BUS.register(new GuiMaemeOverlay());
	}

	@Override
	public World GetClientWorld() {
		return Minecraft.getMinecraft().theWorld;
	}

	@Override
	public void registerKeyBindings() {
		MinecraftForge.EVENT_BUS.register(this);

		KeyBindingRegistry.registerKeyBinding(new SendPokemonKey());
		KeyBindingRegistry.registerKeyBinding(new NextPokemonKey());
		KeyBindingRegistry.registerKeyBinding(new PreviousPokemonKey());
		KeyBindingRegistry.registerKeyBinding(new MinimizeMaximizeOverlayKey());
		TickRegistry.registerTickHandler(new MovementHandler(), Side.CLIENT);
	}

	private void addPokemonRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTrainer.class, new RenderTrainer(0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityMaeme.class, new RenderMaeme(0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityDoctor.class, new RenderDoctor(0.5f));
	}

	public static ArrayList<String> modelPaths = new ArrayList<String>();
	static {
		modelPaths.add("maemesoft.client.models.maeme");
	}

	public ModelBase loadModel(String name) {
		ModelBase model = null;
		for (String path : modelPaths) {
			try {
				Class<?> var3 = (Class<?>) Class.forName(path + ".Model" + name);
				try {
					if (var3 != null) {
						model = (ModelBase) var3.getConstructor(new Class[] {}).newInstance(new Object[] {});
						break;
					}
				} catch (Exception e) {
					if (MaemeConfig.printErrors) {
						System.out.println("Failed to construct model for " + name);
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				if (MaemeConfig.printErrors) {
					e.printStackTrace();
				}
			}
		}

		if (model == null)
			if (MaemeConfig.printErrors)
				System.out.println("Can't find model for " + name);
		return model;
	}

	@Override
	public ModelFossil loadFossilModel(String name) {
		ModelFossil model = null;
		try {
			Class<?> var3 = (Class<?>) Class.forName("maemesoft.client.models.fossils.Model" + name);
			if (var3 != null) {
				model = (ModelFossil) var3.getConstructor(new Class[] {}).newInstance(new Object[] {});
			}

		} catch (Exception e) {
			if (MaemeConfig.printErrors)
				System.out.println("Can't find Model for " + name);
		}
		if (model == null)
			if (MaemeConfig.printErrors)
				System.out.println("Can't find Model for " + name);
		return model;
	}

	@Override
	public ModelBase getNPCModel(NPCType type, String name) {
		ModelBase model = null;
		try {
			Class<?> var3 = (Class<?>) Class.forName("maemesoft.client.models." + type.textureDirectory + ".Model" + name);
			if (var3 != null) {
				model = (ModelBase) var3.getConstructor(new Class[] {}).newInstance(new Object[] {});
			}

		} catch (Exception e) {
			if (MaemeConfig.printErrors) {
				System.out.println("Error in Model for " + name);
				System.out.println(e.getMessage());
			}
			return null;
		}
		if (model == null)
			if (MaemeConfig.printErrors)
				System.out.println("Can't find Model for " + name);
		return model;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == EnumGui.ChooseStarter.getIndex())
			return new GuiChooseStarter();
		else if (ID == EnumGui.PC.getIndex())
			return new GuiPC();
		else if (ID == EnumGui.Healer.getIndex())
			return new GuiHealer();
		else if (ID == EnumGui.PokeChecker.getIndex())
			return new GuiScreenPokeChecker(ServerStorageDisplay.get(x), false);
		else if (ID == EnumGui.PokeCheckerStats.getIndex())
			return new GuiScreenPokeCheckerStats(ServerStorageDisplay.get(x), false);
		else if (ID == EnumGui.PokeCheckerMoves.getIndex())
			return new GuiScreenPokeCheckerMoves(ServerStorageDisplay.get(x), false);
		else if (ID == EnumGui.Trading.getIndex())
			return new GuiTrading(x);
		else if (ID == EnumGui.Doctor.getIndex())
			return new GuiDoctor();


		return null;
	}

	public static File getMinecraftDir() {
		return Minecraft.getMinecraftDir();
	}

	@ForgeSubscribe
	public void onWorldLoad(WorldEvent.Load event) {
		ServerStorageDisplay.clear();
		MaemeServerStore.clearList();
	}

	@Override
	public void registerSounds() {
		Sounds.installSounds();
	}

	@Override
	public void registerTickHandlers() {
		TickRegistry.registerTickHandler(new InventoryDetectionTickHandler(), Side.CLIENT);
	}

	public Object[] models = new Object[650];

	@Override
	public Object[] getModels() {
		return models;
	}
}