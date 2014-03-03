package _fearZ.mod.events;

import _fearZ.mod.Mod_FearZ;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;

public class BlockEvents
{
	/**detruit une boite se trouvant au dessus d'une barriere quand celle ci est detruite*/
	@ForgeSubscribe
	public void destroyMailBox(BlockEvent event)
	{
		World world = event.world;
		if (world.getBlockId(event.x, event.y, event.z) == Block.fence.blockID)
		{
			if (world.getBlockId(event.x, event.y+1, event.z) == Mod_FearZ.mailBox.blockID)
			{
				world.destroyBlock(event.x, event.y+1, event.z, false);
			}
		}
	}
}