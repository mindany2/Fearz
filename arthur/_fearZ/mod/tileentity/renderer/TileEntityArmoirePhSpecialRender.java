package _fearZ.mod.tileentity.renderer;

import org.lwjgl.opengl.GL11;

import _fearZ.mod.blocks.model.ModelArmoirPh;
import _fearZ.mod.tileentity.TileEntityArmoirePh;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityArmoirePhSpecialRender extends TileEntitySpecialRenderer implements IInventoryRenderer
{
	private final ModelArmoirPh mdl = new ModelArmoirPh();
	public static final ResourceLocation texture = new ResourceLocation("fearz", "textures/blocks/ArmoirePharmacie.png");
	public TileEntityArmoirePhSpecialRender()
	{
		this.setTileEntityRenderer(TileEntityRenderer.instance);
	}

	@Override
	public void renderInventory(double x, double y, double z)
	{
		this.renderTileEntityArmoirePhAt(null, x, y, z, 0.0F);
	}
		
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f)
	{
		this.renderTileEntityArmoirePhAt((TileEntityArmoirePh)te, x, y, z, f);
	}

	public void renderTileEntityArmoirePhAt(TileEntityArmoirePh te, double x, double y, double z, float tick)
	{
		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5F, y + 1.5F, z + 0.5F);
		this.bindTexture(texture);
		
		GL11.glRotatef(180.0F, -2000000.0F, 0.0F, 1.0F);
		if(te != null)
		{
			GL11.glRotatef(90F * te.getDirection(), 0.0F, 1.0F, 0.0F);
		}
		
		if(te != null)
		{
			float angle = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * tick;
			angle = 1.0F - angle;
			angle = 1.0F - angle * angle * angle;
			this.mdl.porte1.rotateAngleY = (angle * (float)Math.PI / 2.0F);
			this.mdl.poignee1.rotateAngleY = (angle * (float)Math.PI / 2.0F);
			this.mdl.porte2.rotateAngleY = -(angle * (float)Math.PI / 2.0F);
			this.mdl.poignee2.rotateAngleY = -(angle * (float)Math.PI / 2.0F);
		}
		this.mdl.render(0.0625F);
		GL11.glPopMatrix();
	}
}
