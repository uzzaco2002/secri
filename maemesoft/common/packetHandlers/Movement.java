package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import maemesoft.common.EnumPackets;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.entities.maeme.helpers.PlayerRiding;
import maemesoft.enums.EnumMovement;
import cpw.mods.fml.common.network.Player;

public class Movement extends PacketHandlerBase {

	public Movement() {
		packetsHandled.add(EnumPackets.Movement);
	}

	@Override
	public void handlePacket(int index, Player player, DataInputStream dataStream) throws IOException {
		int numMovements = dataStream.readShort();
		EnumMovement[] movement = new EnumMovement[numMovements];
		for (int i = 0; i < numMovements; i++) {
			movement[i] = EnumMovement.getMovement(dataStream.readShort());
		}
		ArrayList<PlayerRiding> rl = EntityMaeme.PlayerRidingList;
		boolean prExists = false;
		do {
			for (int i = 0; i < rl.size(); i++) {
				if (rl.get(i).player == (EntityPlayer) player) {
					for (int j = 0; j < numMovements; j++) {
						if (movement[j] == EnumMovement.Accelerate)
							rl.get(i).acceleration++;
						else if (movement[j] == EnumMovement.Decelerate)
							rl.get(i).acceleration--;
						else if (movement[j] == EnumMovement.Left)
							rl.get(i).rotation--;
						else if (movement[j] == EnumMovement.Right)
							rl.get(i).rotation++;
						else if (movement[j] == EnumMovement.Jump)
							rl.get(i).jump++;
						else if (movement[j] == EnumMovement.Crouch)
							rl.get(i).jump--;
					}
					prExists = true;
					break;
				}
			}
			if (!prExists) {
				PlayerRiding pr = new PlayerRiding();
				pr.player = (EntityPlayer) player;
				rl.add(pr);
			}
		} while (!prExists);
	}
}