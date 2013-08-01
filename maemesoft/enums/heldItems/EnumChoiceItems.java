package maemesoft.enums.heldItems;

import maemesoft.entities.maeme.stats.StatsType;


public enum EnumChoiceItems {
	ChoiceBand(StatsType.Attack),
	ChoiceScarf(StatsType.Speed),
	ChoiceSpecs(StatsType.SpecialAttack);

	public StatsType effectType;
	private EnumChoiceItems(StatsType type){
		this.effectType = type;
	}
}