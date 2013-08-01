package maemesoft.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.nbt.NBTTagCompound;
import maemesoft.entities.maeme.EntityMaeme;

public class MaemeLevelUpPacket extends MaemePacket {
	public int pokemonID;
	public int level;
	public MaemeStatsPacket statsLevel1;
	public MaemeStatsPacket statsLevel2;

	public MaemeMovesetDataPacket[] moveset = new MaemeMovesetDataPacket[4];

	public MaemeLevelUpPacket() {

	}

	public MaemeLevelUpPacket(EntityMaeme p, int level, MaemeStatsPacket statsLevel1, MaemeStatsPacket statsLevel2 , EnumPackets packetType) {
		this.packetType = packetType;
		pokemonID = p.getPokemonId();
		this.level = level;
		this.statsLevel1 = statsLevel1;
		this.statsLevel2 = statsLevel2;
	}

	public MaemeLevelUpPacket(NBTTagCompound p, int level, MaemeStatsPacket statsLevel1, MaemeStatsPacket statsLevel2 , EnumPackets packetType) {
		this.packetType = packetType;
		pokemonID = p.getInteger("pixelmonID");
		this.level = level;
		this.statsLevel1 = statsLevel1;
		this.statsLevel2 = statsLevel2;
	}

	@Override
	public int getID() {
		return packetType.getIndex();
	}

	@Override
	public void writePacketData(DataOutputStream data) throws IOException {
		data.writeInt(pokemonID);
		data.writeInt(level);
		statsLevel1.writePacketData(data);
		statsLevel2.writePacketData(data);
	}

	@Override
	public void readPacketData(DataInputStream data) throws IOException {
		pokemonID = data.readInt();
		level = data.readInt();
		statsLevel1 = new MaemeStatsPacket();
		statsLevel1.readPacketData(data);
		statsLevel2 = new MaemeStatsPacket();
		statsLevel2.readPacketData(data);
	}
}