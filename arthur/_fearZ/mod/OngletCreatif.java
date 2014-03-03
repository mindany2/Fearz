package _fearZ.mod;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
 
public class OngletCreatif extends CreativeTabs
{
        private String name;
	public OngletCreatif(int tabId, String name)
	{
		super(tabId, name);
        this.name = name;
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return Block.dirt.blockID;
	}
	
	public String getTranslatedTabLabel()
	{
		return this.name;
	}
}
