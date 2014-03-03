package _fearZ.mod;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import _fearZ.mod.ContainerArmoirePh;
import _fearZ.mod.tileentity.TileEntityArmoirePh;

public class GuiArmoirePh extends GuiContainer
{
	public static ResourceLocation texture = new ResourceLocation("fearz", "textures/gui/container/bigChest.png");
	private TileEntityArmoirePh armoirePh;
	private IInventory playerInventory;
	public GuiArmoirePh(InventoryPlayer inventory, TileEntityArmoirePh tileEntity)
	{
		super(new ContainerArmoirePh(inventory, tileEntity));
		this.armoirePh = tileEntity;
		this.playerInventory = inventory;
		this.ySize = 230;
	}
	
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString(this.playerInventory.isInvNameLocalized() ? this.playerInventory.getInvName() : I18n.getString(this.playerInventory.getInvName()), 8, 129, 0);
        this.fontRenderer.drawString(this.armoirePh.isInvNameLocalized() ? this.armoirePh.getInvName() : I18n.getString(this.armoirePh.getInvName()), 8, 7, 0);
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