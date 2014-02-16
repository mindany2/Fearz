package FearZ;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCachet extends Item {

	public ItemCachet(int par1) {
		super(par1);
		this.maxStackSize = 6;
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
	            par3EntityPlayer.removePotionEffect(BaseFearZ.Maladie.id);
	        }
	        
	        return par1ItemStack;

	    }


}
