package maemesoft.common;

import java.lang.reflect.Field;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.TcpConnection;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import maemesoft.Maeme;
import maemesoft.enums.EnumGui;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerNotLoadedException;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class ConnectionHandler implements IConnectionHandler {

	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) {
		MaemeStorage.playerLoggedIn((EntityPlayerMP)player);
		try {
			MaemeStorage.CardManager.loadPlayer((EntityPlayerMP)player);
		} catch (PlayerNotLoadedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) {
		return null;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) {
	}

	// Need to update this if the field position of theNetHandler changes inside
	// of TcpConnection
	@Override
	public void connectionClosed(INetworkManager manager) {
		if (manager instanceof TcpConnection) {
			TcpConnection tcpConnection = (TcpConnection) manager;
			Field f = tcpConnection.getClass().getDeclaredFields()[13];
			f.setAccessible(true);
			NetHandler netHandler = null;
			try {
				netHandler = (NetHandler) f.get(tcpConnection);
				MaemeStorage.onPlayerDC(netHandler.getPlayer());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) {
		// TODO Auto-generated method stub

	}

}