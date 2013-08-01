package maemesoft.client.KeyBindings;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import maemesoft.client.ServerStorageDisplay;
import maemesoft.client.gui.GuiMaemeOverlay;
import maemesoft.common.EnumPackets;
import maemesoft.common.PacketCreator;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;

public class SendPokemonKey extends KeyHandler {

	public SendPokemonKey() {
		super(new KeyBinding[] { new KeyBinding("Send/Recieve Pixelmon", Keyboard.KEY_P) }, new boolean[] { false });
	}

	@Override
	public String getLabel() {
		return "Send/Recieve Pixelmon";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		if (Minecraft.getMinecraft().currentScreen != null || Minecraft.getMinecraft().theWorld == null || tickEnd) {
			return;
		}
		if (ServerStorageDisplay.pokemon[GuiMaemeOverlay.selectedPixelmon] != null)
			PacketDispatcher.sendPacketToServer(PacketCreator.createPacket(EnumPackets.SendPokemon, ServerStorageDisplay.pokemon[GuiMaemeOverlay.selectedPixelmon].pokemonID));
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT, TickType.WORLD);
	}

}