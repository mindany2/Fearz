package _fearZ.mod.tileentity.renderer;

import org.lwjgl.opengl.GL11;

import _fearZ.mod.blocks.model.ModelStereo;
import _fearZ.mod.tileentity.TileEntityStereo;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityStereoSpecialRender extends TileEntitySpecialRenderer implements IInventoryRenderer
{
	private final ModelStereo model = new ModelStereo();
	public static final ResourceLocation textureLocation = new ResourceLocation("fearz", "textures/blocks/stereo.png");
	
	public TileEntityStereoSpecialRender()
	{
		this.setTileEntityRenderer(TileEntityRenderer.instance);
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float tick)
	{
		this.renderTileEntityStereoAt((TileEntityStereo)te, x, y, z, tick);
	}

	@Override
	public void renderInventory(double x, double y, double z)
	{
		this.renderTileEntityStereoAt(null, x, y, z, 0.0F);
	}
	
	public void renderTileEntityStereoAt(TileEntityStereo te, double x, double y, double z, float tick)
	{
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5F, y + 1.5F, z + 0.5F);
		this.bindTexture(textureLocation);
		GL11.glRotatef(180.0F, -2000000.0F, 0.0F, 1.0F);
		if(te != null)
			GL11.glRotatef(90F * te.getDirection(), 0.0F, 1.0F, 0.0F);
		this.model.render(0.0625F);
		GL11.glPopMatrix();
	}
}
