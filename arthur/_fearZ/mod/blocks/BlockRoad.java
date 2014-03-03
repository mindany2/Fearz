package _fearZ.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import _fearZ.mod.Mod_FearZ;
import _fearZ.mod.client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BlockRoad extends Block
{
	public BlockRoad(int par1)
	{
		super(par1, Material.rock);
		setCreativeTab(Mod_FearZ.onglet);
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return ClientProxy.renderRoadId;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
	{
		setBlockBounds(0*1/16f, 0*1/16f, 0*1/16f, 16*1/16f, 1*1/16f, 16*1/16f);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		blockIcon = Block.stoneBrick.getIcon(0, 0);
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int ID, int meta)
	{
		return this.blockIcon;
	}
}
