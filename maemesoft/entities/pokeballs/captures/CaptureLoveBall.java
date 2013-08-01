package maemesoft.entities.pokeballs.captures;

import net.minecraft.entity.player.EntityPlayer;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall.Mode;
import maemesoft.enums.EnumPokeballs;

public class CaptureLoveBall extends CaptureBase {

	public CaptureLoveBall() {
		super(EnumPokeballs.LoveBall);
	}

	@Override
	public double getBallBonus(EnumPokeballs type, EntityPlayer thrower, EntityMaeme p2, Mode mode) {
		double ballBonus = type.getBallBonus();
		if (mode == Mode.battle) {
			boolean ownerPokemonIsMale = true;
			String ownerPokemonName = "";
			if (ownerPokemonIsMale != p2.isMale && ownerPokemonName.equals(p2.getName()))
				return 8;
		}
		return ballBonus;
	}

}