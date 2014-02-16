package FearZ;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemGourd extends Item 
{

	public ItemGourd(int par1) {
		super(par1);
	}
	
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);

        if (movingobjectposition == null)
        {
            return par1ItemStack;
        }
        else
        {
            if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
            {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;

                if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
                {
                    return par1ItemStack;
                }

                if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                {
                    return par1ItemStack;
                }

                if (par2World.getBlockMaterial(i, j, k) == Material.water)
                {
                    --par1ItemStack.stackSize;

                    if (par1ItemStack.stackSize <= 0)
                    {
                        return new ItemStack(BaseFearZ.FilledGourd);
                    }

                    if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(BaseFearZ.FilledGourd)))
                    {
                        par3EntityPlayer.dropPlayerItem(new ItemStack(BaseFearZ.FilledGourd.itemID, 1, 0));
                    }
                }
            }

            return par1ItemStack;
        }
    }
}