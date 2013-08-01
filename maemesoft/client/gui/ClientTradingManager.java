package maemesoft.client.gui;

import java.util.List;

import maemesoft.common.MaemeDataPacket;
import maemesoft.common.MaemeStatsPacket;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientTradingManager {
	public static EntityPlayer tradePartner;
	public static MaemeDataPacket tradeTarget;
	public static MaemeStatsPacket tradeTargetStats;
	public static MaemeStatsPacket selectedStats;
	public static boolean player1Ready = false;
	public static boolean player2Ready = false;

	public static void findTradePartner(String username) {
		tradePartner = null;
		List<EntityPlayer> playerList = Minecraft.getMinecraft().theWorld.playerEntities;

		for (EntityPlayer p : playerList) {
			if (p.username.equalsIgnoreCase(username))
				tradePartner = p;
		}
	}

	public static void reset() {
		tradePartner = null;
		tradeTarget = null;
		tradeTargetStats = null;
		selectedStats = null;
		player1Ready = false;
		player2Ready = false;
	}
}