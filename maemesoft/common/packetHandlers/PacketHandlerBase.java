package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import maemesoft.common.EnumPackets;
import cpw.mods.fml.common.network.Player;

public abstract class PacketHandlerBase {
	protected ArrayList<EnumPackets> packetsHandled;

	public PacketHandlerBase() {
		packetsHandled = new ArrayList<EnumPackets>();
	}

	public boolean handlesPacket(int index) {
		for (EnumPackets e : packetsHandled)
			if (e.getIndex() == index)
				return true;

		return false;
	}

	public abstract void handlePacket(int index, Player player, DataInputStream dataStream) throws IOException;
}