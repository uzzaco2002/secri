package maemesoft;

//수정일 : 7/11 12:19 (현재 인벤토리 오류 수정중)

import java.io.File;

import net.minecraft.command.ServerCommandManager;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import maemesoft.client.ClientPacketHandler;
import maemesoft.common.ConnectionHandler;
import maemesoft.common.PacketHandler;
import maemesoft.config.MaemeConfig;
import maemesoft.db.DBHelper;
import maemesoft.entities.EntitySpawning;
import maemesoft.entities.pokeballs.EntityPokeBall;
import maemesoft.migration.Migration;
import maemesoft.spawning.MaemeSpawner;
import maemesoft.storage.MaemeStorage;
import maemesoft.worldGeneration.WorldGenEvolutionRock;
import maemesoft.worldGeneration.WorldGenFireStoneOre;
import maemesoft.worldGeneration.WorldGenFossils;
import maemesoft.worldGeneration.WorldGenLeafStoneOre;
import maemesoft.worldGeneration.WorldGenThunderStoneOre;
import maemesoft.worldGeneration.WorldGenWaterStoneOre;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "Pixelmon", name = "Pixelmon", version = "2.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, clientPacketHandlerSpec = @SidedPacketHandler(channels = { "Pixelmon" }, packetHandler = ClientPacketHandler.class), serverPacketHandlerSpec = @SidedPacketHandler(channels = { "Pixelmon" }, packetHandler = PacketHandler.class))
public class Maeme {

	public static EnumToolMaterial ALUMINIUM = EnumHelper.addToolMaterial("ALUMINUM", 2, 200, 6.5F, 2, 14);
	public static EnumArmorMaterial ALUMINIUMARMOR = EnumHelper.addArmorMaterial("ALUMINUM", 15, new int[] { 2, 6, 5, 2 }, 8);
	public static EnumArmorMaterial RUNNINGARMOR = EnumHelper.addArmorMaterial("RUNNING", 66, new int[] { 3, 8, 6, 3 }, 22);
	public static EnumArmorMaterial OLDRUNNINGARMOR = EnumHelper.addArmorMaterial("OLDRUNNING", 999999, new int[] { 2, 6, 5, 1 }, 13);

	@Instance("Pixelmon")
	public static Maeme instance;
	public static Migration migration;

	@SidedProxy(clientSide = "maemesoft.client.ClientProxy", serverSide = "maemesoft.CommonProxy")
	public static CommonProxy proxy;

	public static boolean freeze = false;

	public static File modDirectory;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		boolean checkForDatabaseUpdates = config.get("general", "Check for database updates", true).getBoolean(true);
		modDirectory = new File(event.getModConfigurationDirectory().getParent());
		if (!DBHelper.has(checkForDatabaseUpdates)) {
			throw new RuntimeException("Can not start Pixelmon without SQLite jar or database!!! Please reinstall!!");
		}
		if (Loader.isModLoaded("Pokemobs"))
			System.exit(1);

		event.getModMetadata().version = "2.2";

		MaemeConfig.loadConfig(config);
	}

	@Init
	public void load(FMLInitializationEvent event) {
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		proxy.registerKeyBindings();
		proxy.registerRenderers();
		proxy.registerInteractions();
		EntityRegistry.registerModEntity(EntityPokeBall.class, "Pokeball", MaemeConfig.idPokeball, Maeme.instance, 80, 1, true);

		NetworkRegistry.instance().registerConnectionHandler(new ConnectionHandler());

		GameRegistry.registerWorldGenerator(new WorldGenLeafStoneOre());
		GameRegistry.registerWorldGenerator(new WorldGenWaterStoneOre());
		GameRegistry.registerWorldGenerator(new WorldGenThunderStoneOre());
		GameRegistry.registerWorldGenerator(new WorldGenFireStoneOre());
		GameRegistry.registerWorldGenerator(new WorldGenFossils());
		GameRegistry.registerWorldGenerator(new WorldGenEvolutionRock());

		// MinecraftForge.EVENT_BUS.register(new MigrationLoader());
		MinecraftForge.EVENT_BUS.register(MaemeStorage.CardManager);
		MinecraftForge.EVENT_BUS.register(MaemeStorage.ComputerManager);
		MinecraftForge.EVENT_BUS.register(new EntitySpawning());

		TickRegistry.registerTickHandler(new TickHandler(), Side.CLIENT);
		TickRegistry.registerTickHandler(new SleepHandler(), Side.SERVER);
		TickRegistry.registerTickHandler(new TickHandler(), Side.SERVER);
		TickRegistry.registerTickHandler(new MaemeSpawner(), Side.SERVER);
		proxy.registerTickHandlers();
	}

	@PostInit
	public void modsLoaded(FMLPostInitializationEvent event) {
		MaemeConfig.removeSpawns();
		proxy.registerSounds();
	}

	@ServerStarting
	public void onServerStart(FMLServerStartingEvent event) {
		if (MinecraftServer.getServer().getCommandManager() instanceof ServerCommandManager) {
			((ServerCommandManager) MinecraftServer.getServer().getCommandManager()).registerCommand(new CommandSpawn());
			((ServerCommandManager) MinecraftServer.getServer().getCommandManager()).registerCommand(new CommandStruc());
			((ServerCommandManager) MinecraftServer.getServer().getCommandManager()).registerCommand(new CommandFreeze());
			((ServerCommandManager) MinecraftServer.getServer().getCommandManager()).registerCommand(new CommandHeal());
		}
	}

}