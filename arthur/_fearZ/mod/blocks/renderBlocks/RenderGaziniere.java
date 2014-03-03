package _fearZ.mod.blocks.renderBlocks;

import org.lwjgl.opengl.GL11;

import _fearZ.mod.Mod_FearZ;
import _fearZ.mod.client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderGaziniere implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		
		Tessellator tessellator = Tessellator.instance;
		//vitre
		setTexture(Mod_FearZ.gaziniere, 0, 3, renderer);
		setRenderInInventory3D(4f, 4f, 14f, 12f, 8f, 14.25f, metadata, renderer, block, tessellator);
		//poignee
		setTexture(Mod_FearZ.gaziniere, 0, 2, renderer);
		setRenderInInventory3D(6f, 9f, 14.5f, 10f, 10f, 15.3f, metadata, renderer, block, tessellator);
		//porte
		setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
		setRenderInInventory3D(1f, 8f, 14f, 15f, 11f, 14.5f, metadata, renderer, block, tessellator);
		setRenderInInventory3D(1f, 4f, 14f, 4f, 8f, 14.5f, metadata, renderer, block, tessellator);
		setRenderInInventory3D(12f, 4f, 14f, 15f, 8f, 14.5f, metadata, renderer, block, tessellator);
		setRenderInInventory3D(1f, 1f, 14f, 15f, 4f, 14.5f, metadata, renderer, block, tessellator);
		//boutons
		setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
		setRenderInInventory3D(7.5f, 12f, 14f, 8.5f, 13f, 14.7f, metadata, renderer, block, tessellator);
		setRenderInInventory3D(2f, 12f, 14f, 3f, 13f, 14.7f, metadata, renderer, block, tessellator);
		setRenderInInventory3D(4f, 12f, 14f, 5f, 13f, 14.7f, metadata, renderer, block, tessellator);
		setRenderInInventory3D(11f, 12f, 14f, 12f, 13f, 14.7f, metadata, renderer, block, tessellator);
		setRenderInInventory3D(13f, 12f, 14f, 14f, 13f, 14.7f, metadata, renderer, block, tessellator);
		//plaques
		setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
		setRenderInInventory3D(3f, 14f, 3f, 5f, 14.5f, 5f, metadata, renderer, block, tessellator);
		setRenderInInventory3D(3f, 14f, 11f, 5f, 14.5f, 13f, metadata, renderer, block, tessellator);
		setRenderInInventory3D(11f, 14f, 3f, 13f, 14.5f, 5f, metadata, renderer, block, tessellator);
		setRenderInInventory3D(11f, 14f, 11f, 13f, 14.5f, 13f, metadata, renderer, block, tessellator);
		setRenderInInventory3D(6.5f, 14f, 6.5f, 9.5f, 14.5f, 9.5f, metadata, renderer, block, tessellator);
		//bordures
		setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
		setRenderInInventory3D(0f, 14f, 1f, 1f, 14.7f, 14f, metadata, renderer, block, tessellator);
		setRenderInInventory3D(15f, 14f, 1f, 16f, 14.7f, 14f, metadata, renderer, block, tessellator);
		//bordure arriere
		setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
		setRenderInInventory3D(0f, 14f, 0f, 16f, 16f, 1f, metadata, renderer, block, tessellator);
		//corps
		setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
		setRenderInInventory3D(0f, 0f, 0f, 16f, 14f, 14f, metadata, renderer, block, tessellator);
		renderer.clearOverrideBlockTexture();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		int meta = blockAccess.getBlockMetadata(x, y, z);
		
		switch (meta)
		{
		case 0:
			//vitre
			setTexture(Mod_FearZ.gaziniere, 0, 3, renderer);
			setRenderByPixAndOrienterManu(4, 4, 14, 12, 8, 14.25, renderer, block, x, y, z, true, meta);
			//poignee
			setTexture(Mod_FearZ.gaziniere, 0, 2, renderer);
			setRenderByPixAndOrienterManu(6, 9, 14.5, 10, 10, 15.3, renderer, block, x, y, z, true, meta);
			//porte
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(1, 8, 14, 15, 11, 14.5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(1, 4, 14, 4, 8, 14.5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(12, 4, 14, 15, 8, 14.5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(1, 1, 14, 15, 4, 14.5, renderer, block, x, y, z, true, meta);
			//boutons
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(7.5, 12, 14, 8.5, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(2, 12, 14, 3, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(4, 12, 14, 5, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(11, 12, 14, 12, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(13, 12, 14, 14, 13, 14.7, renderer, block, x, y, z, true, meta);
			//plaques
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(3, 14, 3, 5, 14.5, 5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(3, 14, 11, 5, 14.5, 13, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(11, 14, 3, 13, 14.5, 5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(11, 14, 11, 13, 14.5, 13, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(6.5, 14, 6.5, 9.5, 14.5, 9.5, renderer, block, x, y, z, true, meta);
			//bordures
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 1, 1, 14.7, 14, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(15, 14, 1, 16, 14.7, 14, renderer, block, x, y, z, true, meta);
			//bordure arriere
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 0, 16, 16, 1, renderer, block, x, y, z, true, meta);
			//corps
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 0, 0, 16, 14, 14, renderer, block, x, y, z, true, meta);
			break;
		case 1:
			//vitre
			setTexture(Mod_FearZ.gaziniere, 0, 3, renderer);
			setRenderByPixAndOrienterManu(4, 4, 14, 12, 8, 14.25, renderer, block, x, y, z, true, meta);
			//poignee
			setTexture(Mod_FearZ.gaziniere, 0, 2, renderer);
			setRenderByPixAndOrienterManu(6, 9, 14.5, 10, 10, 15.3, renderer, block, x, y, z, true, meta);
			//porte
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(1, 8, 14, 15, 11, 14.5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(1, 4, 14, 4, 8, 14.5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(12, 4, 14, 15, 8, 14.5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(1, 1, 14, 15, 4, 14.5, renderer, block, x, y, z, true, meta);
			//boutons
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(7.5, 12, 14, 8.5, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(2, 12, 14, 3, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(4, 12, 14, 5, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(11, 12, 14, 12, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(13, 12, 14, 14, 13, 14.7, renderer, block, x, y, z, true, meta);
			//plaques
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(3, 14, 3, 5, 14.5, 5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(3, 14, 11, 5, 14.5, 13, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(11, 14, 3, 13, 14.5, 5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(11, 14, 11, 13, 14.5, 13, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(6.5, 14, 6.5, 9.5, 14.5, 9.5, renderer, block, x, y, z, true, meta);
			//bordures
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 1, 1, 14.7, 14, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(15, 14, 1, 16, 14.7, 14, renderer, block, x, y, z, true, meta);
			//bordure arriere
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 0, 16, 16, 1, renderer, block, x, y, z, true, meta);
			//corps
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 0, 0, 16, 14, 14, renderer, block, x, y, z, true, meta);
			break;
		case 2:
			//vitre
			setTexture(Mod_FearZ.gaziniere, 0, 3, renderer);
			setRenderByPixAndOrienterManu(4, 4, 14, 12, 8, 14.25, renderer, block, x, y, z, true, meta);
			//poignee
			setTexture(Mod_FearZ.gaziniere, 0, 2, renderer);
			setRenderByPixAndOrienterManu(6, 9, 14.5, 10, 10, 15.3, renderer, block, x, y, z, true, meta);
			//porte
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(1, 8, 14, 15, 11, 14.5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(1, 4, 14, 4, 8, 14.5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(12, 4, 14, 15, 8, 14.5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(1, 1, 14, 15, 4, 14.5, renderer, block, x, y, z, true, meta);
			//boutons
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(7.5, 12, 14, 8.5, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(2, 12, 14, 3, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(4, 12, 14, 5, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(11, 12, 14, 12, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(13, 12, 14, 14, 13, 14.7, renderer, block, x, y, z, true, meta);
			//plaques
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(3, 14, 3, 5, 14.5, 5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(3, 14, 11, 5, 14.5, 13, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(11, 14, 3, 13, 14.5, 5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(11, 14, 11, 13, 14.5, 13, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(6.5, 14, 6.5, 9.5, 14.5, 9.5, renderer, block, x, y, z, true, meta);
			//bordures
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 1, 1, 14.7, 14, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(15, 14, 1, 16, 14.7, 14, renderer, block, x, y, z, true, meta);
			//bordure arriere
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 0, 16, 16, 1, renderer, block, x, y, z, true, meta);
			//corps
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 0, 0, 16, 14, 14, renderer, block, x, y, z, true, meta);
			break;
		case 3:
			//vitre
			setTexture(Mod_FearZ.gaziniere, 0, 3, renderer);
			setRenderByPixAndOrienterManu(4, 4, 14, 12, 8, 14.25, renderer, block, x, y, z, true, meta);
			//poignee
			setTexture(Mod_FearZ.gaziniere, 0, 2, renderer);
			setRenderByPixAndOrienterManu(6, 9, 14.5, 10, 10, 15.3, renderer, block, x, y, z, true, meta);
			//porte
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(1, 8, 14, 15, 11, 14.5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(1, 4, 14, 4, 8, 14.5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(12, 4, 14, 15, 8, 14.5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(1, 1, 14, 15, 4, 14.5, renderer, block, x, y, z, true, meta);
			//boutons
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(7.5, 12, 14, 8.5, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(2, 12, 14, 3, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(4, 12, 14, 5, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(11, 12, 14, 12, 13, 14.7, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(13, 12, 14, 14, 13, 14.7, renderer, block, x, y, z, true, meta);
			//plaques
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(3, 14, 3, 5, 14.5, 5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(3, 14, 11, 5, 14.5, 13, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(11, 14, 3, 13, 14.5, 5, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(11, 14, 11, 13, 14.5, 13, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(6.5, 14, 6.5, 9.5, 14.5, 9.5, renderer, block, x, y, z, true, meta);
			//bordures
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 1, 1, 14.7, 14, renderer, block, x, y, z, false, meta);
			setRenderByPixAndOrienterManu(15, 14, 1, 16, 14.7, 14, renderer, block, x, y, z, true, meta);
			//bordure arriere
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 0, 16, 16, 1, renderer, block, x, y, z, true, meta);
			//corps
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 0, 0, 16, 14, 14, renderer, block, x, y, z, true, meta);
			break;
			
			
			
		case 4:
			//vitre
			setTexture(Mod_FearZ.gaziniere, 0, 4, renderer);
			setRenderByPixAndOrienterManu(4, 4, 14, 12, 8, 14.25, renderer, block, x, y, z, true, 0);
			//poignee
			setTexture(Mod_FearZ.gaziniere, 0, 2, renderer);
			setRenderByPixAndOrienterManu(6, 9, 14.5, 10, 10, 15.3, renderer, block, x, y, z, true, 0);
			//porte
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(1, 8, 14, 15, 11, 14.5, renderer, block, x, y, z, false, 0);
			setRenderByPixAndOrienterManu(1, 4, 14, 4, 8, 14.5, renderer, block, x, y, z, false, 0);
			setRenderByPixAndOrienterManu(12, 4, 14, 15, 8, 14.5, renderer, block, x, y, z, false, 0);
			setRenderByPixAndOrienterManu(1, 1, 14, 15, 4, 14.5, renderer, block, x, y, z, true, 0);
			//boutons
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(7.5, 12, 14, 8.5, 13, 14.7, renderer, block, x, y, z, false, 0);
			setRenderByPixAndOrienterManu(2, 12, 14, 3, 13, 14.7, renderer, block, x, y, z, false, 0);
			setRenderByPixAndOrienterManu(4, 12, 14, 5, 13, 14.7, renderer, block, x, y, z, false, 0);
			setRenderByPixAndOrienterManu(11, 12, 14, 12, 13, 14.7, renderer, block, x, y, z, false, 0);
			setRenderByPixAndOrienterManu(13, 12, 14, 14, 13, 14.7, renderer, block, x, y, z, true, 0);
			//plaques
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(3, 14, 3, 5, 14.5, 5, renderer, block, x, y, z, false, 0);
			setRenderByPixAndOrienterManu(3, 14, 11, 5, 14.5, 13, renderer, block, x, y, z, false, 0);
			setRenderByPixAndOrienterManu(11, 14, 3, 13, 14.5, 5, renderer, block, x, y, z, false, 0);
			setRenderByPixAndOrienterManu(11, 14, 11, 13, 14.5, 13, renderer, block, x, y, z, false, 0);
			setRenderByPixAndOrienterManu(6.5, 14, 6.5, 9.5, 14.5, 9.5, renderer, block, x, y, z, true, 0);
			//bordures
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 1, 1, 14.7, 14, renderer, block, x, y, z, false, 0);
			setRenderByPixAndOrienterManu(15, 14, 1, 16, 14.7, 14, renderer, block, x, y, z, true, 0);
			//bordure arriere
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 0, 16, 16, 1, renderer, block, x, y, z, true, 0);
			//corps
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 0, 0, 16, 14, 14, renderer, block, x, y, z, true, 0);
			break;
		case 5:
			//vitre
			setTexture(Mod_FearZ.gaziniere, 0, 4, renderer);
			setRenderByPixAndOrienterManu(4, 4, 14, 12, 8, 14.25, renderer, block, x, y, z, true, 1);
			//poignee
			setTexture(Mod_FearZ.gaziniere, 0, 2, renderer);
			setRenderByPixAndOrienterManu(6, 9, 14.5, 10, 10, 15.3, renderer, block, x, y, z, true, 1);
			//porte
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(1, 8, 14, 15, 11, 14.5, renderer, block, x, y, z, false, 1);
			setRenderByPixAndOrienterManu(1, 4, 14, 4, 8, 14.5, renderer, block, x, y, z, false, 1);
			setRenderByPixAndOrienterManu(12, 4, 14, 15, 8, 14.5, renderer, block, x, y, z, false, 1);
			setRenderByPixAndOrienterManu(1, 1, 14, 15, 4, 14.5, renderer, block, x, y, z, true, 1);
			//boutons
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(7.5, 12, 14, 8.5, 13, 14.7, renderer, block, x, y, z, false, 1);
			setRenderByPixAndOrienterManu(2, 12, 14, 3, 13, 14.7, renderer, block, x, y, z, false, 1);
			setRenderByPixAndOrienterManu(4, 12, 14, 5, 13, 14.7, renderer, block, x, y, z, false, 1);
			setRenderByPixAndOrienterManu(11, 12, 14, 12, 13, 14.7, renderer, block, x, y, z, false, 1);
			setRenderByPixAndOrienterManu(13, 12, 14, 14, 13, 14.7, renderer, block, x, y, z, true, 1);
			//plaques
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(3, 14, 3, 5, 14.5, 5, renderer, block, x, y, z, false, 1);
			setRenderByPixAndOrienterManu(3, 14, 11, 5, 14.5, 13, renderer, block, x, y, z, false, 1);
			setRenderByPixAndOrienterManu(11, 14, 3, 13, 14.5, 5, renderer, block, x, y, z, false, 1);
			setRenderByPixAndOrienterManu(11, 14, 11, 13, 14.5, 13, renderer, block, x, y, z, false, 1);
			setRenderByPixAndOrienterManu(6.5, 14, 6.5, 9.5, 14.5, 9.5, renderer, block, x, y, z, true, 1);
			//bordures
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 1, 1, 14.7, 14, renderer, block, x, y, z, false, 1);
			setRenderByPixAndOrienterManu(15, 14, 1, 16, 14.7, 14, renderer, block, x, y, z, true, 1);
			//bordure arriere
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 0, 16, 16, 1, renderer, block, x, y, z, true, 1);
			//corps
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 0, 0, 16, 14, 14, renderer, block, x, y, z, true, 1);
			break;
		case 6:
			//vitre
			setTexture(Mod_FearZ.gaziniere, 0, 4, renderer);
			setRenderByPixAndOrienterManu(4, 4, 14, 12, 8, 14.25, renderer, block, x, y, z, true, 2);
			//poignee
			setTexture(Mod_FearZ.gaziniere, 0, 2, renderer);
			setRenderByPixAndOrienterManu(6, 9, 14.5, 10, 10, 15.3, renderer, block, x, y, z, true, 2);
			//porte
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(1, 8, 14, 15, 11, 14.5, renderer, block, x, y, z, false, 2);
			setRenderByPixAndOrienterManu(1, 4, 14, 4, 8, 14.5, renderer, block, x, y, z, false, 2);
			setRenderByPixAndOrienterManu(12, 4, 14, 15, 8, 14.5, renderer, block, x, y, z, false, 2);
			setRenderByPixAndOrienterManu(1, 1, 14, 15, 4, 14.5, renderer, block, x, y, z, true, 2);
			//boutons
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(7.5, 12, 14, 8.5, 13, 14.7, renderer, block, x, y, z, false, 2);
			setRenderByPixAndOrienterManu(2, 12, 14, 3, 13, 14.7, renderer, block, x, y, z, false, 2);
			setRenderByPixAndOrienterManu(4, 12, 14, 5, 13, 14.7, renderer, block, x, y, z, false, 2);
			setRenderByPixAndOrienterManu(11, 12, 14, 12, 13, 14.7, renderer, block, x, y, z, false, 2);
			setRenderByPixAndOrienterManu(13, 12, 14, 14, 13, 14.7, renderer, block, x, y, z, true, 2);
			//plaques
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(3, 14, 3, 5, 14.5, 5, renderer, block, x, y, z, false, 2);
			setRenderByPixAndOrienterManu(3, 14, 11, 5, 14.5, 13, renderer, block, x, y, z, false, 2);
			setRenderByPixAndOrienterManu(11, 14, 3, 13, 14.5, 5, renderer, block, x, y, z, false, 2);
			setRenderByPixAndOrienterManu(11, 14, 11, 13, 14.5, 13, renderer, block, x, y, z, false, 2);
			setRenderByPixAndOrienterManu(6.5, 14, 6.5, 9.5, 14.5, 9.5, renderer, block, x, y, z, true, 2);
			//bordures
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 1, 1, 14.7, 14, renderer, block, x, y, z, false, 2);
			setRenderByPixAndOrienterManu(15, 14, 1, 16, 14.7, 14, renderer, block, x, y, z, true, 2);
			//bordure arriere
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 0, 16, 16, 1, renderer, block, x, y, z, true, 2);
			//corps
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 0, 0, 16, 14, 14, renderer, block, x, y, z, true, 2);
			break;
		case 7:
			//vitre
			setTexture(Mod_FearZ.gaziniere, 0, 4, renderer);
			setRenderByPixAndOrienterManu(4, 4, 14, 12, 8, 14.25, renderer, block, x, y, z, true, 3);
			//poignee
			setTexture(Mod_FearZ.gaziniere, 0, 2, renderer);
			setRenderByPixAndOrienterManu(6, 9, 14.5, 10, 10, 15.3, renderer, block, x, y, z, true, 3);
			//porte
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(1, 8, 14, 15, 11, 14.5, renderer, block, x, y, z, false, 3);
			setRenderByPixAndOrienterManu(1, 4, 14, 4, 8, 14.5, renderer, block, x, y, z, false, 3);
			setRenderByPixAndOrienterManu(12, 4, 14, 15, 8, 14.5, renderer, block, x, y, z, false, 3);
			setRenderByPixAndOrienterManu(1, 1, 14, 15, 4, 14.5, renderer, block, x, y, z, true, 3);
			//boutons
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(7.5, 12, 14, 8.5, 13, 14.7, renderer, block, x, y, z, false, 3);
			setRenderByPixAndOrienterManu(2, 12, 14, 3, 13, 14.7, renderer, block, x, y, z, false, 3);
			setRenderByPixAndOrienterManu(4, 12, 14, 5, 13, 14.7, renderer, block, x, y, z, false, 3);
			setRenderByPixAndOrienterManu(11, 12, 14, 12, 13, 14.7, renderer, block, x, y, z, false, 3);
			setRenderByPixAndOrienterManu(13, 12, 14, 14, 13, 14.7, renderer, block, x, y, z, true, 3);
			//plaques
			setTexture(Mod_FearZ.gaziniere, 0, 1, renderer);
			setRenderByPixAndOrienterManu(3, 14, 3, 5, 14.5, 5, renderer, block, x, y, z, false, 3);
			setRenderByPixAndOrienterManu(3, 14, 11, 5, 14.5, 13, renderer, block, x, y, z, false, 3);
			setRenderByPixAndOrienterManu(11, 14, 3, 13, 14.5, 5, renderer, block, x, y, z, false, 3);
			setRenderByPixAndOrienterManu(11, 14, 11, 13, 14.5, 13, renderer, block, x, y, z, false, 3);
			setRenderByPixAndOrienterManu(6.5, 14, 6.5, 9.5, 14.5, 9.5, renderer, block, x, y, z, true, 3);
			//bordures
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 1, 1, 14.7, 14, renderer, block, x, y, z, false, 3);
			setRenderByPixAndOrienterManu(15, 14, 1, 16, 14.7, 14, renderer, block, x, y, z, true, 3);
			//bordure arriere
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 14, 0, 16, 16, 1, renderer, block, x, y, z, true, 3);
			//corps
			setTexture(Mod_FearZ.gaziniere, 0, 0, renderer);
			setRenderByPixAndOrienterManu(0, 0, 0, 16, 14, 14, renderer, block, x, y, z, true, 3);
			renderer.clearOverrideBlockTexture();
			break;
		}
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
		return ClientProxy.renderGaziniereId;
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
