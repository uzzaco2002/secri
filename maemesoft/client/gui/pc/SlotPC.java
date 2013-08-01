package maemesoft.client.gui.pc;

import java.awt.Rectangle;

import net.minecraft.client.Minecraft;
import maemesoft.common.MaemeDataPacket;

public class SlotPC {

	public MaemeDataPacket pokemonData;
	public int x, y, swidth;

	public SlotPC(int x, int y, MaemeDataPacket pokemon) {
		this.pokemonData = pokemon;
		this.x = x;
		this.y = y;
		swidth = 30;
	}

	public int getRenderInt() {
		if (pokemonData == null)
			return 0;
		String pokeNum = "";
		if (pokemonData.getNationalPokedexNumber() < 10)
			pokeNum = "00" + pokemonData.getNationalPokedexNumber();
		else if (pokemonData.getNationalPokedexNumber() < 100)
			pokeNum = "0" + pokemonData.getNationalPokedexNumber();
		else
			pokeNum = "" + pokemonData.getNationalPokedexNumber();
		return Minecraft.getMinecraft().renderEngine.getTexture("/maemesoft/sprites/" + pokeNum);
	}

	public void clearPokemon() {
		pokemonData = null;
	}

	public void setPokemon(MaemeDataPacket p) {
		pokemonData = p;
	}

	public void setXandY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, swidth, swidth);
	}

}