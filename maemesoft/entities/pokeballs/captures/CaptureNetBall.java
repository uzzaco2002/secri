package maemesoft.entities.pokeballs.captures;

import net.minecraft.entity.player.EntityPlayer;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall.Mode;
import maemesoft.enums.EnumPokeballs;
import maemesoft.enums.EnumType;

public class CaptureNetBall extends CaptureBase {

	public CaptureNetBall() {
		super(EnumPokeballs.DuskBall);
	}

	@Override
	public double getBallBonus(EnumPokeballs type, EntityPlayer thrower, EntityMaeme p2, Mode mode) {
		if(p2.type.contains(EnumType.Bug) || p2.type.contains(EnumType.Water)){
			return 3;
		}
		return 1;
	}
}