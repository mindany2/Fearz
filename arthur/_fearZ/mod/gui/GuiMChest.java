package _fearZ.mod.gui;

import org.lwjgl.opengl.GL11;

import _fearZ.mod.containers.ContainerMChest;
import _fearZ.mod.tileentity.TileEntityMChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiMChest extends GuiContainer
{
	public static ResourceLocation texture = new ResourceLocation("textures/gui/container/generic_54.png");
	private TileEntityMChest bigChest;
	private IInventory playerInventory;
	public GuiMChest(InventoryPlayer inventory, TileEntityMChest tileEntity)
	{
		super(new ContainerMChest(inventory, tileEntity));
		this.bigChest = tileEntity;
		this.playerInventory = inventory;
		this.ySize = 230;
	}
	
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString(this.playerInventory.isInvNameLocalized() ? this.playerInventory.getInvName() : I18n.getString(this.playerInventory.getInvName()), 8, 129, 0);
        this.fontRenderer.drawString(this.bigChest.isInvNameLocalized() ? this.bigChest.getInvName() : I18n.getString(this.bigChest.getInvName()), 8, 7, 0);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
	}
}
