package FearZ;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MilkBucket extends ItemBucketMilk {

	public MilkBucket(int par1) {
		super(par1);

	}
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        return par1ItemStack.stackSize <= 0 ? new ItemStack(Item.bucketEmpty) : par1ItemStack;
    }

}
