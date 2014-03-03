package _fearZ.mod.items;

import _fearZ.mod.Mod_FearZ;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class ItemMailBox extends Item
{

	public ItemMailBox(int par1)
	{
		super(par1);
		setTextureName("fearz:MailBox");
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        if (par7 != 1)
        {
            return false;
        }
        else if (player.canPlayerEdit(x, y, z, par7, itemStack) && player.canPlayerEdit(x, y + 1, z, par7, itemStack))
        {
            int i1 = world.getBlockId(x, y, z);
            
            if (world.getBlockId(x, y, z) == Block.fence.blockID && world.isAirBlock(x, y + 1, z))
            {
            	int direction = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
            	world.setBlock(x, y + 1, z, Mod_FearZ.mailBox.blockID);
            	world.setBlockMetadataWithNotify(x, y + 1, z, direction, 2);
            	--itemStack.stackSize;
            	return true;
            }
            else if (world.isAirBlock(x, y + 1, z) && world.isAirBlock(x, y + 2, z) && world.getBlockId(x, y, z) != 0)
            {
            	int direction = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
            	world.setBlock(x, y + 2, z, Mod_FearZ.mailBox.blockID);
                world.setBlock(x, y + 1, z, Mod_FearZ.stick.blockID);
            	world.setBlockMetadataWithNotify(x, y + 2, z, direction, 2);
                --itemStack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
	
}
