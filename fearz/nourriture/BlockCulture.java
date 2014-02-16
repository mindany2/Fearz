package fearz.nourriture;

import java.util.ArrayList;

import net.minecraft.block.BlockCarrot;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCulture extends BlockCarrot
{
	public static String[] type = new String[]{};
	private Icon[] IconArray;
	public static Item Graine,Recolte;
	public BlockCulture (int id,Item Graine,Item Recolte,String[] number)
	{
		super(id);
		BlockCulture.Graine=Graine;
		BlockCulture.Recolte=Recolte;
	type=number;
	}
	
        public Icon getIcon(int side, int metadata)
        {
           	return metadata < type.length && metadata >= 0 ? IconArray[metadata] : IconArray[0];
        }

        public void registerIcons(IconRegister iconregister)
	{
		IconArray = new Icon[type.length];

		for(int i = 0; i < type.length; i++)
		{
			IconArray[i] = iconregister.registerIcon("modnourriture:" + type[i]);
		}
	}
    
	protected int getSeedItem()
	{
		return Graine.itemID; // donne la graine
	}

	protected int getCropItem()
	{
		return Recolte.itemID; // donne la récolte
	}
	
	public int damageDropped(int metadata)
	{
		return metadata;
	}
	@Override
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
    }

    @Override 
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = super.getBlockDropped(world, x, y, z, metadata, fortune);

        if (metadata >= 7)
        {
            for (int n = 0; n < 3 + fortune; n++)
            {
                if (world.rand.nextInt(15) <= metadata)
                {
                    ret.add(new ItemStack(this.getCropItem(), 1, 0));
                }
            }
        }

        return ret;
    }
}