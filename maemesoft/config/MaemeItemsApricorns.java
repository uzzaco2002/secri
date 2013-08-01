package maemesoft.config;

import java.lang.reflect.Field;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import maemesoft.enums.EnumApricorns;
import maemesoft.items.ItemApricorn;
import maemesoft.items.ItemApricornCooked;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MaemeItemsApricorns {
	public static int apricornBlackID;
	public static int apricornWhiteID;
	public static int apricornPinkID;
	public static int apricornGreenID;
	public static int apricornBlueID;
	public static int apricornYellowID;
	public static int apricornRedID;
	public static int apricornBlackCookedID;
	public static int apricornWhiteCookedID;
	public static int apricornPinkCookedID;
	public static int apricornGreenCookedID;
	public static int apricornBlueCookedID;
	public static int apricornYellowCookedID;
	public static int apricornRedCookedID;

	@Mod.Item(name = "Black Apricorn", typeClass = "pixelmon.items.ItemApricorn")
	public static Item apricornBlack;
	@Mod.Item(name = "White Apricorn", typeClass = "pixelmon.items.ItemApricorn")
	public static Item apricornWhite;
	@Mod.Item(name = "Pink Apricorn", typeClass = "pixelmon.items.ItemApricorn")
	public static Item apricornPink;
	@Mod.Item(name = "Green Apricorn", typeClass = "pixelmon.items.ItemApricorn")
	public static Item apricornGreen;
	@Mod.Item(name = "Blue Apricorn", typeClass = "pixelmon.items.ItemApricorn")
	public static Item apricornBlue;
	@Mod.Item(name = "Yellow Apricorn", typeClass = "pixelmon.items.ItemApricorn")
	public static Item apricornYellow;
	@Mod.Item(name = "Red Apricorn", typeClass = "pixelmon.items.ItemApricorn")
	public static Item apricornRed;
	@Mod.Item(name = "Cooked Black Apricorn", typeClass = "pixelmon.items.ItemApricornCooked")
	public static Item apricornBlackCooked;
	@Mod.Item(name = "Cooked White Apricorn", typeClass = "pixelmon.items.ItemApricornCooked")
	public static Item apricornWhiteCooked;
	@Mod.Item(name = "Cooked Pink Apricorn", typeClass = "pixelmon.items.ItemApricornCooked")
	public static Item apricornPinkCooked;
	@Mod.Item(name = "Cooked Green Apricorn", typeClass = "pixelmon.items.ItemApricornCooked")
	public static Item apricornGreenCooked;
	@Mod.Item(name = "Cooked Blue Apricorn", typeClass = "pixelmon.items.ItemApricornCooked")
	public static Item apricornBlueCooked;
	@Mod.Item(name = "Cooked Yellow Apricorn", typeClass = "pixelmon.items.ItemApricornCooked")
	public static Item apricornYellowCooked;
	@Mod.Item(name = "Cooked Red Apricorn", typeClass = "pixelmon.items.ItemApricornCooked")
	public static Item apricornRedCooked;

	public static void load(Configuration cfg) {
		apricornBlackID = cfg.get("itemApricorn", "Black Apricorn", 10100).getInt();
		apricornWhiteID = cfg.get("itemApricorn", "White Apricorn", 10101).getInt();
		apricornPinkID = cfg.get("itemApricorn", "Pink Apricorn", 10102).getInt();
		apricornGreenID = cfg.get("itemApricorn", "Green Apricorn", 10103).getInt();
		apricornBlueID = cfg.get("itemApricorn", "Blue Apricorn", 10104).getInt();
		apricornYellowID = cfg.get("itemApricorn", "Yellow Apricorn", 10105).getInt();
		apricornRedID = cfg.get("itemApricorn", "Red Apricorn", 10106).getInt();
		apricornBlackCookedID = cfg.get("itemApricorn", "Cooked Black Apricorn", 10112).getInt();
		apricornWhiteCookedID = cfg.get("itemApricorn", "Cooked White Apricorn", 10113).getInt();
		apricornPinkCookedID = cfg.get("itemApricorn", "Cooked Pink Apricorn", 10114).getInt();
		apricornGreenCookedID = cfg.get("itemApricorn", "Cooked Green Apricorn", 10115).getInt();
		apricornBlueCookedID = cfg.get("itemApricorn", "Cooked Blue Apricorn", 10116).getInt();
		apricornYellowCookedID = cfg.get("itemApricorn", "Cooked Yellow Apricorn", 10117).getInt();
		apricornRedCookedID = cfg.get("itemApricorn", "Cooked Red Apricorn", 10118).getInt();

		apricornBlack = new ItemApricorn(apricornBlackID, EnumApricorns.Black);
		apricornWhite = new ItemApricorn(apricornWhiteID, EnumApricorns.White);
		apricornPink = new ItemApricorn(apricornPinkID, EnumApricorns.Pink);
		apricornGreen = new ItemApricorn(apricornGreenID, EnumApricorns.Green);
		apricornBlue = new ItemApricorn(apricornBlueID, EnumApricorns.Blue);
		apricornYellow = new ItemApricorn(apricornYellowID, EnumApricorns.Yellow);
		apricornRed = new ItemApricorn(apricornRedID, EnumApricorns.Red);
		apricornBlackCooked = new ItemApricornCooked(apricornBlackCookedID, EnumApricorns.Black);
		apricornWhiteCooked = new ItemApricornCooked(apricornWhiteCookedID, EnumApricorns.White);
		apricornPinkCooked = new ItemApricornCooked(apricornPinkCookedID, EnumApricorns.Pink);
		apricornGreenCooked = new ItemApricornCooked(apricornGreenCookedID, EnumApricorns.Green);
		apricornBlueCooked = new ItemApricornCooked(apricornBlueCookedID, EnumApricorns.Blue);
		apricornYellowCooked = new ItemApricornCooked(apricornYellowCookedID, EnumApricorns.Yellow);
		apricornRedCooked = new ItemApricornCooked(apricornRedCookedID, EnumApricorns.Red);
	}

	public static void addNames() {
		MaemeItemsPokeballs.addNames();
		try {
			for (Field field : MaemeItemsApricorns.class.getFields()) {
				if (field.isAnnotationPresent(Mod.Item.class)) {
					Item item = (Item) field.get(null);
					LanguageRegistry.addName(item, field.getAnnotation(Mod.Item.class).name());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Item getCookedApricorn(EnumApricorns type) {
		try {
			for (Field field : MaemeItemsApricorns.class.getFields()) {
				if (field.isAnnotationPresent(Mod.Item.class)) {
					Item item = (Item) field.get(null);
					if (item instanceof ItemApricornCooked)
						if (((ItemApricornCooked) item).apricorn == type)
							return item;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Item getApricorn(EnumApricorns type) {
		try {
			for (Field field : MaemeItemsApricorns.class.getFields()) {
				if (field.isAnnotationPresent(Mod.Item.class)) {
					Item item = (Item) field.get(null);
					if (item instanceof ItemApricorn)
						if (((ItemApricorn) item).apricorn == type)
							return item;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}