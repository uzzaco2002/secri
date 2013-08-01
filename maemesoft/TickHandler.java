package maemesoft;

import java.util.ArrayList;
import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPool;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import maemesoft.client.ServerStorageDisplay;
import maemesoft.common.EnumPackets;
import maemesoft.common.PacketCreator;
import maemesoft.config.MaemeConfig;
import maemesoft.config.MaemeItems;
import maemesoft.items.ItemMaemeBoots;
import maemesoft.sounds.Sounds;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;

public class TickHandler implements ITickHandler {
	int ticksSinceSentLogin = 0;
	boolean checkedForUsername = false;
	boolean musicCleared = false;
	boolean foundSounds = false;

	private void onPlayerTick(EntityPlayer player) {
		ItemStack boots = player.getCurrentItemOrArmor(1);
		if (boots != null && boots.stackSize > 0 && boots.getItemDamage() < boots.getItem().getMaxDamage()) {
			if (boots.getItem() == MaemeItems.oldRunningShoes) {
				player.addPotionEffect((new PotionEffect(Potion.moveSpeed.getId(), 10, 0)));
			} else if (boots.getItem() == MaemeItems.newRunningShoes) {
				player.addPotionEffect((new PotionEffect(Potion.moveSpeed.getId(), 10, 1)));

				if (ItemMaemeBoots.bootLastX == 0 || ItemMaemeBoots.bootLastZ == 0) {
					ItemMaemeBoots.bootLastX = (int) player.getPlayerCoordinates().posX;
					ItemMaemeBoots.bootLastZ = (int) player.getPlayerCoordinates().posZ;
				} else {
					int changeX = (int) (Math.abs(ItemMaemeBoots.bootLastX - player.getPlayerCoordinates().posX));
					int changeZ = (int) (Math.abs(ItemMaemeBoots.bootLastZ - player.getPlayerCoordinates().posZ));

					if (changeX > 2 || changeZ > 2) {
						boots.damageItem(1, player);
						ItemMaemeBoots.bootLastX = (int) player.getPlayerCoordinates().posX;
						ItemMaemeBoots.bootLastZ = (int) player.getPlayerCoordinates().posZ;
						if (boots.getItemDamage() == MaemeItems.newRunningShoes.getMaxDamage()) {
							removeItem(player, boots);
							ItemStack oldShoes = new ItemStack(MaemeItems.oldRunningShoes, 1, 0);
							player.inventory.addItemStackToInventory(oldShoes);
						}
					}
				}
			}
		}
	}

	public void removeItem(EntityPlayer ep, ItemStack removeitem) {
		IInventory inv = ep.inventory;
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			if (inv.getStackInSlot(i) != null) {
				ItemStack j = inv.getStackInSlot(i);
				if (j.getItem() != null && j.getItem() == removeitem.getItem()) {
					inv.setInventorySlotContents(i, null);
				}
			}
		}
	}

	@Override
	public void tickStart(EnumSet<TickType> types, Object... tickData) {

		if (types.equals(EnumSet.of(TickType.PLAYER))) {
			onPlayerTick((EntityPlayer) tickData[0]);
		}

		for (TickType type : types) {

			if (!checkedForUsername && type == TickType.RENDER && !Minecraft.getMinecraft().session.username.equals("ASH")
					&& java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0) {
				Minecraft.getMinecraft().session.username = "ASH";
			}
			checkedForUsername = true;
			if (type == TickType.RENDER) {
				if (ServerStorageDisplay.count() == 0) {
					ticksSinceSentLogin++;
					if (ticksSinceSentLogin >= 50) {
						ticksSinceSentLogin = 0;
						Packet250CustomPayload packet = PacketCreator.createPacket(EnumPackets.RequestUpdatedPokemonList, 0);
						PacketDispatcher.sendPacketToServer(packet);
					}
				}
				if (!musicCleared) {
					ArrayList l = ObfuscationReflectionHelper.getPrivateValue(SoundPool.class, Minecraft.getMinecraft().sndManager.soundPoolMusic, 2);
					if (l.size() != 0) {
						if (MaemeConfig.removeVanillaMusic)
							l.clear();
						foundSounds = Sounds.installMusic();
						musicCleared = true;
					}
				}
				if (musicCleared && !foundSounds) {
					foundSounds = true;
					Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(
							"Couldn't find music at " + Minecraft.getMinecraftDir() + "/resources/music/pixelmon");
				}
			}
		}

	}

	@Override
	public void tickEnd(EnumSet<TickType> types, Object... tickData) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.RENDER, TickType.WORLD, TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		return "Pixelmon Ticker";
	}

}