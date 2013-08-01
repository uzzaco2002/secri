package maemesoft.db;

import maemesoft.enums.EnumEvolutionRock;
import maemesoft.enums.EnumEvolutionStone;

public class EvolutionInfo {
	public enum InfoMode {
		biome, stone, friendship, trade, evolutionRock
	}

	public InfoMode mode;
	public EnumEvolutionStone evolutionStone;
	public String extraParam;
	public String pokemonName;
	public String extraParam2;
	public EnumEvolutionRock evolutionRock;
}