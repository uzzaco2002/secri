package maemesoft.common.packetHandlers;

import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import maemesoft.StarterList;
import maemesoft.common.EnumPackets;
import maemesoft.config.MaemeEntityList;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.enums.EnumPokeballs;
import maemesoft.storage.MaemeStorage;
import maemesoft.storage.PlayerNotLoadedException;
import maemesoft.storage.PlayerStorage;
import cpw.mods.fml.common.network.Player;

public class ChooseStarter extends PacketHandlerBase {

	public ChooseStarter() {
		packetsHandled.add(EnumPackets.ChooseStarter);
	}

	@Override
	public void handlePacket(int index, Player play, DataInputStream dataStream) throws IOException {
		try {
			EntityPlayer player = (EntityPlayer) play;
			PlayerStorage s = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player);
			int pokemonIndex = dataStream.readInt();
			EntityMaeme p = (EntityMaeme) MaemeEntityList.createEntityByName(StarterList.getStarterStringList()[pokemonIndex], player.worldObj); // 서번트 지정
			p.getLvl().setLevel(50); // 레벨설정
			p.setEntityHealth(p.stats.HP); // 체력설정
			p.caughtBall = EnumPokeballs.PokeBall;
			p.friendship.initFromCapture();
			s.addToParty(p);

			EntityPlayer player1 = (EntityPlayer) play;
			PlayerStorage k = MaemeStorage.CardManager.getPlayerStorage((EntityPlayerMP) player);
			EntityMaeme p1 = (EntityMaeme) MaemeEntityList.createEntityByName(StarterList.getStarterStringList()[1], player.worldObj); // 서번트 지정
			p1.getLvl().setLevel(50); // 레벨설정
			p1.setEntityHealth(p.stats.HP); // 체력설정
			p1.caughtBall = EnumPokeballs.PokeBall;
			p1.friendship.initFromCapture();
			k.addToParty(p1);
		} catch (PlayerNotLoadedException e) {
		}
	}

}