package maemesoft.entities.pokeballs.captures;

import net.minecraft.entity.player.EntityPlayer;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall.Mode;
import maemesoft.enums.EnumPokeballs;

public class CaptureNestBall extends CaptureBase {

	public CaptureNestBall() {
		super(EnumPokeballs.NestBall);
	}

	@Override
	public double getBallBonus(EnumPokeballs type, EntityPlayer thrower, EntityMaeme p2, Mode mode) {
		float lvl = p2.getLvl().getLevel();
		double bonus = (40f - lvl) / 10f;
		if (bonus < 1)
			bonus = 1;
		return bonus;
	}
}