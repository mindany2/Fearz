package _fearZ.mod.tileentity;

import java.util.Iterator;
import java.util.List;

import _fearZ.mod.ContainerArmoirePh;
import _fearZ.mod.blocks.BlockPharmacie;
import _fearZ.mod.blocks.model.ModelArmoirPh;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityArmoirePh extends TileEntity implements IInventory
{
	public float lidAngle;
	public float prevLidAngle;
	public int numUsingPlayers;
	private int ticksSinceSync;
	
	public byte direction;
	private ItemStack[] inventory = new ItemStack[72];
	private String customName;
	public void readFromNBT(NBTTagCompound nbtTag)
	{
		super.readFromNBT(nbtTag);
		direction = nbtTag.getByte("direction");

		super.readFromNBT(nbtTag);
		NBTTagList nbttaglist = nbtTag.getTagList("Items");
		this.inventory = new ItemStack[this.getSizeInventory()];

		if (nbtTag.hasKey("CustomName"))
		{
			this.customName = nbtTag.getString("CustomName");
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

	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	public void writeToNBT(NBTTagCompound nbtTag)
	{
		super.writeToNBT(nbtTag);
		nbtTag.setByte("direction", direction);

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

		nbtTag.setTag("Items", nbttaglist);

		if (this.isInvNameLocalized())
		{
			nbtTag.setString("CustomName", this.customName);
		}
	}

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

	public void setInventorySlotContents(int slotId, ItemStack stack)
	{
		this.inventory[slotId] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}

		this.onInventoryChanged();
	}

	public String getInvName()
	{
		return this.isInvNameLocalized() ? this.customName : "container.armoireph";
	}

	public int getInventoryStackLimit()
	{
		return 64;
	}

	public boolean isInvNameLocalized()
	{
		return this.customName != null && this.customName.length() > 0;
	}

	public void setCustomGuiName(String name)
	{
		this.customName = name;
	}

	public ItemStack getStackInSlot(int slotId)
	{
		return inventory[slotId];
	}

	public int getSizeInventory()
	{
		return inventory.length;
	}

	public void setDirection(byte direct)
	{
		direction = direct;
	}

	public byte getDirection()
	{
		return direction;
	}

	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeToNBT(nbttagcompound);
		return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 4, nbttagcompound);
	}

	public boolean isItemValidForSlot(int slotId, ItemStack stack)
	{
		return true;
	}

	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt)
	{
		this.readFromNBT(pkt.data);
	}

	@Override
	public void openChest()
	{
		if(this.numUsingPlayers < 0)
		{
			this.numUsingPlayers = 0;
		}

		++this.numUsingPlayers;
		this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID, 1, this.numUsingPlayers);
	}

	@Override
	public void closeChest()
	{
		--this.numUsingPlayers;
		this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID, 1, this.numUsingPlayers);
	}
	
	public boolean receiveClientEvent(int eventId, int eventValue)
	{
		if(eventId == 1)
		{
			this.numUsingPlayers = eventValue;
			return true;
		}
		else
		{
			return super.receiveClientEvent(eventId, eventValue);
		}
	}
	
	
	public void updateEntity()
	{
		super.updateEntity();
		++this.ticksSinceSync;

		if(!this.worldObj.isRemote && this.numUsingPlayers != 0 && (this.ticksSinceSync + this.xCoord + this.yCoord + this.zCoord) % 200 == 0)
		{
			this.numUsingPlayers = 0;
			List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getAABBPool().getAABB(this.xCoord - 5, this.yCoord - 5, this.zCoord - 5, this.xCoord + 6, this.yCoord + 6, this.zCoord + 6));
			Iterator iterator = list.iterator();

			while(iterator.hasNext())
			{
				EntityPlayer entityplayer = (EntityPlayer)iterator.next();

				if(entityplayer.openContainer instanceof ContainerArmoirePh)
				{
					++this.numUsingPlayers;
				}
			}
		}

		this.prevLidAngle = this.lidAngle;

		if(this.numUsingPlayers > 0 && this.lidAngle == 0.0F)
		{
			this.worldObj.playSoundEffect(((double)this.xCoord + 0.5), (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D, "random.chestopen", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
		}

		if(this.numUsingPlayers == 0 && this.lidAngle > 0.0F || this.numUsingPlayers > 0 && this.lidAngle < 1.0F)
		{
			float f1 = this.lidAngle;

			if(this.numUsingPlayers > 0)
			{
				this.lidAngle += 0.1F;
			}
			else
			{
				this.lidAngle -= 0.1F;
			}

			if(this.lidAngle > 1.0F)
			{
				this.lidAngle = 1.0F;
			}

			float f2 = 0.5F;

			if(this.lidAngle < f2 && f1 >= f2)
			{
				this.worldObj.playSoundEffect((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
			}

			if(this.lidAngle < 0.0F)
			{
				this.lidAngle = 0.0F;
			}
		}
	}
	
}