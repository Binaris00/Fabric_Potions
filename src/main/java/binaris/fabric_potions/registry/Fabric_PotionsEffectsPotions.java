package binaris.fabric_potions.registry;

import binaris.fabric_potions.potions.*;
import net.minecraft.potion.Potion;

public class Fabric_PotionsEffectsPotions {

    public static Potion ANTIDOTE;
    public static Potion PURITY;
    public static Potion BLEED;
    public static Potion TRUESHOT;
    public static Potion KLUTZ;
    public static Potion GRAVITATION;
    public static Potion BROKEN_ARMOR;
    public static Potion REPAIRING;
    public static Potion CORROSION;
    public static Potion DIAMOND_SKIN;

    public static void registerPotions(){

        ANTIDOTE = new Antidote_Potions();
        PURITY = new Purity_Potions();
        BLEED = new Bleed_Potions();
        TRUESHOT = new Trueshot_Potions();
        KLUTZ = new Klutz_Potions();
        GRAVITATION = new Gravitation_Potions();
        BROKEN_ARMOR = new BrokenArmor_Potions();
        REPAIRING = new Repairing_Potions();
        CORROSION = new Corrosion_Potions();
        DIAMOND_SKIN = new DiamondSkin_Potions();
    }
}
