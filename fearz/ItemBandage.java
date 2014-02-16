package fearz;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBandage extends Item {

	public ItemBandage(int par1) {
		super(par1);
		this.maxStackSize = 16;
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
	
	 public EnumAction getItemUseAction(ItemStack par1ItemStack)
	    {
	        return EnumAction.eat;
	    }
	 
	 public int getMaxItemUseDuration(ItemStack par1ItemStack)
	    {
	        return 32;
	    }
	 
	 public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        if (!par3EntityPlayer.capabilities.isCreativeMode)
	        {
	            --par1ItemStack.stackSize;
	        }
	        
	        if (!par2World.isRemote)
	        {
	            par3EntityPlayer.curePotionEffects(par1ItemStack);
	        }
	        
	        return par1ItemStack;

	    }

}