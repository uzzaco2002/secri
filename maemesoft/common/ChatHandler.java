package maemesoft.common;

//수정일 : 7/11 12:33 (현재 인벤토리 오류 수정중)

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayerMP;

public class ChatHandler {

	public static void sendChat(EntityLiving entityLiving, String string) {
		if (entityLiving != null)
			((EntityPlayerMP) entityLiving).sendChatToPlayer(string);
	}

	public static void sendChat(EntityLiving owner, EntityLiving owner2, String string) {
		if (owner != null)
			((EntityPlayerMP) owner).sendChatToPlayer(string);
		if (owner2 != null)
			((EntityPlayerMP) owner2).sendChatToPlayer(string);

	}

	public static void sendBattleMessage(EntityLiving owner, EntityLiving owner2, String string) {
		sendBattleMessage(owner, string);
		sendBattleMessage(owner2, string);
	}

	public static void sendBattleMessage(EntityLiving user, String string) {
		if (user!=null){
			((EntityPlayerMP)user).playerNetServerHandler.sendPacketToPlayer(PacketCreator.createStringPacket(EnumPackets.BattleMessage, string));
		}		
	}

}