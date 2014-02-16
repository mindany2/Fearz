package fearz;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;

public class FractureEffect extends PotionEffect
{

    private boolean isPotionDurationMax = true;
    private List<ItemStack> curativeItems;
	public FractureEffect(int par1, int par2) {
		super(par1, par2);

        this.curativeItems = new ArrayList<ItemStack>();
        this.curativeItems.remove(new ItemStack(Item.bucketMilk));
		// TODO Auto-generated constructor stub
	}
	 public FractureEffect(int par1, int par2, int par3)
	    {
	        super(par1, par2, par3);

	        this.curativeItems = new ArrayList<ItemStack>();
	        this.curativeItems.remove(new ItemStack(Item.bucketMilk));
	    }

}
