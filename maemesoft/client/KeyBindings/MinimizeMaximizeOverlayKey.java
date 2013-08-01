package maemesoft.client.KeyBindings;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import maemesoft.client.gui.GuiMaemeOverlay;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class MinimizeMaximizeOverlayKey extends KeyHandler {

	public MinimizeMaximizeOverlayKey() {
		super(new KeyBinding[] { new KeyBinding("Minimize/Maximize Overlay", Keyboard.KEY_O) }, new boolean[] { false });
	}

	@Override
	public String getLabel() {
		return "Minimize/Maximize Overlay";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		if (Minecraft.getMinecraft().currentScreen != null || Minecraft.getMinecraft().theWorld == null || tickEnd) {
			return;
		}
		GuiMaemeOverlay.isGuiMinimized = !GuiMaemeOverlay.isGuiMinimized;
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT, TickType.WORLD);
	}

}