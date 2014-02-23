package Mod.FearZ.net;
     
    import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
     
    public class LaveL extends Block
    {
    public LaveL(int par1, Material material)//Souvenez vous on a donné 2 paramètres donc on les récupère
    {
    super(par1, material);//Puis on les renvoi à la classe mère (la classe Block) car elle demande un ID et un Material
    }
    }
