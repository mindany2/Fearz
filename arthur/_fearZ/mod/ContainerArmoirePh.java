package _fearZ.mod;

import _fearZ.mod.tileentity.TileEntityArmoirePh;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerArmoirePh extends Container
{
	private TileEntityArmoirePh tileEntity;

	public ContainerArmoirePh(InventoryPlayer playerInventory, TileEntityArmoirePh teArmoirePh)
	{
		this.tileEntity = teArmoirePh;
		
		teArmoirePh.openChest();
		
		this.addSlotToContainer(new Slot(teArmoirePh, 1, 81, 60));

		this.bindPlayerInventory(playerInventory);
	}
	
	private void bindPlayerInventory(InventoryPlayer playerInventory)
	{
		int i;
		for(i = 0; i < 3; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 103 + i * 18 + 37));
			}
		}

		for(i = 0; i < 9; i++)
		{
			this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 161 + 37));
		}
	}
	
	public void onContainerClosed(EntityPlayer player)
	{
		super.onContainerClosed(player);
		tileEntity.closeChest();
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tileEntity.isUseableByPlayer(player);
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int slotId)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(slotId);

		if(slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if(slotId < 9)
			{
				if(!this.mergeItemStack(itemstack1, 9, this.inventorySlots.size(), true))
				{
					return null;
				}
			}
			else if(!this.mergeItemStack(itemstack1, 0, 9, false))
			{
				return null;
			}

			if(itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			}
			else
			{
				slot.onSlotChanged();
			}
		}
		return itemstack;
	}
}