package _fearZ.mod.blocks.renderBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import _fearZ.mod.Mod_FearZ;
import _fearZ.mod.blocks.BlockMailBox;
import _fearZ.mod.client.ClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderMailBox implements ISimpleBlockRenderingHandler
{
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{

	}
	
	
	@Override
	public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		int meta = blockAccess.getBlockMetadata(x, y, z);
				
		switch (meta)
		{
		case 0:
			setTexture(Mod_FearZ.mailBox, 0, 3, renderer);
			setRenderByPix(5, 0, 2, 11, 1, 14, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 5, renderer);
			setRenderByPix(5, 0, 14, 11, 7, 15, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 2, renderer);
			setRenderByPix(5, 0, 1, 11, 7, 2, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 4, renderer);
			setRenderByPix(6, 8, 1, 10, 9, 15, renderer, block, x, y, z, false);
			setRenderByPix(5, 7, 1, 11, 8, 15, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 0, renderer);
			setRenderByPix(4, 0, 1, 5, 7, 15, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 1, renderer);
			setRenderByPix(11, 0, 1, 12, 7, 15, renderer, block, x, y, z, false);
			setTexture(Block.cloth, 0, 14, renderer);
			setRenderByPix(12, 4, 11, 13, 8, 12, renderer, block, x, y, z, false);
			setRenderByPix(12, 8, 9, 13, 10, 12, renderer, block, x, y, z, true);
			break;
		case 1:
			setTexture(Mod_FearZ.mailBox, 0, 3, renderer);
			setRenderByPix(2, 0, 5, 14, 1, 11, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 2, renderer);
			setRenderByPix(14, 0, 5, 15, 7, 11, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 0, renderer);
			setRenderByPix(1, 0, 4, 15, 7, 5, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 1, renderer);
			setRenderByPix(1, 0, 11, 15, 7, 12, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 4, renderer);
			setRenderByPix(1, 7, 5, 15, 8, 11, renderer, block, x, y, z, false);
			setRenderByPix(1, 8, 6, 15, 9, 10, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 5, renderer);
			setRenderByPix(1, 0, 5, 2, 7, 11, renderer, block, x, y, z, false);
			setTexture(Block.cloth, 0, 14, renderer);
			setRenderByPix(4, 4, 12, 5, 8, 13, renderer, block, x, y, z, false);
			setRenderByPix(4, 8, 12, 7, 10, 13, renderer, block, x, y, z, true);
			break;
		case 2:
			setTexture(Mod_FearZ.mailBox, 0, 3, renderer);
			setRenderByPix(5, 0, 2, 11, 1, 14, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 2, renderer);
			setRenderByPix(5, 0, 14, 11, 7, 15, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 4, renderer);
			setRenderByPix(6, 8, 1, 10, 9, 15, renderer, block, x, y, z, false);
			setRenderByPix(5, 7, 1, 11, 8, 15, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 1, renderer);
			setRenderByPix(4, 0, 1, 5, 7, 15, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 0, renderer);
			setRenderByPix(11, 0, 1, 12, 7, 15, renderer, block, x, y, z, true);
			setTexture(Block.cloth, 0, 14, renderer);
			setRenderByPix(3, 4, 4, 4, 8, 5, renderer, block, x, y, z, false);
			setRenderByPix(3, 8, 4, 4, 10, 7, renderer, block, x, y, z, true);
			setTexture(Mod_FearZ.mailBox, 0, 5, renderer);
			setRenderByPix(5, 0, 1, 11, 7, 2, renderer, block, x, y, z, false);
			break;
		case 3:
			setTexture(Mod_FearZ.mailBox, 0, 3, renderer);
			setRenderByPix(2, 0, 5, 14, 1, 11, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 2, renderer);
			setRenderByPix(1, 0, 5, 2, 7, 11, renderer, block, x, y, z, false);	
			setTexture(Mod_FearZ.mailBox, 0, 0, renderer);
			setRenderByPix(1, 0, 4, 15, 7, 5, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 1, renderer);
			setRenderByPix(1, 0, 11, 15, 7, 12, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 4, renderer);
			setRenderByPix(1, 7, 5, 15, 8, 11, renderer, block, x, y, z, false);
			setRenderByPix(1, 8, 6, 15, 9, 10, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 5, renderer);
			setRenderByPix(14, 0, 5, 15, 7, 11, renderer, block, x, y, z, false);
			setTexture(Block.cloth, 0, 14, renderer);
			setRenderByPix(11, 4, 3, 12, 8, 4, renderer, block, x, y, z, false);
			setRenderByPix(9, 8, 3, 12, 10, 4, renderer, block, x, y, z, true);
			break;
			
		case 4:
			setTexture(Mod_FearZ.mailBox, 0, 3, renderer);
			setRenderByPix(5, 0, 2, 11, 1, 14, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 6, renderer);
			setRenderByPix(5, 0, 14, 11, 1, 21, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 2, renderer);
			setRenderByPix(5, 0, 1, 11, 7, 2, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 4, renderer);
			setRenderByPix(5, 7, 1, 11, 8, 15, renderer, block, x, y, z, false);
			setRenderByPix(6, 8, 1, 10, 9, 15, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 0, renderer);
			setRenderByPix(4, 0, 1, 5, 7, 15, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 1, renderer);
			setRenderByPix(11, 0, 1, 12, 7, 15, renderer, block, x, y, z, false);
			setTexture(Block.cloth, 0, 14, renderer);
			setRenderByPix(12, 4, 8, 13, 5, 12, renderer, block, x, y, z, false);
			setRenderByPix(12, 2, 6, 13, 5, 8, renderer, block, x, y, z, true);
			break;
		case 5:
			renderer.setOverrideBlockTexture(Mod_FearZ.mailBox.getIcon(0, 3));
			setTexture(Mod_FearZ.mailBox, 0, 3, renderer);
			setRenderByPix(2, 0, 5, 14, 1, 11, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 2, renderer);
			setRenderByPix(14, 0, 5, 15, 7, 11, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 0, renderer);
			setRenderByPix(1, 0, 4, 15, 7, 5, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 1, renderer);
			setRenderByPix(1, 0, 11, 15, 7, 12, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 4, renderer);
			setRenderByPix(1, 7, 5, 15, 8, 11, renderer, block, x, y, z, false);
			setRenderByPix(1, 8, 6, 15, 9, 10, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 7, renderer);
			setRenderByPix(-5, 0, 5, 2, 1, 11, renderer, block, x, y, z, false);
			setTexture(Block.cloth, 0, 14, renderer);
			setRenderByPix(4, 4, 12, 8, 5, 13, renderer, block, x, y, z, false);
			setRenderByPix(8, 2, 12, 10, 5, 13, renderer, block, x, y, z, true);
			break;
		case 6:
			setTexture(Mod_FearZ.mailBox, 0, 3, renderer);
			setRenderByPix(5, 0, 2, 11, 1, 14, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 2, renderer);
			setRenderByPix(5, 0, 14, 11, 7, 15, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 4, renderer);
			setRenderByPix(6, 8, 1, 10, 9, 15, renderer, block, x, y, z, false);
			setRenderByPix(5, 7, 1, 11, 8, 15, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 1, renderer);
			setRenderByPix(4, 0, 1, 5, 7, 15, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 0, renderer);
			setRenderByPix(11, 0, 1, 12, 7, 15, renderer, block, x, y, z, true);
			setTexture(Block.cloth, 0, 14, renderer);
			setRenderByPix(3, 4, 4, 4, 5, 8, renderer, block, x, y, z, false);
			setRenderByPix(3, 2, 8, 4, 5, 10, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 9, renderer);
			setRenderByPix(5, 0, -5, 11, 1, 2, renderer, block, x, y, z, true);
			break;
		case 7:
			setTexture(Mod_FearZ.mailBox, 0, 3, renderer);
			setRenderByPix(2, 0, 5, 14, 1, 11, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 2, renderer);
			setRenderByPix(1, 0, 5, 2, 7, 11, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 0, renderer);
			setRenderByPix(1, 0, 4, 15, 7, 5, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 1, renderer);
			setRenderByPix(1, 0, 11, 15, 7, 12, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 4, renderer);
			setRenderByPix(1, 7, 5, 15, 8, 11, renderer, block, x, y, z, false);
			setRenderByPix(1, 8, 6, 15, 9, 10, renderer, block, x, y, z, false);
			setTexture(Mod_FearZ.mailBox, 0, 8, renderer);
			setRenderByPix(14, 0, 5, 21, 1, 11, renderer, block, x, y, z, false);
			setTexture(Block.cloth, 0, 14, renderer);
			setRenderByPix(8, 4, 3, 12, 5, 4, renderer, block, x, y, z, false);
			setRenderByPix(6, 2, 3, 8, 5, 4, renderer, block, x, y, z, true);
			break;
		}
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
		return ClientProxy.renderMailBoxId;
	}

	public void setRenderByPix( int minX, int minY, int minZ, int maxX, int maxY, int maxZ, RenderBlocks renderer, Block block, int x, int y, int z, boolean clear)
	{
		renderer.setRenderBounds(minX*1/16f, minY*1/16f, minZ*1/16f, maxX*1/16f, maxY*1/16f, maxZ*1/16f);
		renderer.renderStandardBlock(block, x, y, z);
		if (clear)
			renderer.clearOverrideBlockTexture();
	}
	public void setTexture(Block b, int side, int meta, RenderBlocks renderer)
	{
		renderer.setOverrideBlockTexture(b.getIcon(side, meta));
	}
}
