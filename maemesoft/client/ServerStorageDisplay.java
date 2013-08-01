package maemesoft.client;

import java.io.DataInputStream;
import java.io.IOException;

import maemesoft.common.MaemeDataPacket;

public class ServerStorageDisplay {
	public static MaemeDataPacket[] pokemon = new MaemeDataPacket[6];

	public static void add(DataInputStream dataStream) {
		MaemeDataPacket packet = new MaemeDataPacket();
		try {
			packet.readPacketData(dataStream);
			pokemon[packet.order] = packet;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int count() {
		int count = 0;
		for (int i = 0; i < pokemon.length; i++)
			if (pokemon[i] != null)
				count++;
		return count;
	}

	public static void update(DataInputStream dataStream) {
		MaemeDataPacket packet = new MaemeDataPacket();
		try {
			packet.readPacketData(dataStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pokemon[packet.order] = packet;

	}

	public static void clear() {
		for (int i = 0; i < pokemon.length; i++)
			pokemon[i] = null;
	}

	public static boolean contains(int pokemonId) {
		for (int i = 0; i < pokemon.length; i++) {
			if (pokemon[i] != null && pokemon[i].pokemonID == pokemonId)
				return true;
		}
		return false;
	}

	public static MaemeDataPacket get(int id) {
		for (MaemeDataPacket p : pokemon)
			if (p != null)
				if (p.pokemonID == id)
					return p;
		return null;
	}

	public static void remove(int id) {
		for (int i = 0; i < pokemon.length; i++)
			if (pokemon[i] != null)
				if (pokemon[i].pokemonID == id)
					pokemon[i] = null;
	}

	public static MaemeDataPacket getNextFromPos(int pos) {
		pos++;
		if (pos >= 6)
			pos = 0;
		while (pokemon[pos] == null) {
			pos++;
			if (pos >= 6)
				pos = 0;
		}
		return pokemon[pos];
	}

	public static MaemeDataPacket getPrevFromPos(int pos) {
		pos--;
		if (pos < 0)
			pos = 5;
		while (ServerStorageDisplay.pokemon[pos] == null) {
			pos--;
			if (pos < 0)
				pos = 5;
		}
		return pokemon[pos];
	}
}