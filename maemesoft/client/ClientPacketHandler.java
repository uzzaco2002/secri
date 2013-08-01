package maemesoft.client;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import maemesoft.Maeme;
import maemesoft.client.gui.ClientTradingManager;
import maemesoft.common.EnumPackets;
import maemesoft.common.MaemeDataPacket;
import maemesoft.common.MaemeLevelUpPacket;
import maemesoft.common.MaemeStatsPacket;
import maemesoft.common.MaemeTransformPacket;
import maemesoft.db.DBMoves;
import maemesoft.enums.EnumGui;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class ClientPacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		DataInputStream dataStream = new DataInputStream(new ByteArrayInputStream(packet.data));

		try {
			int packetID = dataStream.readInt();
			if (packetID == EnumPackets.AddToStorage.getIndex()) {
				ServerStorageDisplay.add(dataStream);
			} else if (packetID == EnumPackets.RemoveFromStorage.getIndex()) {
				ServerStorageDisplay.remove(dataStream.readInt());
			} else if (packetID == EnumPackets.UpdateStorage.getIndex()) {
				ServerStorageDisplay.update(dataStream);
			} else if (packetID == EnumPackets.AddToTempStore.getIndex()) {
				MaemeServerStore.addToList(dataStream);
			} else if (packetID == EnumPackets.RemoveFromTempStore.getIndex()) {
				MaemeServerStore.removeFromList(dataStream.readInt(), dataStream.readInt());
			} else if (packetID == EnumPackets.ClearTempStore.getIndex()) {
				MaemeServerStore.clearList();
			} else if (packetID == EnumPackets.SetMousePokemon.getIndex()) {
				MaemeServerStore.setMousePokemon(dataStream);
			} else if (packetID == EnumPackets.ClearMousePokemon.getIndex()) {
				MaemeServerStore.clearMousePokemon();
			} else if (packetID == EnumPackets.SetOpponent.getIndex()) {
				MaemeDataPacket p = new MaemeDataPacket();
				try {
					p.readPacketData(dataStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (packetID == EnumPackets.ChooseMoveToReplace.getIndex()) {
				int pokemonID = dataStream.readInt();
				int newAttackId = dataStream.readInt();
				int level = dataStream.readInt();
			} else if (packetID == EnumPackets.LevelUp.getIndex()) {
				MaemeLevelUpPacket p = new MaemeLevelUpPacket();
				p.readPacketData(dataStream);
			} else if (packetID == EnumPackets.RegisterTrader.getIndex()) {
				String username = Packet.readString(dataStream, 64);
				ClientTradingManager.findTradePartner(username);
			} else if (packetID == EnumPackets.SetTradeTarget.getIndex()) {
				MaemeDataPacket p = new MaemeDataPacket();
				try {
					p.readPacketData(dataStream);
					ClientTradingManager.tradeTarget = p;
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (packetID == EnumPackets.SetTradeTargetStats.getIndex()) {
				MaemeStatsPacket p = new MaemeStatsPacket();
				try {
					p.readPacketData(dataStream);
					ClientTradingManager.tradeTargetStats = p;
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (packetID == EnumPackets.SetSelectedStats.getIndex()) {
				MaemeStatsPacket p = new MaemeStatsPacket();
				try {
					p.readPacketData(dataStream);
					ClientTradingManager.selectedStats = p;
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (packetID == EnumPackets.SetTradingReadyClient.getIndex()) {
				boolean ready = dataStream.readInt() == 1;
				ClientTradingManager.player2Ready = ready;
			} else if (packetID == EnumPackets.Transform.getIndex()) {
				MaemeTransformPacket p = new MaemeTransformPacket();
				try {
					p.readPacketData(dataStream);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}