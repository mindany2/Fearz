package FearZ;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionAttackDamage;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;

public class FearZEventHooks {

	public int deg=37; 
//	BaseFearZ FearZ = new BaseFearZ();
	@ForgeSubscribe
	public void onEntityUpdate(LivingUpdateEvent event) {
		int i = MathHelper.floor_double(event.entity.posX);
		int j = MathHelper.floor_double(event.entity.posZ);
		int b = 0;
		if(event.entityLiving instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entityLiving;
		
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
		if(event.entity.worldObj.getBiomeGenForCoords(i, j) == BiomeGenBase.swampland){
			if (!event.entityLiving.isPotionActive(BaseFearZ.Degres)) {
			event.entityLiving.addPotionEffect(new PotionEffect(BaseFearZ.Degres.id, 500,0));
		}
		}
			if (event.entityLiving.isPotionActive(BaseFearZ.Degres)) {
				if (event.entityLiving.getActivePotionEffect(BaseFearZ.Degres).getDuration()==20){
				b = 0;
				}
				if (event.entityLiving.getActivePotionEffect(BaseFearZ.Degres).getDuration()==2&& b==0){
					if(b==0){
							deg--;
					b=5;
					player.addChatMessage(Integer.toString(b));

					player.addChatMessage("Votre temp�rature corporelle est de "+deg+"�C");
//					event.entityLiving.addPotionEffect(new PotionEffect(BaseFearZ.Degres.id, 2000,0));
				}
				}
		}

			if(deg == 35){
				if (event.entityLiving.isPotionActive(BaseFearZ.Maladie)) {
				event.entityLiving.addPotionEffect(new PotionEffect(BaseFearZ.Maladie.id, 6000,0));
			}
			}
		//
		//			event.entityLiving.addPotionEffect(new PotionEffect(BaseFearZ.FractureOuverte.id, 200000000,0));
		//		}
	}}

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


