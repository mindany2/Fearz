package _fearZ.mod.blocks;

import java.util.Random;

import _fearZ.mod.Mod_FearZ;
import _fearZ.mod.client.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCampFire extends Block
{

	public BlockCampFire(int par1)
	{
		super(par1, Material.ground);
		setCreativeTab(Mod_FearZ.onglet);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return ClientProxy.renderCampFireId;
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("fearz:buche");
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		Random random = new Random();
		if (player.getHeldItem() != null)
		{
			if (this.blockID == Mod_FearZ.campFire_off.blockID)
			{
				if (player.getHeldItem().itemID == Item.flintAndSteel.itemID)
				{
					if (!world.isRemote)
					{
						world.setBlock(x, y, z, Mod_FearZ.campFire_on.blockID);
						world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "fire.ignite", 1.0F, random.nextFloat() * 0.4F + 0.8F);
					}
				}
			}
			else if (this.blockID == Mod_FearZ.campFire_on.blockID)
			{
				
			}
		}
		return true;
	}
	@Override
	public void onBlockClicked(World world, int x, int y, int z,EntityPlayer player)
	{
		if (!world.isRemote)
		{
			if (player.getHeldItem() == null || player.getHeldItem().itemID == Item.bucketWater.itemID)
			{
				world.setBlock(x, y, z, Mod_FearZ.campFire_off.blockID);
			}
		}
	}
	
	@Override
	public Icon getIcon(int par1, int par2)
	{
		return this.blockIcon;
	}
	
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) 
    {
		if (world.getBlockId(x, y, z) == Mod_FearZ.campFire_on.blockID)
			entity.setFire(10);
    }
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if (random.nextInt(24) == 0)
        {
            world.playSound((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "fire.fire", 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);
        }
		
		if(world.getBlockId(x, y, z) == Mod_FearZ.campFire_on.blockID)
		{
			world.spawnParticle("flame", x+0.5, y+0.3, z+0.2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x+0.2, y+0.3, z+0.5, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x+0.8, y+0.3, z+0.5, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x+0.5, y+0.3, z+0.8, 0.0D, 0.0D, 0.0D);
			
			world.spawnParticle("flame", x+0.3, y+0.4, z+0.3, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x+0.7, y+0.4, z+0.3, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x+0.3, y+0.4, z+0.7, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x+0.7, y+0.4, z+0.7, 0.0D, 0.0D, 0.0D);
			
			world.spawnParticle("flame", x+0.2, y+0.3, z+0.2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x+0.8, y+0.3, z+0.2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x+0.2, y+0.3, z+0.8, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x+0.8, y+0.3, z+0.8, 0.0D, 0.0D, 0.0D);
			
			world.spawnParticle("flame", x+0.5, y+0.4, z+0.3, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x+0.3, y+0.4, z+0.5, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x+0.5, y+0.4, z+0.7, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", x+0.7, y+0.4, z+0.5, 0.0D, 0.0D, 0.0D);
	        
			world.spawnParticle("flame", x+0.5, y+0.4, z+0.5, 0.0D, 0.0D, 0.0D);
	        world.spawnParticle("flame", x+0.5, y+0.6, z+0.5, 0.0D, 0.0D, 0.0D);
	        
	        world.spawnParticle("largesmoke", x+0.5, y+0.5, z+0.5, 0.0D, 0.0D, 0.0D);
		}
	}
}
