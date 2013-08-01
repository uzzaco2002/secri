package maemesoft.entities.npcs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import maemesoft.Maeme;
import maemesoft.enums.EnumGui;
import maemesoft.enums.EnumPokemon;

public class EntityTrader extends EntityNPC {

	public class TradePair{
		public EnumPokemon offer;
		public EnumPokemon exchangefor;

		public TradePair(EnumPokemon offer, EnumPokemon exchangefor){
			this.offer = offer; this.exchangefor = exchangefor;
		}
	}

	private TradePair tradePair;
	public EntityTrader(World par1World) {
		super(par1World, NPCType.Trader);
		setName("Trader");
		tradePair = new TradePair(EnumPokemon.Bellsprout, EnumPokemon.Onix);
	}

	@Override
	public boolean interactWithNPC(EntityPlayer player) {
		player.openGui(Maeme.instance, EnumGui.PokemonTrade.getIndex(), player.worldObj, 0, 0, 0);
		return true;
	}
}