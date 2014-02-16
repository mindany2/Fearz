package FearZ;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionAttackDamage;

public class Maladie extends PotionAttackDamage {

	protected Maladie(int par1, boolean par2, int par3)
    {
        super(par1, par2, par3);
    }
@Override
    public double func_111183_a(int par1, AttributeModifier par2AttributeModifier)
    {
        return this.id == BaseFearZ.Maladie.id ? (double)(-0.15F * (float)(par1 + 1)) : 1.3D * (double)(par1 + 1);
    }
}
