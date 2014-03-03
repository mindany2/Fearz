package _fearZ.mod.gui.handler;

import _fearZ.mod.ContainerArmoirePh;
import _fearZ.mod.GuiArmoirePh;
import _fearZ.mod.containers.ContainerMChest;
import _fearZ.mod.gui.GuiMChest;
import _fearZ.mod.tileentity.TileEntityArmoirePh;
import _fearZ.mod.tileentity.TileEntityMChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if(te instanceof TileEntityArmoirePh)
		{
			return new ContainerArmoirePh(player.inventory, (TileEntityArmoirePh)te);
		}
		if (te instanceof TileEntityMChest)
		{
			return new ContainerMChest(player.inventory, (TileEntityMChest)te);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if(te instanceof TileEntityArmoirePh)
		{
			return new GuiArmoirePh(player.inventory, (TileEntityArmoirePh)te);
		}
		if (te instanceof TileEntityMChest)
		{
			return new GuiMChest(player.inventory, (TileEntityMChest)te);
		}
		return null;
	}
}