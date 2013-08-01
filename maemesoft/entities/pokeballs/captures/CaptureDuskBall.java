package maemesoft.entities.pokeballs.captures;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall.Mode;
import maemesoft.enums.EnumPokeballs;

public class CaptureDuskBall extends CaptureBase {

	public CaptureDuskBall() {
		super(EnumPokeballs.DuskBall);
	}

	@Override
	public double getBallBonus(EnumPokeballs type, EntityPlayer thrower, EntityMaeme p2, Mode mode) {
		if(p2.posY <= 64 && !p2.worldObj.canLightningStrikeAt(MathHelper.floor_double(p2.posX), MathHelper.floor_double(p2.posY), MathHelper.floor_double(p2.posZ)) && p2.worldObj.getLightBrightness(MathHelper.floor_double(p2.posX), MathHelper.floor_double(p2.posY), MathHelper.floor_double(p2.posZ)) <= 14|| !p2.worldObj.isDaytime()){
			return 3.5;
		}
		return 1;
	}
}