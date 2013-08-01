package maemesoft.entities.pokeballs.captures;

import net.minecraft.entity.player.EntityPlayer;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall.Mode;
import maemesoft.enums.EnumPokeballs;

public abstract class CaptureBase {

	public EnumPokeballs pokeball;

	public CaptureBase(EnumPokeballs pokeball) {
		this.pokeball = pokeball;
	}

	public abstract double getBallBonus(EnumPokeballs type, EntityPlayer thrower, EntityMaeme p2, Mode mode);

	public void doAfterEffect(EnumPokeballs type, EntityMaeme p) {
	}

	public int modifyCaptureRate(String pokemonName, int captureRate) {
		return captureRate;
	}
}