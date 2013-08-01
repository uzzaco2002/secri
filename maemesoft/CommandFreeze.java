package maemesoft;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class CommandFreeze extends CommandBase {

	@Override
	public String getCommandName() {
		return "freeze";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		EntityPlayer var4 = getCommandSenderAsPlayer(var1);
		Maeme.freeze = !Maeme.freeze;
		if (Maeme.freeze) {
			var4.sendChatToPlayer("Pixelmon are frozen in place!");
			notifyAdmins(var1, 1, "Pixelmon are frozen in place!", new Object[]{});
		}
		else {
			var4.sendChatToPlayer("Pixelmon are unfrozen!");
			notifyAdmins(var1, 1, "Pixelmon are unfrozen!", new Object[]{});
		}
	}

}