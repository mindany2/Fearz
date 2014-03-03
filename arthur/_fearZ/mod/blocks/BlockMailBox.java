package _fearZ.mod.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import _fearZ.mod.Mod_FearZ;
import _fearZ.mod.client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.IFluidBlock;

public class BlockMailBox extends Block
{
	private Icon gauche, damier16, droite, arriere, dessus, dessous, porte, porte2, porte3, porte4, porte5;
	
	public BlockMailBox(int par1, Material par2Material)
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
		return ClientProxy.renderMailBoxId;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta)
	{
		getBlockUnder(world, x, y, z);
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion)
	{
		getBlockUnder(world, x, y, z);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if(world.getBlockMetadata(x, y, z) < 4)
		{
			world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 4, 2);
		}
		else if(world.getBlockMetadata(x, y, z) >= 4)
		{
			world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) - 4, 2);
		}
		return true;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z)
	{
		int meta = blockAccess.getBlockMetadata(x, y, z);
		if (meta == 1 || meta == 3 || meta == 5 || meta == 7)
			this.setBlockBounds(1*1/16f, 0*1/16f, 4*1/16f, 15*1/16f, 9*1/16f, 12*1/16f);
		
		if (meta == 0 || meta == 2 || meta == 4 || meta == 6)
			this.setBlockBounds(4*1/16f, 0*1/16f, 1*1/16f, 12*1/16f, 9*1/16f, 15*1/16f);
	}
	
	/**si le bloc en dessous est un baton allors il est detruit*/
	public void getBlockUnder(World world, int x, int y, int z)
	{
		if(world.getBlockId(x, y - 1, z) == Mod_FearZ.stick.blockID)
			world.destroyBlock(x, y - 1, z, false);
	}
	
	@SideOnly(Side.CLIENT)
    public int idPicked(World world, int x, int y, int z)
    {
        return Mod_FearZ.mailBoxItem.itemID;
    }
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("fearz:damier16");
		gauche = iconRegister.registerIcon ("fearz:mailBox/bals");
		droite = iconRegister.registerIcon ("fearz:mailBox/bals");
		arriere = iconRegister.registerIcon("fearz:mailBox/bala");
		dessous = iconRegister.registerIcon("fearz:mailBox/bala");
		dessus = iconRegister.registerIcon("fearz:mailBox/bald");
		porte = iconRegister.registerIcon("fearz:mailBox/balp2");
		porte2 = iconRegister.registerIcon("fearz:mailBox/balp");
		porte3 = iconRegister.registerIcon("fearz:mailBox/balp3");
		porte4 = iconRegister.registerIcon("fearz:mailbox/balp4");
		porte5 = iconRegister.registerIcon("fearz:mailBox/balp5");
		
	}
	
	@SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta)
    {
		if(meta == 0)
			return this.gauche;
		else if(meta == 1)
			return this.droite;
		else if(meta == 2)
			return this.arriere;
		else if(meta == 3)
			return this.dessous;
		else if(meta == 4)
			return this.dessus;
		else if(meta == 5)
			return this.porte;
		else if(meta == 6)
			return this.porte2;
		else if(meta == 7)
			return this.porte3;
		else if(meta == 8)
			return this.porte4;
		else if(meta == 9)
			return this.porte5;
		else
			return this.blockIcon;
		
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
}
