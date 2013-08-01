package maemesoft.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import maemesoft.common.MaemeDataPacket;
import maemesoft.storage.ComputerBox;
import maemesoft.storage.PlayerComputerStorage;

public class MaemeServerStore {
	private static MaemeDataPacket[][] store = new MaemeDataPacket[PlayerComputerStorage.boxCount][ComputerBox.boxLimit];
	private static MaemeDataPacket mousePokemon;

	public static void addToList(DataInputStream dataStream) {
		MaemeDataPacket p = new MaemeDataPacket();
		try {
			p.readPacketData(dataStream);
			store[p.boxNumber][p.order] = p;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void clearList() {
		for (int i = 0; i < PlayerComputerStorage.boxCount; i++)
			for (int j = 0; j < ComputerBox.boxLimit; j++)
				store[i][j] = null;
	}

	public static MaemeDataPacket getFromBox(int i, int j) {
		return store[i][j];
	}

	public static MaemeDataPacket getPixelmonDataFromID(int id) {
		for (int i = 0; i < PlayerComputerStorage.boxCount; i++)
			for (int j = 0; j < ComputerBox.boxLimit; j++)
				if (store[i][j] != null)
					if (store[i][j].pokemonID == id)
						return store[i][j];
		return null;
	}

	public static void removeFromList(int box, int pos) {
		store[box][pos] = null;
	}

	public static void setMousePokemon(DataInputStream dataStream) {
		MaemeDataPacket p = new MaemeDataPacket();
		try {
			p.readPacketData(dataStream);
			mousePokemon = p;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void clearMousePokemon() {
		mousePokemon = null;
	}

	public static MaemeDataPacket getMousePokemon() {
		return mousePokemon;
	}
}