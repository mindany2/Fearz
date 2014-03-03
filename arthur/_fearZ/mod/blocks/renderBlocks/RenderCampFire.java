package _fearZ.mod.blocks.renderBlocks;

import org.lwjgl.opengl.GL11;

import _fearZ.mod.client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderCampFire implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		setRenderByPix(1, 0, 2, 15, 2, 4, renderer, block, x, y, z, false);
		setRenderByPix(1, 0, 12, 15, 2, 14, renderer, block, x, y, z, false);
		setRenderByPix(2, 0, 1, 4, 2, 15, renderer, block, x, y, z, false);
		setRenderByPix(12, 0, 1, 14, 2, 15, renderer, block, x, y, z, false);
		setRenderByPix(2, 2, 5, 14, 4, 7, renderer, block, x, y, z, false);
		setRenderByPix(2, 2, 9, 14, 4, 11, renderer, block, x, y, z, false);
		setRenderByPix(5, 2, 2, 7, 4, 14, renderer, block, x, y, z, false);
		setRenderByPix(9, 2, 2, 11, 4, 14, renderer, block, x, y, z, false);
		setTexture(Block.coalBlock, 0, 0, renderer);
		setRenderByPix(4, 0, 4, 12, 0.1, 12, renderer, block, x, y, z, true);
		
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
		return ClientProxy.renderCampFireId;
	}
	
	public void setRenderByPix(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, RenderBlocks renderer, Block block, int x, int y, int z, boolean clear)
	{
		renderer.setRenderBounds((float)minX*1/16f, (float)minY*1/16f, (float)minZ*1/16f, (float)maxX*1/16f, (float)maxY*1/16f, (float)maxZ*1/16f);
		renderer.renderStandardBlock(block, x, y, z);
		if (clear)
			renderer.clearOverrideBlockTexture();
	}
	
	public void setRenderByPixAndOrienterManu(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, RenderBlocks renderer, Block block, int x, int y, int z, boolean clear, int orientation)
	{
		switch (orientation)
		{
		case 0:
			renderer.setRenderBounds((float)minX*1/16f, (float)minY*1/16f, (float)minZ*1/16f, (float)maxX*1/16f, (float)maxY*1/16f, (float)maxZ*1/16f);
			renderer.renderStandardBlock(block, x, y, z);
			if (clear)
				renderer.clearOverrideBlockTexture();
			break;
		case 1:
			renderer.setRenderBounds((float)(16-(minZ+(maxZ-minZ)))*(1/16f), (float)minY*1/16f, (float)minX*1/16f, (float)(16-minZ)*(1/16f), (float)maxY*1/16f, (float)maxX*1/16f);
			renderer.renderStandardBlock(block, x, y, z);
			if (clear)
				renderer.clearOverrideBlockTexture();
			break;
		case 2:
			renderer.setRenderBounds((float)minX*(1/16f), (float)minY*(1/16f), (float)(16-(minZ+(maxZ-minZ)))*(1/16f), (float)maxX*(1/16f), (float)maxY*(1/16f), (float)(16-minZ)*(1/16f));
			renderer.renderStandardBlock(block, x, y, z);
			if (clear)
				renderer.clearOverrideBlockTexture();
			break;
		case 3:
			renderer.setRenderBounds((float)minZ*1/16f, (float)minY*1/16f, (float)minX*1/16f, (float)maxZ*1/16f, (float)maxY*1/16f, (float)maxX*1/16f);
			renderer.renderStandardBlock(block, x, y, z);
			if (clear)
				renderer.clearOverrideBlockTexture();
			break;
		}
	}
	public void setRenderByPixAndOrienterAuto(IBlockAccess blockAccess, double minX, double minY, double minZ, double maxX, double maxY, double maxZ, RenderBlocks renderer, Block block, int x, int y, int z, boolean clear)
	{
		int orientation = blockAccess.getBlockMetadata(x, y, z);
		switch (orientation)
		{
		case 0:
			renderer.setRenderBounds((float)minX*1/16f, (float)minY*1/16f, (float)minZ*1/16f, (float)maxX*1/16f, (float)maxY*1/16f, (float)maxZ*1/16f);
			renderer.renderStandardBlock(block, x, y, z);
			if (clear)
				renderer.clearOverrideBlockTexture();
			break;
		case 1:
			renderer.setRenderBounds((float)(16-(minZ+(maxZ-minZ)))*(1/16f), (float)minY*1/16f, (float)minX*1/16f, (float)(16-minZ)*(1/16f), (float)maxY*1/16f, (float)maxX*1/16f);
			renderer.renderStandardBlock(block, x, y, z);
			if (clear)
				renderer.clearOverrideBlockTexture();
			break;
		case 2:
			renderer.setRenderBounds((float)minX*(1/16f), (float)minY*(1/16f), (float)(16-(minZ+(maxZ-minZ)))*(1/16f), (float)maxX*(1/16f), (float)maxY*(1/16f), (float)(16-minZ)*(1/16f));
			renderer.renderStandardBlock(block, x, y, z);
			if (clear)
				renderer.clearOverrideBlockTexture();
			break;
		case 3:
			renderer.setRenderBounds((float)minZ*1/16f, (float)minY*1/16f, (float)minX*1/16f, (float)maxZ*1/16f, (float)maxY*1/16f, (float)maxX*1/16f);
			renderer.renderStandardBlock(block, x, y, z);
			if (clear)
				renderer.clearOverrideBlockTexture();
			break;
		}
	}
	public void setTexture(Block b, int side, int meta, RenderBlocks renderer)
	{
		renderer.setOverrideBlockTexture(b.getIcon(side, meta));
	}
	
	public void setRenderInInventory3D(float minX, float minY, float minZ, float maxX, float maxY, float maxZ, int meta, RenderBlocks renderer, Block block, Tessellator tessellator)
	{
		renderer.setRenderBounds(minX*1/16f, minY*1/16f, minZ*1/16f, maxX*1/16f, maxY*1/16f, maxZ*1/16f);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0.0F, 0.0F);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, meta));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}
}
