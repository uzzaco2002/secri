package maemesoft.config;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import maemesoft.blocks.BlockAnvil;
import maemesoft.blocks.BlockBauxiteOre;
import maemesoft.blocks.BlockEvolutionRock;
import maemesoft.blocks.BlockEvolutionStoneOre;
import maemesoft.blocks.BlockFossil;
import maemesoft.blocks.BlockFossilCleaner;
import maemesoft.blocks.BlockFossilMachine;
import maemesoft.blocks.BlockHealer;
import maemesoft.blocks.BlockPC;
import maemesoft.blocks.BlockTradeMachine;
import maemesoft.blocks.TileEntityAnvil;
import maemesoft.blocks.TileEntityEvolutionRock;
import maemesoft.blocks.TileEntityFossilCleaner;
import maemesoft.blocks.TileEntityFossilMachine;
import maemesoft.blocks.TileEntityHealer;
import maemesoft.blocks.TileEntityPC;
import maemesoft.blocks.TileEntityTradeMachine;
import maemesoft.enums.EnumEvolutionRock;
import maemesoft.enums.EnumEvolutionStone;
import maemesoft.items.ItemBlock;
import maemesoft.items.MaemeItemBlock;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MaemeBlocks {
	public static int pokemonHealerIdleId;
	public static int pokemonHealerActiveId;
	public static int thunderStoneOreId;
	public static int leafStoneOreId;
	public static int waterStoneOreId;
	public static int fireStoneOreId;
	public static int pcId;
	public static int anvilId;
	public static int fossilMachineId;
	public static int fossilId;
	public static int bauxiteId;
	public static int tradeMachineId;
	public static int fossilCleanerId;
	public static int mossyRockId;
	public static int icyRockId;

	@Mod.Block(name = "Thunderstone Ore")
	public static Block thunderStoneOre;
	@Mod.Block(name = "LeafStone Ore")
	public static Block leafStoneOre;
	@Mod.Block(name = "WaterStone Ore")
	public static Block waterStoneOre;
	@Mod.Block(name = "FireStone Ore", itemTypeClass = ItemBlock.class)
	public static Block fireStoneOre;
	@Mod.Block(name = "Bauxite Ore")
	public static Block bauxite;
	@Mod.Block(name = "Healer", itemTypeClass = ItemBlock.class)
	public static Block healer;
	@Mod.Block(name = "Pokemon PC", itemTypeClass = ItemBlock.class)
	public static Block pc;
	@Mod.Block(name = "Anvil", itemTypeClass = ItemBlock.class)
	public static Block anvil;
	@Mod.Block(name = "Fossil Machine", itemTypeClass = ItemBlock.class)
	public static Block fossilMachine;
	@Mod.Block(name = "Fossil")
	public static Block fossil;
	@Mod.Block(name = "Trade Machine", itemTypeClass = ItemBlock.class)
	public static Block tradeMachine;
	@Mod.Block(name = "Fossil Cleaner", itemTypeClass = ItemBlock.class)
	public static Block fossilCleaner;
	@Mod.Block(name = "Mossy Rock", itemTypeClass = ItemBlock.class)
	public static Block mossyRock;
	@Mod.Block(name = "Icy Rock", itemTypeClass = ItemBlock.class)
	public static Block icyRock;


	public static void load(Configuration configuration) {
		pokemonHealerActiveId = configuration.getBlock("PokemonHealerActive", 300).getInt(300);
		pokemonHealerIdleId = configuration.getBlock("PokemonHealerIdle", 301).getInt(301);
		thunderStoneOreId = configuration.getBlock("ThunderStoneOre", 221).getInt(221);
		leafStoneOreId = configuration.getBlock("LeafStoneOre", 222).getInt(222);
		waterStoneOreId = configuration.getBlock("WaterStoneOre", 223).getInt(223);
		fireStoneOreId = configuration.getBlock("FireStoneOre", 224).getInt(224);
		bauxiteId = configuration.getBlock("Bauxite Ore", 220).getInt(220);
		pcId = configuration.getBlock("PC", 307).getInt(307);
		anvilId = configuration.getBlock("Anvil", 308).getInt(308);
		fossilMachineId = configuration.getBlock("Fossil Machine", 309).getInt(309);
		fossilId = configuration.getBlock("Fossil", 225).getInt(225);
		tradeMachineId = configuration.getBlock("Trade Machine", 311).getInt(311);
		fossilCleanerId = configuration.getBlock("Fossil Cleaner", 312).getInt(312);

		mossyRockId = configuration.getBlock("Mossy Rock", 318).getInt(318);
		icyRockId = configuration.getBlock("Icy Rock", 319).getInt(319);

		healer = new BlockHealer(pokemonHealerIdleId);
		thunderStoneOre = new BlockEvolutionStoneOre(thunderStoneOreId, EnumEvolutionStone.Thunderstone, 3.0f, "Thunder Stone Ore");
		leafStoneOre = new BlockEvolutionStoneOre(leafStoneOreId, EnumEvolutionStone.Leafstone, 3.0f, "Leaf Stone Ore");
		waterStoneOre = new BlockEvolutionStoneOre(waterStoneOreId, EnumEvolutionStone.Waterstone, 3.0f, "Water Stone Ore");
		fireStoneOre = new BlockEvolutionStoneOre(fireStoneOreId, EnumEvolutionStone.Firestone, 3.0f, "Fire Stone Ore");
		pc = new BlockPC(pcId, 0);
		anvil = new BlockAnvil(anvilId);
		fossilMachine = new BlockFossilMachine(fossilMachineId);
		fossil = new BlockFossil(fossilId).setHardness(5f);
		tradeMachine = new BlockTradeMachine(tradeMachineId);
		fossilCleaner = new BlockFossilCleaner(fossilCleanerId);
	}

	public static void registerBlocks() {
		GameRegistry.registerBlock(healer, "PokeHealer");
		GameRegistry.registerBlock(thunderStoneOre, MaemeItemBlock.class, "Thunderstone Ore");
		GameRegistry.registerBlock(leafStoneOre, "Leafstone Ore");
		GameRegistry.registerBlock(waterStoneOre, "Waterstone Ore");
		GameRegistry.registerBlock(fireStoneOre, "Firestone Ore");
		GameRegistry.registerBlock(pc, "PC");
		GameRegistry.registerBlock(anvil, "Pixelmon Anvil");
		GameRegistry.registerBlock(fossilMachine, "Fossil Machine");
		GameRegistry.registerBlock(fossil, "Fossil");
		GameRegistry.registerBlock(tradeMachine, "Trading Machine");
		GameRegistry.registerBlock(fossilCleaner, "Fossil Cleaner");

		MinecraftForge.setBlockHarvestLevel(bauxite, "pickaxe", 2);

		GameRegistry.registerTileEntity(TileEntityPC.class, "Pokemon PC");
		GameRegistry.registerTileEntity(TileEntityHealer.class, "Healer");
		GameRegistry.registerTileEntity(TileEntityAnvil.class, "Anvil");
		GameRegistry.registerTileEntity(TileEntityFossilMachine.class, "Fossil Machine");
		GameRegistry.registerTileEntity(TileEntityTradeMachine.class, "Trade Machine");
		GameRegistry.registerTileEntity(TileEntityFossilCleaner.class, "Fossil Cleaner");
		GameRegistry.registerTileEntity(TileEntityEvolutionRock.class, "Evolution Rock");

	}

	public static void addNames() {
		try {
			for (Field field : MaemeBlocks.class.getFields()) {
				if (field.isAnnotationPresent(Mod.Block.class)) {
					Block block = (Block) field.get(null);
					LanguageRegistry.addName(block, field.getAnnotation(Mod.Block.class).name());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}