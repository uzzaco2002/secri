package maemesoft.blocks;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import maemesoft.config.MaemeItems;
import maemesoft.config.MaemeItemsPokeballs;
import maemesoft.items.ItemPokeballDisc;

public class TileEntityAnvil extends TileEntity {

	public int itemOnAnvil = -1;
	public int state = 0;

	public TileEntityAnvil() {
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("ItemOnAnvil", itemOnAnvil);
		nbt.setInteger("AnvilItemState", state);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		itemOnAnvil = nbt.getInteger("ItemOnAnvil");
		state = nbt.getInteger("AnvilItemState");
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound var1 = new NBTTagCompound();
		this.writeToNBT(var1);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, var1);
	}

	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
		readFromNBT(pkt.customParam1);
	}

	int count = 0;

	public boolean blockHit(int f) {
		boolean returnVal = false;
		if (itemOnAnvil == MaemeItems.aluminiumIngot.itemID){
			count += f;
			if (count >= 15) {
				count = 0;
				state++;
				returnVal = true;
				if (state == 3) {
					state = 0;
					itemOnAnvil = MaemeItems.aluminiumPlate.itemID;
				}
			}
		}
		else if (itemOnAnvil != -1) {
			Item item = MaemeItemsPokeballs.getItemFromID(itemOnAnvil);
			if (item instanceof ItemPokeballDisc || item == MaemeItemsPokeballs.ironDisc) {
				count += f;
				if (count >= 5) {
					count = 0;
					state++;
					returnVal = true;
					if (state == 3) {
						state = 0;
						if (item == MaemeItemsPokeballs.ironDisc)
							itemOnAnvil = MaemeItemsPokeballs.ironBase.itemID;
						else
							itemOnAnvil -= 20;
					}
				}
			}
		}
		return returnVal;
	}
}