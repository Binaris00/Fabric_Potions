package binaris.fabric_potions.registry;

import binaris.fabric_potions.potions.*;
import net.minecraft.potion.Potion;

public class Fabric_PotionsEffectsPotions {

    public static Potion ANTIDOTE;
    public static Potion PURITY;
    public static Potion BLEED;
    public static Potion PERFECTSHOT;
    public static Potion BADSHOT;
    public static Potion GRAVITATION;
    public static Potion BROKEN_ARMOR;
    public static Potion REPAIRING;
    public static Potion CORROSION;
    public static Potion DIAMOND_SKIN;
    public static Potion ENDERMAN_SOUL;
    public static Potion FLIGHT;
    public static Potion HEALTH_DECREASE;
    public static Potion VULNERABILITY;
    public static Potion WELL_FED;
    public static Potion SOLID_BODY;
    public static Potion MAGIC_FOCUS;
    public static Potion MAGIC_INHIBITION;
    public static Potion COUNTER;
    public static Potion COMBUSTION;
    public static Potion LIGHTNING;
    public static Potion IRON_SKIN;
    public static Potion MAGIC_SHIELDING;
    public static void registerPotions(){

        ANTIDOTE = new Antidote_Potions();
        PURITY = new Purity_Potions();
        BLEED = new Bleed_Potions();
        PERFECTSHOT = new PerfectShot_Potions();
        BADSHOT = new BadShot_Potions();
        GRAVITATION = new Gravitation_Potions();
        BROKEN_ARMOR = new BrokenArmor_Potions();
        REPAIRING = new Repairing_Potions();
        CORROSION = new Corrosion_Potions();
        DIAMOND_SKIN = new DiamondSkin_Potions();
        ENDERMAN_SOUL = new EndermanSoul_Potions();
        FLIGHT = new Flight_Potions();
        HEALTH_DECREASE = new HealthDecrease_Potions();
        VULNERABILITY = new Vulnerability_Potions();
        WELL_FED = new WellFed_Potions();
        SOLID_BODY = new SolidBody_Potions();
        MAGIC_FOCUS = new MagicFocus_Potions();
        MAGIC_INHIBITION = new MagicInhibition_Potions();
        COUNTER = new Counter_Potions();
        COMBUSTION = new Combustion_Potions();
        LIGHTNING = new Lightning_Potions();
        IRON_SKIN = new IronSkin_Potions();
        MAGIC_SHIELDING = new MagicShielding_Potions();
    }
}
