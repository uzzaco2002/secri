package maemesoft.enums;

public enum EnumTrainers {
	Youngster, 
	Fisherman,
	//FemaleRocketGrunt, This model needs to be pieced correctly.
	BugCatcher,
	Ornithologist,
	Swimmer,
	FireBreather,
	//FemaleScientist,
	BugManiac;


	public static boolean has(String creatureName) {
		for (EnumTrainers trainer : values())
			if (trainer.toString().equalsIgnoreCase(creatureName))
				return true;
		return false;
	}
}