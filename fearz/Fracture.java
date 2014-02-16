package FearZ;

import net.minecraft.potion.Potion;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class Fracture extends Potion {

	  public Fracture(int par1, boolean par2, int par3) 
	  {
	     super(par1, par2, par3);
	  }

	   public Potion setIconIndex(int par1, int par2) 
	   {
	     super.setIconIndex(par1, par2);
	     return this;
	   }
	   
	}