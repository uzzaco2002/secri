package maemesoft.client.gui.inventoryExtended;

import java.awt.Rectangle;

import maemesoft.client.gui.pc.SlotPC;
import maemesoft.common.MaemeDataPacket;

public class SlotInventoryMaeme extends SlotPC {

	public int heldItemX, heldItemY;

	public SlotInventoryMaeme(int x, int y, MaemeDataPacket pokemon) {
		super(x, y, pokemon);
		swidth = 16;
		heldItemX = x + 19;
		heldItemY = y;
	}

	public Rectangle getHeldItemBounds() {
		return new Rectangle(heldItemX, heldItemY, swidth, swidth);
	}

}