package maemesoft.client.KeyBindings;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import maemesoft.client.gui.GuiMaemeOverlay;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class NextPokemonKey extends KeyHandler {

	public NextPokemonKey() {
		super(new KeyBinding[] { new KeyBinding("Next Pixelmon", 27) }, new boolean[] { false });
	}

	@Override
	public String getLabel() {
		return "Next Pixelmon";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		if (tickEnd || Minecraft.getMinecraft().theWorld == null)
			return;
		GuiMaemeOverlay.selectNextPixelmon();
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT, TickType.WORLD);
	}

}