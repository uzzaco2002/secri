package maemesoft.entities.pokeballs.captures;

import net.minecraft.entity.player.EntityPlayer;
import maemesoft.db.DBStats;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall.Mode;
import maemesoft.enums.EnumPokeballs;

public class CaptureHeavyBall extends CaptureBase {

	public CaptureHeavyBall() {
		super(EnumPokeballs.HeavyBall);
	}

	@Override
	public double getBallBonus(EnumPokeballs type, EntityPlayer thrower, EntityMaeme p2, Mode mode) {
		return type.getBallBonus();
	}

	@Override
	public int modifyCaptureRate(String pokemonName, int captureRate) {
		float weight = DBStats.getWeight(pokemonName);
		if (weight < 205) {
			captureRate -= 20;
		} else if (weight < 307) {
			captureRate += 20;
		} else if (weight < 409.5)
			captureRate += 30;
		else
			captureRate += 40;
		return captureRate;
	}

}