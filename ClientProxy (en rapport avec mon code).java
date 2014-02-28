package Mod.FearZ.net;
     
    import cpw.mods.fml.client.registry.RenderingRegistry;
import Mod.FearZ.net.CommonProxy;
import Mod.FearZ.net.Renderer.RenderTable;

import net.minecraftforge.client.MinecraftForgeClient;
     
    public class ClientProxy extends CommonProxy
    {
    	public static int renderTableId;
    /**
    *  Ce proxy ne concerne que la partie "Client" du mod, il gère :
    *  - Les textures     
    *  - Les renders
    *  ...
    */
     
     	public void registerRender()

     	{
     		
     				renderTableId = RenderingRegistry.getNextAvailableRenderId();

     				RenderingRegistry.registerBlockHandler(renderTableId, new RenderTable());

     		 	}
     	
    }
