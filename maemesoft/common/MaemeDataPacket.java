package maemesoft.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import maemesoft.db.DBStats;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.enums.EnumGrowth;
import maemesoft.enums.EnumNature;
import maemesoft.enums.EnumType;

public class MaemeDataPacket extends MaemePacket {
	public int pokemonID;
	public String name;
	public String nickname;
	public int lvl;
	public int hp;
	public int health;
	public int friendship;
	public boolean isMale;
	public boolean isFainted;
	private int nationalPokedexNumber = -1;

	public int getNationalPokedexNumber() {
		if (nationalPokedexNumber == -1)
			nationalPokedexNumber = DBStats.getNationalPokedexNumber(name);
		return nationalPokedexNumber;
	}

	private EnumType type1 = null, type2 = null;

	public EnumType getType1() {
		if (type1 == null) {
			Object ret = DBStats.getStat(name, "Type1");
			type1 = EnumType.parseType((String) ret);
		}
		return type1;
	}

	public EnumType getType2() {
		if (type2 == null) {
			Object ret = DBStats.getStat(name, "Type2");
			type2 = EnumType.parseType((String) ret);
		}
		return type2;
	}

	public int order;
	public int numMoves;
	public int HP;
	public int Speed;
	public int Attack;
	public int Defence;
	public int SpecialAttack;
	public int SpecialDefence;
	public int nextLvlXP;
	public int boxNumber = 0;
	public boolean isShiny;
	public boolean hasOwner;
	public boolean doesLevel;
	public int heldItemId = -1;
	public int xp;
	private int effectCount = 0;
	public EnumNature nature;
	public EnumGrowth growth;

	public MaemeMovesetDataPacket[] moveset = new MaemeMovesetDataPacket[4];

	public MaemeDataPacket() {

	}

	public MaemeDataPacket(NBTTagCompound p, EnumPackets packetType) {
		this.packetType = packetType;
		pokemonID = p.getInteger("pixelmonID");
		name = p.getString("Name");
		nickname = p.getString("Nickname");
		lvl = p.getInteger("Level");
		nextLvlXP = p.getInteger("EXPToNextLevel");
		xp = p.getInteger("EXP");
		hp = p.getInteger("StatsHP");
		friendship = p.getInteger("Friendship");
		health = p.getShort("Health");
		isMale = p.getBoolean("IsMale");
		isFainted = p.getBoolean("IsFainted");
		isShiny = p.getBoolean("IsShiny");
		nature = EnumNature.getNatureFromIndex(p.getShort("Nature"));
		growth = EnumGrowth.getGrowthFromIndex(p.getShort("Growth"));
		order = p.getInteger("PixelmonOrder");
		numMoves = p.getInteger("PixelmonNumberMoves");
		for (int i = 0; i < numMoves; i++) {
			moveset[i] = MaemeMovesetDataPacket.createPacket(p, i);
		}
		HP = p.getInteger("StatsHP");
		Speed = p.getInteger("StatsSpeed");
		Attack = p.getInteger("StatsAttack");
		Defence = p.getInteger("StatsDefence");
		SpecialAttack = p.getInteger("StatsSpecialAttack");
		SpecialDefence = p.getInteger("StatsSpecialDefence");
		if (p.hasKey("HeldItem")) {
			heldItemId = p.getInteger("HeldItem");
		}
		if (p.hasKey("BoxNumber"))
			boxNumber = p.getInteger("BoxNumber");
		hasOwner = true;
		doesLevel = p.getBoolean("DoesLevel");
		effectCount = p.getShort("EffectCount");
	}

	public MaemeDataPacket(EntityMaeme p, EnumPackets packetType) {
		this.packetType = packetType;
		pokemonID = p.getPokemonId();
		name = p.getName();
		nickname = p.getNickname();
		lvl = p.getLvl().getLevel();
		nextLvlXP = p.getLvl().getExpToNextLevel();
		xp = p.getLvl().getExp();
		hp = p.stats.HP;
		friendship = p.friendship.getFriendship();
		health = p.getHealth();
		isMale = p.isMale;
		isFainted = p.isFainted;
		isShiny = p.getIsShiny();
		nature = p.getNature();
		growth = p.getGrowth();
		if (p.getOwner() != null) {
		} else
			order = 0;
		HP = p.stats.HP;
		Speed = p.stats.Speed;
		Attack = p.stats.Attack;
		Defence = p.stats.Defence;
		SpecialAttack = p.stats.SpecialAttack;
		SpecialDefence = p.stats.SpecialDefence;
		if (p.heldItem != null)
			heldItemId = p.heldItem.itemID;
		doesLevel = p.doesLevel;
	}

	@Override
	public int getID() {
		return packetType.getIndex();
	}

	@Override
	public void writePacketData(DataOutputStream data) throws IOException {
		data.writeInt(pokemonID);
		Packet.writeString(name, data);
		Packet.writeString(nickname, data);
		data.writeShort(lvl);
		data.writeShort(nextLvlXP);
		data.writeShort(xp);
		data.writeShort(hp);
		data.writeShort(friendship);
		data.writeShort(health);
		data.writeBoolean(isMale);
		data.writeBoolean(isFainted);
		data.writeBoolean(hasOwner);
		data.writeShort(order);
		data.writeShort(numMoves);
		for (int i = 0; i < numMoves; i++) {
			moveset[i].writeData(data);
		}
		data.writeShort(HP);
		data.writeShort(Speed);
		data.writeShort(Attack);
		data.writeShort(Defence);
		data.writeShort(SpecialAttack);
		data.writeShort(SpecialDefence);
		data.writeShort(boxNumber);
		data.writeBoolean(isShiny);
		data.writeShort(nature.index);
		data.writeShort(growth.index);
		data.writeBoolean(doesLevel);
		data.writeInt(heldItemId);
		data.writeShort(effectCount);
	}

	@Override
	public void readPacketData(DataInputStream data) throws IOException {
		pokemonID = data.readInt();
		name = Packet.readString(data, 64);
		nickname = Packet.readString(data, 64);
		lvl = data.readShort();
		nextLvlXP = data.readShort();
		xp = data.readShort();
		hp = data.readShort();
		friendship = data.readShort();
		health = data.readShort();
		isMale = data.readBoolean();
		isFainted = data.readBoolean();
		hasOwner = data.readBoolean();
		order = data.readShort();
		numMoves = data.readShort();
		for (int i = 0; i < numMoves; i++) {
			moveset[i] = new MaemeMovesetDataPacket();
			moveset[i].readData(data);
		}
		HP = data.readShort();
		Speed = data.readShort();
		Attack = data.readShort();
		Defence = data.readShort();
		SpecialAttack = data.readShort();
		SpecialDefence = data.readShort();
		boxNumber = data.readShort();
		isShiny = data.readBoolean();
		nature = EnumNature.getNatureFromIndex(data.readShort());
		growth = EnumGrowth.getGrowthFromIndex(data.readShort());
		doesLevel = data.readBoolean();
		heldItemId = data.readInt();
		effectCount = data.readShort();
	}

	private String description;
	public boolean outside;

	public String getDescription() {
		if (description == null)
			description = DBStats.getDescription(name);
		return description;
	}
}