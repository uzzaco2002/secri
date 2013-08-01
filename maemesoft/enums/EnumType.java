package maemesoft.enums;

import java.util.ArrayList;
import java.util.Iterator;

public enum EnumType {
	Normal(0, "Normal", 0xDDDDDD, 2, 6), Fire(1, "Fire", 0xFF8800, 2, 30), Water(2, "Water", 0x5765FF, 2, 54), Electric(3, "Electric", 0xF5F24C, 2, 78), Grass(
			4, "Grass", 0x00D420, 2, 102), Ice(5, "Ice", 0xB0FFFF, 43, 6), Fighting(6, "Fighting", 0xBA0038, 43, 30), Poison(7, "Poison", 0xC905F0, 43, 54), Ground(
			8, "Ground", 0x996640, 43, 78), Flying(9, "Flying", 0xCCD5FF, 43, 102), Psychic(10, "Psychic", 0xFF54EB, 84, 6), Bug(11, "Bug", 0xA8E053, 84, 30), Rock(
			12, "Rock", 0xA37755, 84, 54), Ghost(13, "Ghost", 0x6C2B8A, 84, 78), Dragon(14, "Dragon", 0x2B30CC, 84, 102), Dark(15, "Dark", 0x404040, 123, 6), Steel(
			16, "Steel", 0xBCBCC2, 123, 30), Mystery(17, "???", 0x309680, 0, 0);

	private int index;
	private String name;
	private int color;
	public float textureX;
	public float textureY;

	private EnumType(int i, String s, int c, float texX, float texY) {
		index = i;
		name = s;
		color = c;
		textureX = texX;
		textureY = texY;
	}

	public int getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public static EnumType parseType(int i) {
		ArrayList<EnumType> list = getAllTypes();
		Iterator<EnumType> it = list.iterator();
		while (it.hasNext()) {
			EnumType t = it.next();
			if (t.index == i)
				return t;
		}
		return Mystery;
	}

	public static EnumType parseType(String s) {
		ArrayList<EnumType> list = getAllTypes();
		Iterator<EnumType> it = list.iterator();
		while (it.hasNext()) {
			EnumType t = it.next();
			if (t.name.equalsIgnoreCase(s))
				return t;
		}
		return Mystery;
	}

	public static ArrayList<EnumType> getAllTypes() {
		ArrayList<EnumType> list = new ArrayList<EnumType>();
		EnumType[] t = values();
		for (int i = 0; i < t.length; i++)
			list.add(t[i]);
		return list;
	}

	public int getIndex() {
		return index;
	}

}