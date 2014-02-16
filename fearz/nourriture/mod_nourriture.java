package fearz.nourriture;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "ModNourriture", name = "Mod Nourriture +", version = "1.0.0", acceptedMinecraftVersions = "[1.6.2,)")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class mod_nourriture 
{
//	@SidedProxy(clientSide = "tutoriel.proxy.TutoClientProxy", serverSide = "tutoriel.proxy.TutoCommonProxy")
//	public static TutoCommonProxy proxy;
	
	@Instance("ModTutoriel")
	public static mod_nourriture instance;
	int i = 1000 ;
	public static Item saladecomposee;
	public static Item fraise,radis,choux,salade;
	public static Block fraisec,radisc,chouxc,saladec;
	public static Item fraiseg,radisg,chouxg,saladeg;
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		//Configuration
		
		//Blocks
		//Plantation
		fraisec = new BlockCulture(i++, fraiseg, fraise, new String[]{"Culture d'orge_0", "Culture d'orge_1", "Culture d'orge_2", "Culture d'orge_3", "Culture d'orge_4", "Culture d'orge_5"}).setUnlocalizedName("Culture d'orge");
		fraise = new ItemFoodMod(i++, 2, 0.1F, false,64).setUnlocalizedName("fraise").setTextureName("modnourriture:Itemfraise");
		fraiseg = new ItemSeeds(i++, this.fraisec.blockID, Block.tilledField.blockID).setUnlocalizedName("Graines d'orge").setTextureName("modnourriture:ItemOrgeGraines");
		radisc = new BlockCulture(i++, radisg, radis, new String[]{"Culture d'orge_0", "Culture d'orge_1", "Culture d'orge_2", "Culture d'orge_3", "Culture d'orge_4", "Culture d'orge_5"}).setUnlocalizedName("Culture d'orge");
		radis = new ItemFoodMod(i++, 2, 0.1F, false,64).setUnlocalizedName("radis").setTextureName("modnourriture:Itemradis");
		radisg = new ItemSeeds(i++, this.radisc.blockID, Block.tilledField.blockID).setUnlocalizedName("Graines d'orge").setTextureName("modnourriture:ItemOrgeGraines");
		chouxc = new BlockCulture(i++, chouxg, choux, new String[]{"Culture d'orge_0", "Culture d'orge_1", "Culture d'orge_2", "Culture d'orge_3", "Culture d'orge_4", "Culture d'orge_5"}).setUnlocalizedName("Culture d'orge");
		choux = new ItemFoodMod(i++, 4, 0.2F, false,64).setUnlocalizedName("choux").setTextureName("modnourriture:Itemchoux");
		chouxg = new ItemSeeds(i++, this.chouxc.blockID, Block.tilledField.blockID).setUnlocalizedName("Graines d'orge").setTextureName("modnourriture:ItemOrgeGraines");
		saladec = new BlockCulture(i++, saladeg, salade, new String[]{"Culture d'orge_0", "Culture d'orge_1", "Culture d'orge_2", "Culture d'orge_3", "Culture d'orge_4", "Culture d'orge_5"}).setUnlocalizedName("Culture d'orge");
		salade = new ItemFoodMod(i++, 4, 0.2F, false,64).setUnlocalizedName("salade").setTextureName("modnourriture:Itemsalade");
		saladeg = new ItemSeeds(i++, this.saladec.blockID, Block.tilledField.blockID).setUnlocalizedName("saladeg").setTextureName("modnourriture:Itemsaladeg");
		//Items
		saladecomposee = (new ItemFoodMod(i++, 12, 0.6F, false,16)).setUnlocalizedName("saladecomposee").setTextureName("modnourriture:saladecomposee");
		//Achievements
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		//Registry
		GameRegistry.registerBlock(fraisec);
		GameRegistry.registerBlock(radisc);
		GameRegistry.registerBlock(chouxc);
		GameRegistry.registerBlock(saladec);
		
		//Mobs
		
		//Render
//		proxy.registerRender();
		//NetWork

		//Recipe
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		//Intégration avec les autres mods

	}
}