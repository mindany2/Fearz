package _fearZ.mod.blocks.renderBlocks;

import _fearZ.mod.client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderStick implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		setrenderByPix(7, 0, 7, 9, 16, 9, renderer, block, x, y, z);
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
		return ClientProxy.renderStickId;
	}
	
	public void setrenderByPix( int minX, int minY, int minZ, int maxX, int maxY, int maxZ, RenderBlocks renderer, Block block, int x, int y, int z)
	{
		renderer.setRenderBounds(minX*1/16f, minY*1/16f, minZ*1/16f, maxX*1/16f, maxY*1/16f, maxZ*1/16f);
		renderer.renderStandardBlock(block, x, y, z);
	}
}
