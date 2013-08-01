package maemesoft.entities.pokeballs;

import java.util.ArrayList;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall.Mode;
import maemesoft.entities.pokeballs.captures.CaptureBase;
import maemesoft.entities.pokeballs.captures.CaptureDiveBall;
import maemesoft.entities.pokeballs.captures.CaptureDuskBall;
import maemesoft.entities.pokeballs.captures.CaptureFriendBall;
import maemesoft.entities.pokeballs.captures.CaptureHealBall;
import maemesoft.entities.pokeballs.captures.CaptureHeavyBall;
import maemesoft.entities.pokeballs.captures.CaptureLevelBall;
import maemesoft.entities.pokeballs.captures.CaptureLoveBall;
import maemesoft.entities.pokeballs.captures.CaptureLuxuryBall;
import maemesoft.entities.pokeballs.captures.CaptureMoonBall;
import maemesoft.entities.pokeballs.captures.CaptureNestBall;
import maemesoft.entities.pokeballs.captures.CaptureNetBall;
import maemesoft.entities.pokeballs.captures.CaptureSafariBall;
import maemesoft.enums.EnumPokeballs;

public class PokeballTypeHelper {

	private static ArrayList<CaptureBase> captureList  = new ArrayList<CaptureBase>();

	static{
		captureList.add(new CaptureLoveBall());
		captureList.add(new CaptureLevelBall());
		captureList.add(new CaptureMoonBall());
		captureList.add(new CaptureFriendBall());
		captureList.add(new CaptureSafariBall());
		captureList.add(new CaptureDiveBall());
		captureList.add(new CaptureDuskBall());
		captureList.add(new CaptureHealBall());
		captureList.add(new CaptureLuxuryBall());
		captureList.add(new CaptureNetBall());
		captureList.add(new CaptureNestBall());
		captureList.add(new CaptureHeavyBall());
	}

	public static double getBallBonus(EnumPokeballs type, EntityLiving thrower, EntityMaeme p2, Mode mode) {
		double ballBonus = type.getBallBonus();
		for (CaptureBase c: captureList)
			if (c.pokeball == type) return c.getBallBonus(type, (EntityPlayer)thrower, p2, mode);
		return ballBonus;
	}

	public static void doAfterEffect(EnumPokeballs type, EntityMaeme p2){
		for (CaptureBase c: captureList)
			if (c.pokeball == type) c.doAfterEffect(type, p2);
	}

	public static int modifyCaptureRate(EnumPokeballs type, String pokemonName, int captureRate) {
		for (CaptureBase c: captureList)
			if (c.pokeball == type) return c.modifyCaptureRate(pokemonName, captureRate);
		return captureRate;
	}


}