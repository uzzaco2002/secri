package maemesoft.entities.npcs;

import org.lwjgl.opengl.GL11;

import maemesoft.Maeme;
import maemesoft.enums.EnumGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityDoctor extends EntityNPC {

	public EntityDoctor(World par1World) {
		super(par1World, NPCType.Doctor);
		setName("Doctor");
	}

	@Override
	public boolean interactWithNPC(EntityPlayer player) {
		player.openGui(Maeme.instance, EnumGui.Doctor.getIndex(), player.worldObj, 0, 0, 0);
		return true;
	}
}