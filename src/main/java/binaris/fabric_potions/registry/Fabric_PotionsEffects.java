package binaris.fabric_potions.registry;

import binaris.fabric_potions.effects.*;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;

public class Fabric_PotionsEffects {

    public static StatusEffect HEALTH_DECREASE;
    public static StatusEffect BLEED;
    public static StatusEffect WELL_FED;
    public static StatusEffect TRUESHOT;
    public static StatusEffect KLUTZ;


    public static void registerEffects(){
        HEALTH_DECREASE = new Health_Decrease().addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "4BC011F2-3606-11EE-BE56-0242AC120002", -4.0, EntityAttributeModifier.Operation.ADDITION);
        BLEED = new Bleed();
        WELL_FED = new Well_Fed();
        TRUESHOT = new TrueShot();
        KLUTZ = new Klutz();
    }
}
