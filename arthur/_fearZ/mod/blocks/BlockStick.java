package _fearZ.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import _fearZ.mod.Mod_FearZ;
import _fearZ.mod.client.ClientProxy;
import _fearZ.mod.tileentity.TileEntityArmoirePh;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStick extends Block
{
	public BlockStick(int par1, Material par2Material)
	{
		super(par1, par2Material);
		}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderType()
	{
		return ClientProxy.renderStickId;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
	{
		return true;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta)
	{
		getBlockOver(world, x, y, z);
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion)
	{
		getBlockOver(world, x, y, z);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
	{
		this.setBlockBounds(7*1/16F, 0.0F, 7*1/16F, 9*1/16F, 1.0F, 9*1/16F);
	}
	
	/**si le bloc au dessus est une boite aux lettres allors elle est detruite*/
	public void getBlockOver(World world, int x, int y, int z)
	{
		if(world.getBlockId(x, y + 1, z) == Mod_FearZ.mailBox.blockID)
			world.destroyBlock(x, y + 1, z, false);
	}
	
	public int getMobilityFlag()
	{
		return 2;
	}
	
	@SideOnly(Side.CLIENT)
    public int idPicked(World world, int x, int y, int z)
    {
        return Mod_FearZ.mailBoxItem.itemID;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = Block.planks.getIcon(0, 0);
	}
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata)
    {
		return this.blockIcon;
    }
}
