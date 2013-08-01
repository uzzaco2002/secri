package maemesoft.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import maemesoft.client.render.GraphicsHelper;
import maemesoft.entities.maeme.EntityMaeme;
import maemesoft.gui.ContainerEmpty;

public class GuiEvolve extends GuiContainer
{

	public EntityMaeme beginPixelmon, finishPixelmon;
	private String start, complete, cancel;

	public GuiEvolve(EntityMaeme start, EntityMaeme end)
	{
		super(new ContainerEmpty());
		beginPixelmon = start;
		finishPixelmon = end;
		this.start = "What? Your " + beginPixelmon.getNickname()
				+ " is evolving!";
		complete = "Congratulations, your " + beginPixelmon.getNickname() + " evolved into " + finishPixelmon.getNickname() + "!";
		cancel = "Huh? " + beginPixelmon.getNickname() + " stopped evolving!";
	}

	public void initGui()
	{
		super.initGui();
		buttonList.clear();
	}

	public void updateScreen()
	{
		GraphicsHelper.drawModelToScreen(1, 1, 1, mc.displayWidth / 2, mc.displayWidth / 2, beginPixelmon, this, true);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

	}
}