package FearZ;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionAttackDamage;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class FearZEventHooks {

	@ForgeSubscribe
	public void onEntityUpdate(LivingUpdateEvent event) {
		if (event.entityLiving.isPotionActive(BaseFearZ.Fracture)) {
			event.entityLiving.addPotionEffect(new PotionEffect(BaseFearZ.Fracture.id, 200000000,0));
		}
		if (event.entityLiving.isPotionActive(BaseFearZ.FractureOuverte)) {
			event.entityLiving.addPotionEffect(new PotionEffect(BaseFearZ.FractureOuverte.id, 200000000,0));
			
		}
		if (event.entityLiving.isPotionActive(BaseFearZ.Maladie)) {
			if (event.entityLiving.getActivePotionEffect(BaseFearZ.Maladie).getDuration()==1){
				event.entityLiving.addPotionEffect(new PotionEffect(BaseFearZ.Maladie.id, 6000,0));
				event.entityLiving.attackEntityFrom(DamageSource.magic, 1.0F);
					}}
			
		}
	
    int a = 1;
    @ForgeSubscribe
    public void onLivingFall(LivingFallEvent event1)
    {
   	 
   			 if(event1.entityLiving instanceof EntityPlayer &&event1.distance > 6.0F &&event1.distance < 10.0F )
         {
           EntityPlayer player = (EntityPlayer)event1.entityLiving;
           if(a==1){
           player.addChatMessage("Vous vous êtes cassé la jambe !"); a=0;}
           event1.entityLiving.addPotionEffect(new PotionEffect(BaseFearZ.Fracture.id, 2000000000,0));
           
         }
   			 
   			if(event1.entityLiving instanceof EntityPlayer &&event1.distance > 10.0F )
            {
              EntityPlayer player = (EntityPlayer)event1.entityLiving;
              if(a==1){
              player.addChatMessage("Vous vous êtes cassé la jambe !"); a=0;}
              event1.entityLiving.addPotionEffect(new PotionEffect(BaseFearZ.FractureOuverte.id, 2000000000,0));
              
            }
   
}     
}


