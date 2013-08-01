package maemesoft;

import java.util.Random;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class CommandStruc extends CommandBase {

	@Override
	public String getCommandName() {
		return "struc";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		World world = getCommandSenderAsPlayer(icommandsender).worldObj;
		Random random = new Random();
		ChunkCoordinates cc = icommandsender.getPlayerCoordinates();
		int xPos = cc.posX;
		int yPos = cc.posY;
		int zPos = cc.posZ;
	}
}