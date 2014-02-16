package fearz;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FearzCreativeTabs extends CreativeTabs {

	private String name;
	public FearzCreativeTabs(int tabId, String name)
	{
		super(tabId, name);
                this.name = name;
	}
	
	@Override
	public ItemStack getIconItemStack()
	{
	    return new ItemStack(BaseFearZ.Knife);
	}
	
	public String getTranslatedTabLabel()
	{
		return this.name;
	}

}