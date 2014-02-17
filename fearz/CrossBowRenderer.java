package FearZ;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class CrossBowRenderer implements IItemRenderer {

	public CrossBowRenderer ()
	{
		model = new CrossBowModel();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type)
		{
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch(type)
		{
		case EQUIPPED:
		{
			GL11.glPushMatrix();
			GL11.glRotatef(45, 0.0F, -0.4F, 1.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			GL11.glRotatef(-80.0F, 45.0F, -20.0F, 0.0F);
			GL11.glTranslatef(0.4F, -0.5F, 0.1F);
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix(); 
			break;
			
		}
		case EQUIPPED_FIRST_PERSON:
		{
			GL11.glPushMatrix();
			GL11.glRotatef(45, 0.0F, 0.0F, 1.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.6F, 0.0F, 0.1F);
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix(); 
			break;		
	        }
		default:
			break;
		}
	}
	
	protected CrossBowModel model;
	protected static final ResourceLocation texture = new ResourceLocation("FearZ:textures/items/Arbalète.png");
}
