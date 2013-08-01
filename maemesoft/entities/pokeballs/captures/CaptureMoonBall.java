package maemesoft.entities.pokeballs.captures;

import net.minecraft.entity.player.EntityPlayer;
import maemesoft.db.DBStats;
import maemesoft.db.EvolutionInfo;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall.Mode;
import maemesoft.enums.EnumEvolutionStone;
import maemesoft.enums.EnumPokeballs;

public class CaptureMoonBall extends CaptureBase {

	public CaptureMoonBall() {
		super(EnumPokeballs.MoonBall);
	}

	@Override
	public double getBallBonus(EnumPokeballs type, EntityPlayer thrower, EntityMaeme p2, Mode mode) {
		for (EvolutionInfo e : DBStats.getEvolveList(p2.getName())) {
			if (e.evolutionStone == EnumEvolutionStone.Moonstone || p2.getName().equalsIgnoreCase("Nidoqueen") || p2.getName().equalsIgnoreCase("Nidoking")
					|| p2.getName().equalsIgnoreCase("Clefable") || p2.getName().equalsIgnoreCase("Wigglytuff") || p2.getName().equalsIgnoreCase("Delcatty")) {
				return 4;
			}
		}
		return 1;
	}
}