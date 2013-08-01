package maemesoft.entities.pokeballs.captures;

import net.minecraft.entity.player.EntityPlayer;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall.Mode;
import maemesoft.enums.EnumPokeballs;

public class CaptureLevelBall extends CaptureBase {

	public CaptureLevelBall() {
		super(EnumPokeballs.LevelBall);
	}

	@Override
	public double getBallBonus(EnumPokeballs type, EntityPlayer thrower, EntityMaeme p2, Mode mode) {
		double ballBonus = pokeball.getBallBonus();
		if (mode == Mode.battle) {
			int ownerPokemonLevel = 0;
			if (ownerPokemonLevel > 1 * p2.getLvl().getLevel())
				ballBonus = 2;
			if (ownerPokemonLevel > 2 * p2.getLvl().getLevel())
				ballBonus = 4;
			if (ownerPokemonLevel > 4 * p2.getLvl().getLevel())
				ballBonus = 8;
		}
		return ballBonus;
	}

}