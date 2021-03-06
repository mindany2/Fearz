package _fearZ.mod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMChest extends TileEntity implements IInventory
{
	private ItemStack[] inventory = new ItemStack[72];
	private String customName;
	
	@Override
	public void readFromNBT(NBTTagCompound nbttag)
	{
		super.readFromNBT(nbttag);
        NBTTagList nbttaglist = nbttag.getTagList("Items");
        this.inventory = new ItemStack[this.getSizeInventory()];

        if (nbttag.hasKey("CustomName"))
        {
            this.customName = nbttag.getString("CustomName");
        }

        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            int j = nbttagcompound1.getByte("Slot");

            if (j >= 0 && j < this.inventory.length)
            {
                this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbttag)
	{
		super.writeToNBT(nbttag);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.inventory.length; i++)
        {
            if (this.inventory[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.inventory[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbttag.setTag("Items", nbttaglist);

        if (this.isInvNameLocalized())
        {
            nbttag.setString("CustomName", this.customName);
        }
	}
	
	@Override
	public int getSizeInventory()
	{
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slotId)
	{
		return inventory[slotId];
	}

	@Override
	public ItemStack decrStackSize(int slotId, int quantity)
	{
		if (this.inventory[slotId] != null)
		{
			ItemStack itemstack;
			
			if (this.inventory[slotId].stackSize <= quantity)
			{
				itemstack = this.inventory[slotId];
				this.inventory[slotId] = null;
				this.onInventoryChanged();
				return itemstack;
			}
			else
			{
				itemstack = this.inventory[slotId].splitStack(quantity);
				
				if (this.inventory[slotId].stackSize == 0)
				{
					this.inventory[slotId] = null;
				}
				
				this.onInventoryChanged();
				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slotId)
	{
		if (this.inventory[slotId] != null)
		{
			ItemStack itemstack = this.inventory[slotId];
			this.inventory[slotId] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public void setInventorySlotContents(int slotId, ItemStack stack)
	{
		this.inventory[slotId] = stack;
		
		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}
		
		this.onInventoryChanged();
	}

	@Override
	public String getInvName()
	{
		return this.isInvNameLocalized() ? this.customName : "container.bigchest";
	}

	@Override
	public boolean isInvNameLocalized()
	{
		return this.customName != null && this.customName.length() > 0;
	}
	
	public void setCustomGuiName(String name)
    {
        this.customName = name;
    }
	
	/**
	 * la limite d'un stack dans une case de l'inventaire du coffre
	 * */
	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void openChest()
	{
		
	}

	@Override
	public void closeChest()
	{
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return true;
	}
}
