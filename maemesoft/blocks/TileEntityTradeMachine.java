package maemesoft.blocks;

import java.util.ArrayList;

import cpw.mods.fml.common.network.Player;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import maemesoft.Maeme;
import maemesoft.common.EnumPackets;
import maemesoft.common.PacketCreator;
import maemesoft.common.MaemeDataPacket;
import maemesoft.common.MaemeLevelUpPacket;
import maemesoft.common.MaemeStatsPacket;
import maemesoft.common.packetHandlers.PC.PCData;
import maemesoft.db.DBStats;
import maemesoft.db.EvolutionInfo;
import maemesoft.db.EvolutionInfo.InfoMode;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.enums.EnumGui;
import maemesoft.enums.EnumPokemon;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerStorage;

public class TileEntityTradeMachine extends TileEntity {

	public int playerCount = 0;
	public EntityPlayer player1, player2;
	public boolean ready1, ready2;
	public int pos1, pos2;

	public int tradeIndex = -1;

	private boolean tradePushed = false;

	public TileEntityTradeMachine() {
		if (this.tradeIndex == -1)
			TradingRegistry.registerTrade(this);
	}

	public void registerPlayer(EntityPlayer player) {
		try {
			PlayerStorage s = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player);
			playerCount++;
			if (playerCount == 1)
				player1 = player;
			if (playerCount == 2)
				player2 = player;

			player.openGui(Maeme.instance, EnumGui.Trading.getIndex(), player.worldObj, tradeIndex, 0, 0);
			if (player == player2) {
				((EntityPlayerMP) player2).playerNetServerHandler.sendPacketToPlayer(PacketCreator.createStringPacket(EnumPackets.RegisterTrader,
						player1.username));
				((EntityPlayerMP) player1).playerNetServerHandler.sendPacketToPlayer(PacketCreator.createStringPacket(EnumPackets.RegisterTrader,
						player2.username));
				if (pos1 != -1) {
					NBTTagCompound n = s.getNBT(s.getIDFromPosition(pos1));
					((EntityPlayerMP) player2).playerNetServerHandler.sendPacketToPlayer(new MaemeDataPacket(n, EnumPackets.SetTradeTarget).getPacket());
					((EntityPlayerMP) player2).playerNetServerHandler.sendPacketToPlayer(new MaemeStatsPacket(n, EnumPackets.SetTradeTargetStats)
							.getPacket());
					((EntityPlayerMP) player1).playerNetServerHandler.sendPacketToPlayer(new MaemeStatsPacket(n, EnumPackets.SetSelectedStats).getPacket());
				}
			}
		} catch (Exception e) {
		}
	}

	public boolean ready(EntityPlayer player, boolean ready) {
		if (player1 != null)
			if (player.username == player1.username) {
				ready1 = ready;
				((EntityPlayerMP) player2).playerNetServerHandler.sendPacketToPlayer(PacketCreator.createPacket(EnumPackets.SetTradingReadyClient, ready ? 1
						: 0));
			}
		if (player2 != null)
			if (player.username == player2.username) {
				ready2 = ready;
				((EntityPlayerMP) player1).playerNetServerHandler.sendPacketToPlayer(PacketCreator.createPacket(EnumPackets.SetTradingReadyClient, ready ? 1
						: 0));
			}

		tradePushed = false;
		return false;
	}

	public void setPos1(int pos) {
		try {
			PlayerStorage s = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player1);
			pos1 = pos;
			NBTTagCompound n = s.getNBT(s.getIDFromPosition(pos));
			if (n != null
					&& MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player1).EntityAlreadyExists(n.getInteger("pixelmonID"),
							player1.worldObj)) {
				EntityMaeme pixelmon = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player1).getAlreadyExists(
						n.getInteger("pixelmonID"), player1.worldObj);
				MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player1).retrieve(pixelmon);
				pixelmon.catchInPokeball();
			}

			((EntityPlayerMP) player1).playerNetServerHandler.sendPacketToPlayer(new MaemeStatsPacket(n, EnumPackets.SetSelectedStats).getPacket());
			if (player2 == null)
				return;
			((EntityPlayerMP) player2).playerNetServerHandler.sendPacketToPlayer(new MaemeDataPacket(n, EnumPackets.SetTradeTarget).getPacket());
			((EntityPlayerMP) player2).playerNetServerHandler.sendPacketToPlayer(new MaemeStatsPacket(n, EnumPackets.SetTradeTargetStats).getPacket());
		} catch (Exception e) {

		}
	}

	public void setPos2(int pos) {
		try {
			PlayerStorage s = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player2);
			pos2 = pos;
			NBTTagCompound n = s.getNBT(s.getIDFromPosition(pos));
			if (n != null
					&& MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player2).EntityAlreadyExists(n.getInteger("pixelmonID"),
							player2.worldObj)) {
				EntityMaeme pixelmon = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player2).getAlreadyExists(
						n.getInteger("pixelmonID"), player2.worldObj);
				MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player2).retrieve(pixelmon);
				pixelmon.catchInPokeball();
			}

			((EntityPlayerMP) player2).playerNetServerHandler.sendPacketToPlayer(new MaemeStatsPacket(n, EnumPackets.SetSelectedStats).getPacket());
			if (player1 == null)
				return;
			((EntityPlayerMP) player1).playerNetServerHandler.sendPacketToPlayer(new MaemeDataPacket(n, EnumPackets.SetTradeTarget).getPacket());
			((EntityPlayerMP) player1).playerNetServerHandler.sendPacketToPlayer(new MaemeStatsPacket(n, EnumPackets.SetTradeTargetStats).getPacket());
		} catch (Exception e) {
		}
	}

	public void removePlayer(Player player) {
		if (player1 == (EntityPlayer) player) {
			player1 = player2;
			player2 = null;
			playerCount--;
			pos2 = -1;
		} else if (player2 == (EntityPlayer) player) {
			player2 = null;
			playerCount--;
			pos2 = -1;
		}

		if (playerCount < 0)
			playerCount = 0;
		if (playerCount == 1)
			((EntityPlayerMP) player1).playerNetServerHandler.sendPacketToPlayer(PacketCreator.createStringPacket(EnumPackets.RegisterTrader, ""));
	}

	public void trade() {
		if (tradePushed)
			return;
		try {
			PlayerStorage storage1 = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player1);
			PlayerStorage storage2 = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player2);
			tradePushed = true;
			NBTTagCompound pokemon1 = storage1.getNBT(storage1.getIDFromPosition(pos1));
			NBTTagCompound pokemon2 = storage2.getNBT(storage2.getIDFromPosition(pos2));
			storage1.changePokemon(pos1, pokemon2);
			storage2.changePokemon(pos2, pokemon1);
			player1.closeScreen();
			player2.closeScreen();
			playerCount = 0;

			ArrayList<EvolutionInfo> evolve1 = DBStats.getEvolveList(pokemon2.getString("Name"));
			for (EvolutionInfo e : evolve1) {
				if (e.mode == InfoMode.trade) {
					if (EnumPokemon.hasPokemon(e.extraParam)) {
						EntityMaeme pixelmon = storage1.sendOut(pokemon2.getInteger("pixelmonID"), worldObj);
						pixelmon.evolve(e.extraParam);
						storage1.retrieve(pixelmon);
					}
				}
			}
			ArrayList<EvolutionInfo> evolve2 = DBStats.getEvolveList(pokemon1.getString("Name"));
			for (EvolutionInfo e : evolve2) {
				if (e.mode == InfoMode.trade) {
					if (EnumPokemon.hasPokemon(e.extraParam)) {
						EntityMaeme pixelmon = storage2.sendOut(pokemon1.getInteger("pixelmonID"), worldObj);
						pixelmon.evolve(e.extraParam);
						storage2.retrieve(pixelmon);
					}
				}
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		boolean playerRemoved = false;
		int count = 0;

		if (player1 == null && playerCount > 0) {
			player1 = player2;
			player2 = null;
			playerCount--;
			pos2 = -1;
		} else if (player2 == null && playerCount > 1) {
			playerCount--;
			pos2 = -1;
		}

		if (playerCount == 1)
			((EntityPlayerMP) player1).playerNetServerHandler.sendPacketToPlayer(PacketCreator.createStringPacket(EnumPackets.RegisterTrader, ""));

	}
}