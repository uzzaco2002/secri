package maemesoft.common.packetHandlers;

// 수정본 (2013, 7, 17)

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import maemesoft.common.ChatHandler;
import maemesoft.common.EnumPackets;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.pokeballs.EntityPokeBall;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerNotLoadedException;
import cpw.mods.fml.common.network.Player;

public class SendCard extends PacketHandlerBase {
	public static HashMap<EntityPlayer, EntityPokeBall> playerPokeballs = new HashMap<EntityPlayer, EntityPokeBall>();

	public SendCard() {
		packetsHandled.add(EnumPackets.SendPokemon);
	}

	@Override
	public void handlePacket(int index, Player pl, DataInputStream dataStream) throws IOException {
		EntityPlayerMP player = (EntityPlayerMP) pl;
		int pokemonId = dataStream.readInt();
		try {
			NBTTagCompound nbt = MaemeStorage.CardManager.getPlayerStorage(player).getNBT(pokemonId);
			if (nbt == null)
				return;
			if (!MaemeStorage.CardManager.getPlayerStorage(player).EntityAlreadyExists(pokemonId, player.worldObj)
					&& !MaemeStorage.CardManager.getPlayerStorage(player).isFainted(pokemonId)) {

				if (playerPokeballs.get(player) != null && !playerPokeballs.get(player).isDead)
					return;

				EntityMaeme pokemon = MaemeStorage.CardManager.getPlayerStorage(player).sendOut(pokemonId, player.worldObj);
				EntityPokeBall pokeball = new EntityPokeBall(player.worldObj, player, pokemon, pokemon.caughtBall);
				playerPokeballs.put(player, pokeball);

				boolean flag = nbt.getString("NickName") == null || nbt.getString("Nickname").isEmpty();
				ChatHandler.sendChat(player, "You sent out " + (flag ? nbt.getString("Name") : nbt.getString("Nickname")) + "!");

				player.worldObj.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (pokemon.worldObj.rand.nextFloat() * 0.4F + 0.8F));
				player.worldObj.spawnEntityInWorld(pokeball);
			} else if (MaemeStorage.CardManager.getPlayerStorage(player).isFainted(pokemonId)) {
				boolean flag = nbt.getString("NickName") == null || nbt.getString("Nickname").isEmpty();
				ChatHandler.sendChat(player, (flag ? nbt.getString("Name") : nbt.getString("Nickname")) + " is unable to battle!");
			} else if (MaemeStorage.CardManager.getPlayerStorage(player).EntityAlreadyExists(pokemonId, player.worldObj)) {
				EntityMaeme pixelmon = MaemeStorage.CardManager.getPlayerStorage(player).getAlreadyExists(pokemonId, player.worldObj);
				if (pixelmon == null) {
					return;
				}

				if (pixelmon.getOwner() == null)
					pixelmon.unloadEntity();
				else if (pixelmon.getOwner() == player) {
					MaemeStorage.CardManager.getPlayerStorage(player).retrieve(pixelmon);
					pixelmon.catchInPokeball();
					boolean flag = nbt.getString("NickName") == null || nbt.getString("Nickname").isEmpty();
					ChatHandler.sendChat(player, "You retrieved " + (flag ? nbt.getString("Name") : nbt.getString("Nickname")) + "!");
				}
			}
		} catch (PlayerNotLoadedException e) {
		}
	}
}