package binaris.fabric_potions.registry;

import binaris.fabric_potions.potions.Antidote_Potions;
import net.minecraft.potion.Potion;

public class Fabric_PotionsEffectsPotions {

    public static Potion ANTIDOTE;

    public static void registerPotions(){
        ANTIDOTE = new Antidote_Potions();
    }


    public static void registerPotionsRecipes(){

    }
}
