package maemesoft.entities.pokeballs.captures;

import net.minecraft.entity.player.EntityPlayer;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall.Mode;
import maemesoft.enums.EnumPokeballs;

public class CaptureDiveBall extends CaptureBase {

	public CaptureDiveBall() {
		super(EnumPokeballs.DiveBall);
	}

	@Override
	public double getBallBonus(EnumPokeballs type, EntityPlayer thrower, EntityMaeme p2, Mode mode) {

		if(p2.isInWater()){
			return 3.5;
		}
		else return 1;
	}
}