package _fearZ.mod.blocks.renderBlocks;

import org.lwjgl.opengl.GL11;

import _fearZ.mod.client.ClientProxy;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderRoad implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int meta, int modelID, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
		setRenderInInventory3D(0, 2, 0, 16, 4, 16, meta, renderer, block, tessellator);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		setrenderByPix(0, 0, 0, 16, 1, 16, renderer, block, x, y, z);
		
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
		return ClientProxy.renderRoadId;
	}
	
	public void setrenderByPix(int minX, int minY, int minZ, int maxX, int maxY, int maxZ, RenderBlocks renderer, Block block, int x, int y, int z)
	{
		renderer.setRenderBounds(minX*1/16f, minY*1/16f, minZ*1/16f, maxX*1/16f, maxY*1/16f, maxZ*1/16f);
		renderer.renderStandardBlock(block, x, y, z);
	}
	
	public void setRenderInInventory3D(int minX, int minY, int minZ, int maxX, int maxY, int maxZ, int meta, RenderBlocks renderer, Block block, Tessellator tessellator)
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
