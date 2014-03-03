package _fearZ.mod.blocks;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import _fearZ.mod.Mod_FearZ;
import _fearZ.mod.client.ClientProxy;
import _fearZ.mod.tileentity.TileEntityMChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMChest extends BlockContainer
{

	public BlockMChest(int par1)
	{
		super(par1, Material.ground);
		setCreativeTab(Mod_FearZ.onglet);
	}

	/**
	 * Cette methode ne sers pas
	 * */
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return null;
	}

	/**
	 * on se sers de celle ci
	 * */
	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TileEntityMChest();
	}

	/**
	 * indique au bloc qu'il a besoin d'un tileEntity
	 * */
	@Override
	public boolean hasTileEntity()
	{
		return true;
	}

	/**
	 * le bloc n'est pas un bloc de 1 par 1 par 1
	 * */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	/**
	 * il ne décharge pas la texture des blocs adjacents
	 * */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * le bloc a besoin d'un rendu
	 * */
//	@Override
//	public int getRenderType()
//	{
//		return ClientProxy.renderInventoryTESRId;
//	}

	/**
	 * Cette fonction est appelee quand le joueur clique droit sur le bloc. Le "return true" a la fin
	 * veut dire que si on tiens un bloc a la main quand on clique droit, ce bloc ne sera pas pose
	 * */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		FMLNetworkHandler.openGui(player, Mod_FearZ.modInstance, 0, world, x, y, z);
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase livingBase, ItemStack stack)
	{
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityMChest && stack.hasDisplayName())
		{
			((TileEntityMChest)te).setCustomGuiName(stack.getDisplayName());
		}
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int side, int metadata)
	{
		dropContainerItem(world, x, y, z);
		super.breakBlock(world, x, y, z, side, metadata);
	}

	protected void dropContainerItem(World world, int x, int y, int z)
	{
		TileEntityMChest bigchest = (TileEntityMChest)world.getBlockTileEntity(x, y, z);

		if (bigchest != null)
		{
			for (int slotId = 0; slotId < bigchest.getSizeInventory(); slotId++)
			{
				ItemStack stack = bigchest.getStackInSlot(slotId);

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
}
