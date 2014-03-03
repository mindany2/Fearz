package _fearZ.mod.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import _fearZ.mod.Mod_FearZ;
import _fearZ.mod.client.ClientProxy;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGaziniere extends BlockContainer
{
	@SideOnly(Side.CLIENT)
	private Icon principal, noir, poignee, vitreE, vitreA;
	private static boolean isActive;
	private static boolean keepFurnaceInventory = false;
	private final Random furnaceRand = new Random();
	public BlockGaziniere(int par1)
	{
		super(par1, Material.ground);
		setCreativeTab(Mod_FearZ.onglet);
		setTextureName("fearz:damier16");
		isActive = false;
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
		return ClientProxy.renderGaziniereId;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack itemStack)
	{
		int direction = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		return true;
	}
	
	public static void updateFurnaceBlockState(boolean par0, World world, int x, int y, int z)
    {
        int l = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getBlockTileEntity(x, y, z);
        keepFurnaceInventory = true;

        if (par0)
        {
            world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 4, 2);
            isActive = true;
        }
        else
        {
        	world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) - 4, 2);
        	isActive = false;
        }

        keepFurnaceInventory = false;
//        world.setBlockMetadataWithNotify(x, y, z, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            world.setBlockTileEntity(x, y, z, tileentity);
        }
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("fearz:damier16");
		principal = iconRegister.registerIcon("fearz:gaziniere/corps");
		noir = iconRegister.registerIcon("fearz:gaziniere/plaques");
		poignee = iconRegister.registerIcon("fearz:gaziniere/poignee");
		vitreE = iconRegister.registerIcon("fearz:gaziniere/vitreE");
		vitreA = iconRegister.registerIcon("fearz:gaziniere/vitreA");
	}
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		if(meta == 0)//corps, bordures, bordure arriere, porte
			return this.principal;
		if(meta == 1)//plaques, boutons
			return this.noir;
		if(meta == 2)//poignee
			return this.poignee;
		if(meta == 3)//vitre(eteinte)
			return this.vitreE;
		if(meta == 4)//vitre(alumee)
			return this.vitreA;
		else
			return this.blockIcon;
	}
	
	public void breakBlock(World world, int x, int y, int z, int par5, int par6)
    {
		
    }
	
	public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World par1World, int x, int y, int z, int par5)
    {
        return Container.calcRedstoneFromInventory((IInventory)par1World.getBlockTileEntity(x, y, z));
    }

    @SideOnly(Side.CLIENT)
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return Mod_FearZ.gaziniere.blockID;
    }
	
	public int getMobilityFlag()
	{
		return 2;
	}
	
	@Override
	public boolean canBeReplacedByLeaves(World world, int x, int y, int z)
	{
		return false;
	}
	
	public boolean canCreatureSpawn(net.minecraft.entity.EnumCreatureType type, World world, int x, int y, int z)
	{
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess BlockAccess, int par2, int par3, int par4, int par5)
	{
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return null;
	}
}
