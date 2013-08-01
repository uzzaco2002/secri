package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import maemesoft.blocks.TileEntityTradeMachine;
import maemesoft.blocks.TradingRegistry;
import maemesoft.common.EnumPackets;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerStorage;

import cpw.mods.fml.common.network.Player;

public class TradingPacket extends PacketHandlerBase {

	public TradingPacket() {
		packetsHandled.add(EnumPackets.SelectPokemonForTrade);
		packetsHandled.add(EnumPackets.DeRegisterTrader);
		packetsHandled.add(EnumPackets.SetTradingReady);
		packetsHandled.add(EnumPackets.Trade);
	}

	@Override
	public void handlePacket(int index, Player player, DataInputStream dataStream) throws IOException {
		if (index == EnumPackets.SelectPokemonForTrade.getIndex()) {
			int pos = dataStream.readInt();

			TileEntityTradeMachine te = TradingRegistry.getTileEntity((EntityPlayer) player);
			if (te.player1 == (EntityPlayer)player) {
				te.setPos1(pos);
			} else if (te.player2 == (EntityPlayer)player) {
				te.setPos2(pos);
			}
		} else if (index == EnumPackets.DeRegisterTrader.getIndex()) {
			TileEntityTradeMachine te = TradingRegistry.getTileEntity((EntityPlayer) player);
			if (te != null)
				te.removePlayer(player);
		} else if (index == EnumPackets.SetTradingReady.getIndex()) {
			boolean ready = dataStream.readInt() == 1;
			TileEntityTradeMachine te = TradingRegistry.getTileEntity((EntityPlayer) player);
			te.ready((EntityPlayer) player, ready);

		} else if (index == EnumPackets.Trade.getIndex()) {
			TileEntityTradeMachine te = TradingRegistry.getTileEntity((EntityPlayer) player);
			te.trade();
		}
	}
}