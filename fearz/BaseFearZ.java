package FearZ;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "FearZ", name = "FearZ", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class BaseFearZ {
	
	@Instance("FearZ")
	public static DamageSource causeArrowDamage(EntityTilesCrossbow par0EntityArrow, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("tilesCrossbow", par0EntityArrow, par1Entity)).setProjectile();
    }
	public static BaseFearZ instance;
	public static Potion Fracture;
	public static Potion FractureOuverte;
	public static Potion Maladie;
	public static CreativeTabs FearzCreativeTabs = new FearzCreativeTabs(CreativeTabs.getNextID(), "FearZ");
	static EnumToolMaterial KnifeMat = net.minecraftforge.common.EnumHelper.addToolMaterial("KnifeMat", 2, 1561, 6.0F, 2.0F, 14);
	static EnumToolMaterial StonyMassMat = net.minecraftforge.common.EnumHelper.addToolMaterial("StonyMassMat", 2, 131, 6.0F, 1.0F, 14);
	
	
	//items
	public static Item Cachets = (new ItemCachet(4000)).setUnlocalizedName("Cachets").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:Cachets");
	public static Item Morphine = (new ItemMorphine(4001)).setUnlocalizedName("Morphine").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:Morphine");
	public static Item Bandage = (new ItemBandage(4002)).setUnlocalizedName("Bandage").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:Bandage");
	public static Item TilesCrossbow = (new Item(4006)).setUnlocalizedName("TilesCrossbow").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:TilesCrossbow");
	public static Item LittleBag = (new Item(4008)).setUnlocalizedName("LittleBag").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:LittleBag");
	public static Item BigBag = (new Item(4009)).setUnlocalizedName("BigBag").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:BigBag");
	public static Item HeadTorch = (new Item(4010)).setUnlocalizedName("HeadTorch").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:HeadTorch");
	public static Item Battery = (new Item(4011)).setUnlocalizedName("Battery").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:Battery");
	public static Item Gourd = (new ItemGourd(4012)).setUnlocalizedName("Gourd").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:Gourd");
	public static Item FilledGourd = (new Item(4013)).setUnlocalizedName("FilledGourd").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:FilledGourd");
	public static Item PurifiedGourd = (new ItemWater(4014, 0, false)).setUnlocalizedName("PurifiedGourd").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:PurifiedGourd");
	public static Item PurifiedBottle = (new ItemWater(4015, 0, false)).setUnlocalizedName("PurifiedBottle").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:PurifiedBottle");
	public static Item Knife = (new ItemSword(4016, KnifeMat)).setUnlocalizedName("Knife").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:Knife");
	public static Item StonyMass = (new ItemSword(4017, StonyMassMat)).setUnlocalizedName("StonyMass").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:StonyMass");
	public static Item CrossBow = (new ItemCrossBow(4018)).setUnlocalizedName("CrossBow").setCreativeTab(BaseFearZ.FearzCreativeTabs).setTextureName("fearz:CrossBow");
	public static Item MilkBucket;
	
	
	@EventHandler 
    public void initConfig(FMLPreInitializationEvent event) 
    { 
		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) {
		f.setAccessible(true);
		try {
		if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
		Field modfield = Field.class.getDeclaredField("modifiers");
		modfield.setAccessible(true);
		modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

		potionTypes = (Potion[])f.get(null);
		final Potion[] newPotionTypes = new Potion[256];
		System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
		f.set(null, newPotionTypes);
		}
		}
		catch (Exception e) {
		System.err.println("Severe error, please report this to the mod author:");
		System.err.println(e);
		}
		}

		MinecraftForge.EVENT_BUS.register(new FearZEventHooks());
		}
    
 
    @EventHandler 
    public void load(FMLInitializationEvent event) 
    { 
    	MinecraftForgeClient.registerItemRenderer(CrossBow.itemID, (IItemRenderer)new CrossBowRenderer());
    	RenderingRegistry.registerEntityRenderingHandler(EntityTilesCrossbow.class, new RenderTilesCrossBow());
    	Item.itemsList[Item.bucketMilk.itemID] = null;
    	   MilkBucket = new MilkBucket(79).setUnlocalizedName("milk").setContainerItem(Item.bucketEmpty).setTextureName("bucket_milk");
    	   GameRegistry.registerItem(MilkBucket, "Milk");
    	   Item.itemsList[Item.bucketMilk.itemID] = MilkBucket;
    	Fracture = (new Fracture(32, false, 0)).setIconIndex(0, 0).setPotionName("Fracture").func_111184_a(SharedMonsterAttributes.movementSpeed, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.45000000596046448D, 2);
    	FractureOuverte = (new Fracture(33, false, 0)).setIconIndex(0, 0).setPotionName("Fracture Ouverte").func_111184_a(SharedMonsterAttributes.movementSpeed, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.45000000596046448D, 2).func_111184_a(SharedMonsterAttributes.maxHealth, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", -6.0D, 0);
    	Maladie = (new Maladie(34, true, 0)).setIconIndex(0, 0).setPotionName("Maladie").func_111184_a(SharedMonsterAttributes.attackDamage, "22653B89-116E-49DC-9B6B-9971489B5BE5", 5.00D, 0);
         
    }
    
    
    @EventHandler 
    public void afterLoad(FMLPostInitializationEvent event) 
    {
    	//items
    	LanguageRegistry.addName(Cachets, "Cachets");
    	LanguageRegistry.addName(Morphine, "Morphine");
    	LanguageRegistry.addName(Bandage, "Bandage");
    	LanguageRegistry.addName(TilesCrossbow, "Tiles Crossbow");
    	LanguageRegistry.addName(LittleBag, "Little Bag");
    	LanguageRegistry.addName(BigBag, "Big Bag");
    	LanguageRegistry.addName(HeadTorch, "Head Torch");
    	LanguageRegistry.addName(Battery, "Battery");
    	LanguageRegistry.addName(Gourd, "Gourd");
    	LanguageRegistry.addName(FilledGourd, "Filled Gourd");
    	LanguageRegistry.addName(PurifiedGourd, "Purified Gourd");
    	LanguageRegistry.addName(PurifiedBottle, "Purified Bottle");
    	LanguageRegistry.addName(Knife, "Knife");
    	LanguageRegistry.addName(StonyMass, "Stony Mass");
    	LanguageRegistry.addName(CrossBow, "CrossBow");
    	
    	//crafts
    	GameRegistry.addRecipe(new ItemStack (StonyMass, 1, 0), new Object[]{"XXX", "XOX", " O ", 'X', Block.cobblestone, 'O', Item.stick});
    	GameRegistry.addRecipe(new ItemStack(TilesCrossbow, 8), new Object[] {"X", "#", "Y", 'Y', Item.feather, 'X', Item.ingotIron, '#', Item.stick});
    	GameRegistry.addRecipe(new ItemStack(CrossBow, 1), new Object[] {"XYO", "YX ", "O X", 'X', Block.planks, 'O', Item.silk, 'Y', Item.stick});
    	GameRegistry.addSmelting(BaseFearZ.FilledGourd.itemID, new ItemStack(PurifiedGourd, 1), 0.1f);
    }
}

