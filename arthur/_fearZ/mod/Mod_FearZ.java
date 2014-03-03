package _fearZ.mod;

import org.lwjgl.util.glu.Registry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import _fearZ.mod.blocks.BlockBase;
import _fearZ.mod.blocks.BlockCampFire;
import _fearZ.mod.blocks.BlockGaziniere;
import _fearZ.mod.blocks.BlockMChest;
import _fearZ.mod.blocks.BlockMailBox;
import _fearZ.mod.blocks.BlockPharmacie;
import _fearZ.mod.blocks.BlockRoad;
import _fearZ.mod.blocks.BlockStereo;
import _fearZ.mod.blocks.BlockStick;
import _fearZ.mod.common.CommonProxy;
import _fearZ.mod.events.BlockEvents;
import _fearZ.mod.events.EntityEvents;
import _fearZ.mod.events.ItemEvents;
import _fearZ.mod.gui.handler.GuiHandler;
import _fearZ.mod.items.ItemMailBox;
import _fearZ.mod.tileentity.TileEntityArmoirePh;
import _fearZ.mod.tileentity.TileEntityMChest;
import _fearZ.mod.tileentity.TileEntityStereo;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
 
@Mod(modid = "fearz", name = "FearZ", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)


 
public class Mod_FearZ
{
        @Instance("fearz")
        public static Mod_FearZ modInstance;
        @SidedProxy(clientSide="_fearZ.mod.client.ClientProxy", serverSide="_fearZ.mod.common.CommonProxy")
        public static CommonProxy proxy;
        
        
        /**blocks*/
        public static Block armoirePh, mailBox, stick, road, stereo, gaziniere, militaryChest, campFire_off, campFire_on;
        
        
        /**Items*/
        public static Item mailBoxItem;
        
        /**Creative Tabs*/
        public static final CreativeTabs onglet = new OngletCreatif(CreativeTabs.getNextID(), "FearZ");
        
        
        
       
        @EventHandler
        public void PreInit(FMLPreInitializationEvent event)
        {
        	/**Blocks*/
        	armoirePh = new BlockPharmacie(1700).setBlockUnbreakable().setHardness(10000f).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("ArmoirePharmacie");
        	GameRegistry.registerBlock(armoirePh, "armoirePh");
        	
        	mailBox = new BlockMailBox(1701, Material.ground).setBlockUnbreakable().setHardness(10000f).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("MailBox");
        	GameRegistry.registerBlock(mailBox, "mailBox");
        	
        	stick = new BlockStick(1702, Material.ground).setBlockUnbreakable().setHardness(10000f).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Stick");
        	GameRegistry.registerBlock(stick, "stick");
        	
        	road = new BlockRoad(1703).setBlockUnbreakable().setHardness(10000F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("road");
        	GameRegistry.registerBlock(road, "road");
        	
        	stereo = new BlockStereo(1704).setBlockUnbreakable().setHardness(10000F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("stereo");
        	GameRegistry.registerBlock(stereo, "stereo");
        	
        	gaziniere = new BlockGaziniere(1705).setBlockUnbreakable().setHardness(10000F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("gaziniere");
        	GameRegistry.registerBlock(gaziniere, "gaziniere");
        	
        	militaryChest = new BlockMChest(1706).setBlockUnbreakable().setHardness(10000F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("militaryChest");
        	GameRegistry.registerBlock(militaryChest, "militaryChest");
        	
        	campFire_off = new BlockCampFire(1707).setBlockUnbreakable().setHardness(10000F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("campFire").setLightValue(0.0F);
        	campFire_on = new BlockCampFire(1708).setBlockUnbreakable().setHardness(10000F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("campFire").setLightValue(1.0F);
        	GameRegistry.registerBlock(campFire_off, "campFire_off");
        	GameRegistry.registerBlock(campFire_on, "campFire_on");
        	
        	/**Items*/
        	mailBoxItem = new ItemMailBox(1900).setCreativeTab(onglet).setUnlocalizedName("mailBox");
        	GameRegistry.registerItem(mailBoxItem, "mailBoxItem");
        	
        }
 
        @EventHandler
        public void Init(FMLInitializationEvent event)
        {	
        	/**Mobs*/
        	
        	/**Render*/
        	proxy.registerRender();
        	proxy.registerTileEntityRender();
        	
        	/**EventBuss*/
        	MinecraftForge.EVENT_BUS.register(new ItemEvents());
        	MinecraftForge.EVENT_BUS.register(new BlockEvents());
        	MinecraftForge.EVENT_BUS.register(new EntityEvents());
        	
        	/**NetWork*/
        	
        	/**Recipes*/
        	
        	/**TileEntityRegistry*/
        	GameRegistry.registerTileEntity(TileEntityArmoirePh.class, "pharmacie");
        	GameRegistry.registerTileEntity(TileEntityStereo.class, "stereo");
        	GameRegistry.registerTileEntity(TileEntityMChest.class, "TileEntityMChest");
        	
        	NetworkRegistry.instance().registerGuiHandler(this.modInstance, new GuiHandler());
        	
        }
        
        @EventHandler
    	public void PostInit(FMLPostInitializationEvent event)
    	{
        	/**Integration avec les autres mods*/
    	}
        public static void tester()
        {
        	System.out.println("test");
        }
        
        public static void tester(int a)
        {
        	System.out.println("test " + a);
        }
        
        public static void tester(String a)
        {
        	System.out.println("test " + a);
        }
}