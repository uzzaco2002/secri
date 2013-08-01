package maemesoft.entities.maeme.stats;

import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import net.minecraft.nbt.NBTTagCompound;
import maemesoft.entities.maeme.EntityMaeme;

public class FriendShip {
	private static final int maxFriendship = 255;
	private static final int minFriendship = 0;
	private int friendship = 0;
	private EntityMaeme pixelmon;
	private Random rand = new Random();
	boolean luxuryBall = false;

	public FriendShip(EntityMaeme pixelmon) {
		this.pixelmon = pixelmon;
	}

	public void initFromCapture() {
		friendship = pixelmon.baseStats.baseFriendship;
	}

	public void increaseFriendship(int amount) {
		friendship += amount;
		if (friendship > maxFriendship)
			friendship = maxFriendship;
	}

	public void decreaseFriendship(int amount) {
		friendship -= amount;
		if (friendship < minFriendship)
			friendship = minFriendship;
	}

	public int getFriendship() {
		return friendship;
	}

	public void initFromEgg() {
		friendship = 120;
	}

	public void resetFromTrade() {
		friendship = 70;
	}

	public boolean isFriendshipHighEnoughToEvolve() {
		return friendship >= 220;
	}

	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("Friendship", friendship);
		nbt.setBoolean("LuxuryBall", luxuryBall);
	}

	public void readFromNBT(NBTTagCompound nbt) {
		friendship = nbt.getInteger("Friendship");
		luxuryBall = nbt.getBoolean("LuxuryBall");
	}

	private int luxuryBonus() {

		if (luxuryBall)
			return 1 + rand.nextInt(2);
		else
			return 0;
	}

	private int tickCounter = 0;

	public void tick() {
		tickCounter++;
		if (tickCounter == 1000) {
			friendship++;
			friendship += luxuryBonus();
			tickCounter = 0;
		}
	}

	public void hurtByOwner() {
		decreaseFriendship(20);
	}

	public void onLevelUp() {
		increaseFriendship(rand.nextInt(2) + 5 + luxuryBonus());
	}

	public void onFaint() {
		decreaseFriendship(2);
	}

	public void captureLuxuryBall() {
		this.luxuryBall = true;
	}

	public void setFriendship(int i) {
		friendship = i;
	}
}