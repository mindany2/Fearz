package Mod.FearZ.net.Block;

import Mod.FearZ.net.BaseFearZ;
import Mod.FearZ.net.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Table extends Block
{
public Table(int id)
{
super(id, Material.wood);
this.setCreativeTab(BaseFearZ.FearzCreativeTabs);
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
return ClientProxy.renderTableId;
}

@SideOnly(Side.CLIENT)
public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
{
return true;
}

public Icon getIcon(int side, int metadata)
{
return Block.planks.getIcon(side, 0);
}
}
