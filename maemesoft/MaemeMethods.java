package maemesoft;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerNotLoadedException;
import maemesoft.storage.PlayerStorage;

public class MaemeMethods {
	public static ArrayList<EntityMaeme> getAllActivePokemon(EntityPlayer player) {
		ArrayList<EntityMaeme> list = new ArrayList<EntityMaeme>();
		try {
			PlayerStorage storage = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player);
			for (NBTTagCompound nbt : storage.partyPokemon) {
				if (nbt != null)
					if (storage.EntityAlreadyExists(nbt.getInteger("pixelmonID"), player.worldObj))
						list.add(storage.getAlreadyExists(nbt.getInteger("pixelmonID"), player.worldObj));
			}
		} catch (PlayerNotLoadedException e) {
		}
		return list;
	}
}