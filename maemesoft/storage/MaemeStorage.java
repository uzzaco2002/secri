package maemesoft.storage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class MaemeStorage {
	public static CardManager CardManager = new CardManager();
	public static ComputerManager ComputerManager = new ComputerManager();

	public static void onPlayerDC(EntityPlayer player) {
		if (player == null)
			return;
		CardManager.onPlayerDC(player);
		ComputerManager.onPlayerDC(player);
	}

	public static void playerLoggedIn(EntityPlayerMP player) {
		CardManager.playerLoggedIn(player);
		ComputerManager.playerLoggedIn(player);
	}
}