package maemesoft.entities.pokeballs.captures;

import net.minecraft.entity.player.EntityPlayer;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall.Mode;
import maemesoft.enums.EnumPokeballs;

public class CaptureFriendBall extends CaptureBase {

	public CaptureFriendBall() {
		super(EnumPokeballs.FriendBall);
	}

	@Override
	public double getBallBonus(EnumPokeballs type, EntityPlayer thrower, EntityMaeme p2, Mode mode) {
		return type.getBallBonus();
	}

	@Override
	public void doAfterEffect(EnumPokeballs type, EntityMaeme p) {
		p.friendship.setFriendship(200);		
	}
}
