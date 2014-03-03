package _fearZ.mod.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import _fearZ.mod.Mod_FearZ;
import _fearZ.mod.blocks.renderBlocks.RenderCampFire;
import _fearZ.mod.blocks.renderBlocks.RenderGaziniere;
import _fearZ.mod.blocks.renderBlocks.RenderMailBox;
import _fearZ.mod.blocks.renderBlocks.RenderRoad;
import _fearZ.mod.blocks.renderBlocks.RenderStick;
import _fearZ.mod.common.CommonProxy;
import _fearZ.mod.tileentity.TileEntityArmoirePh;
import _fearZ.mod.tileentity.TileEntityStereo;
import _fearZ.mod.tileentity.renderer.TESRInventoryRenderer;
import _fearZ.mod.tileentity.renderer.TileEntityArmoirePhSpecialRender;
import _fearZ.mod.tileentity.renderer.TileEntityStereoSpecialRender;
import _fearZ.mod.tileentity.renderer.TESRInventoryRenderer.TESRIndex;
 
public class ClientProxy extends CommonProxy
{
	public static int renderInventoryTESRId;
	public static int renderStickId, renderMailBoxId, renderRoadId, renderGaziniereId, renderCampFireId;
	@Override
	public void registerRender()
	{
		renderInventoryTESRId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new TESRInventoryRenderer());
		
		renderStickId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(renderStickId, new RenderStick());
		
		renderMailBoxId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(renderMailBoxId, new RenderMailBox());
		
		renderRoadId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(renderRoadId, new RenderRoad());
		
		renderGaziniereId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(renderGaziniereId, new RenderGaziniere());
		
		renderCampFireId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(renderCampFireId, new RenderCampFire());
	}

	@Override
	public void registerTileEntityRender()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArmoirePh.class, new TileEntityArmoirePhSpecialRender());
		TESRInventoryRenderer.blockByTESR.put(new TESRIndex(Mod_FearZ.armoirePh, 0), new TileEntityArmoirePhSpecialRender());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStereo.class, new TileEntityStereoSpecialRender());
		TESRInventoryRenderer.blockByTESR.put(new TESRIndex(Mod_FearZ.stereo, 0), new TileEntityStereoSpecialRender());
		
		
	}
}