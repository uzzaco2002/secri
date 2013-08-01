package maemesoft.client.gui;

import maemesoft.common.MaemeMovesetDataPacket;

public class GuiItemMoveSlot {

	private MaemeMovesetDataPacket attack;
	private String name;
	private int attackIndex;

	public GuiItemMoveSlot(MaemeMovesetDataPacket[] moveSet, int a){
		attack = moveSet[a];
		name = attack.attackName;
		attackIndex = a;
	}

	public int getAttackIndex(){
		return attackIndex;
	}

	public String getDisplay(){
		return name + " " + attack.pp + "/" + attack.ppBase;
	}

	public String getName(){
		return name;
	}

	public MaemeMovesetDataPacket getAttack(){
		return attack;
	}

}