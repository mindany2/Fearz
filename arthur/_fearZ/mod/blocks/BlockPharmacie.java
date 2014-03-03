package _fearZ.mod.blocks;

import java.util.List;


import _fearZ.mod.Mod_FearZ;
import _fearZ.mod.blocks.model.ModelArmoirPh;
import _fearZ.mod.client.ClientProxy;
import _fearZ.mod.tileentity.TileEntityArmoirePh;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPharmacie extends BlockContainer
{
	private double angle = 0;
	public BlockPharmacie(int id)
	{
		super(id, Material.rock);
		this.setCreativeTab(Mod_FearZ.onglet);
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return null;
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TileEntityArmoirePh();
	}

	public boolean hasTileEntity(int metadata)
	{
		return true;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderType()
	{
		return ClientProxy.renderInventoryTESRId;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		FMLNetworkHandler.openGui(player, Mod_FearZ.modInstance, 0, world, x, y, z);
		return true;
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
    	TileEntity te = world.getBlockTileEntity(x, y, z);
    	if(te != null && te instanceof TileEntityArmoirePh)
    	{
    		((TileEntityArmoirePh)te).setDirection((byte)direction);
    		world.markBlockForUpdate(x, y, z);
    	}
    }
	
	public void breakBlock(World world, int x, int y, int z, int side, int metadata)
    {
		dropContainerItem(world, x, y, z);
		super.breakBlock(world, x, y, z, side, metadata);
    }
	
	protected void dropContainerItem(World world, int x, int y, int z)
    {
    	TileEntityArmoirePh pharmacie = (TileEntityArmoirePh)world.getBlockTileEntity(x, y, z);

        if (pharmacie != null)
        {
            for (int slotId = 0; slotId < pharmacie.getSizeInventory(); slotId++)
            {
                ItemStack stack = pharmacie.getStackInSlot(slotId);

                if (stack != null)
                {
                    float f = world.rand.nextFloat() * 0.8F + 0.1F;
                    float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for (float f2 = world.rand.nextFloat() * 0.8F + 0.1F; stack.stackSize > 0; world.spawnEntityInWorld(entityitem))
                    {
                        int k1 = world.rand.nextInt(21) + 10;

                        if (k1 > stack.stackSize)
                        {
                            k1 = stack.stackSize;
                        }

                        stack.stackSize -= k1;
                        entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(stack.itemID, k1, stack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)world.rand.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)world.rand.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)world.rand.nextGaussian() * f3);

                        if (stack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)stack.getTagCompound().copy());
                        }
                    }
                }
            }
        }
    }
	
	public boolean onBlockEventReceived(World world, int x, int y, int z, int eventId, int eventValue)
    {
        TileEntity tileentity = world.getBlockTileEntity(x, y, z);
        return tileentity != null ? tileentity.receiveClientEvent(eventId, eventValue) : false;
    }
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
	{
		TileEntity te = blockAccess.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityArmoirePh)
		{
			if (((TileEntityArmoirePh)te).getDirection() == 0)
			{
				this.setBlockBounds(0.0F, 0.19F, 0.0F, 1.0F, 0.81F, 0.368F);
			}
			
			else if (((TileEntityArmoirePh)te).getDirection() == 1)
			{
				this.setBlockBounds(0.625F, 0.19F, 0.0F, 1.0F, 0.81F, 1.0F);
			}
			else if (((TileEntityArmoirePh)te).getDirection() == 2)
			{
				this.setBlockBounds(0.0F, 0.19F, 0.625F, 1.0F, 0.81F, 1.0F);
			}
			else if (((TileEntityArmoirePh)te).getDirection() == 3)
			{
				this.setBlockBounds(0.0F, 0.19F, 0.0F, 0.368F, 0.81F, 1.0F);
			}
			else
			{
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("fearz:ArmoirePharmacie");
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata)
	{
		return this.blockIcon;
	}
}