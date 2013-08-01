package maemesoft.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import maemesoft.Maeme;
import maemesoft.db.DBHelper;
import maemesoft.db.Move;
import maemesoft.enums.EnumType;
import maemesoft.items.ItemTM;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MaemeItemsTMs {
	public static ArrayList<Item> TMs = new ArrayList<Item>();

	public static void load(Configuration cfg) {
		System.out.println("PIXELMON: Loading TM/HMs");
		int startId = cfg.get("IDs", "TM Index Start", 11000).getInt();
		try {
			Connection conn = DBHelper.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from Moves where TMIndex!=-1 ORDER BY TMIndex");
			while (rs.next()) {
				try {
					ItemTM item = new ItemTM(startId++, rs.getString("Name"), rs.getInt("TMIndex"), EnumType.parseType(rs.getString("Type")), false);
					Maeme.proxy.registerBossDropItem(item);
					TMs.add(item);
				} catch (Exception e) {
					System.out.println("Problem loading TMs");
				}
			}

			conn.close();
		} catch (Exception e) {

		}
	}

	public static void addNames() {
		for (Item item : TMs) {
			LanguageRegistry.addName(item, ((ItemTM) item).getItemName());
		}
	}
}