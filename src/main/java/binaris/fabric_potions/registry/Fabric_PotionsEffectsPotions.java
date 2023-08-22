package binaris.fabric_potions.registry;

import binaris.fabric_potions.potions.*;
import net.minecraft.potion.Potion;

public class Fabric_PotionsEffectsPotions {

    public static Potion ANTIDOTE;
    public static Potion PURITY;
    public static Potion BLEED;
    public static Potion TRUESHOT;
    public static Potion KLUTZ;

    public static void registerPotions(){

        ANTIDOTE = new Antidote_Potions();
        PURITY = new Purity_Potions();
        BLEED = new Bleed_Potions();
        TRUESHOT = new Trueshot_Potions();
        KLUTZ = new Klutz_Potions();
    }
}
