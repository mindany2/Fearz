package _fearZ.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import _fearZ.mod.Mod_FearZ;
import _fearZ.mod.client.ClientProxy;
import _fearZ.mod.tileentity.TileEntityArmoirePh;
import _fearZ.mod.tileentity.TileEntityStereo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStereo extends Block
{
	private Icon face;
	public BlockStereo(int par1)
	{
		super(par1, Material.rock);
		setCreativeTab(Mod_FearZ.onglet);
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TileEntityStereo();
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
	
	@Override
	public int getRenderType()
	{
		return ClientProxy.renderInventoryTESRId;
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
    {
        int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        
    	TileEntity te = world.getBlockTileEntity(x, y, z);
    	
    	if(te != null && te instanceof TileEntityStereo)
    	{
    		((TileEntityStereo)te).setDirection((byte)direction);
    		world.markBlockForUpdate(x, y, z);
    	}
    }
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
	{
		TileEntity te = blockAccess.getBlockTileEntity(x, y, z);
		int direction = ((TileEntityStereo)te).getDirection();
		if (te != null && te instanceof TileEntityStereo)
		{
			if (direction == 0)
				this.setBlockBounds(2.5f/16f, 0/16f, 6/16f, 13.5f/16f, 8/16f, 9/16f);
			else if (direction == 1)
				this.setBlockBounds(7/16f, 0/16f, 2.5f/16f, 10/16f, 8/16f, 13.5f/16f);
			else if (direction == 2)
				this.setBlockBounds(2.5f/16f, 0/16f, 7/16f, 13.5f/16f, 8/16f, 10/16f);
			else if (direction == 3)
				this.setBlockBounds(6/16f, 0/16f, 2.5f/16f, 9/16f, 8/16f, 13.5f/16f);
			else
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("fearz:stereo");
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		return this.blockIcon;
	}
}
