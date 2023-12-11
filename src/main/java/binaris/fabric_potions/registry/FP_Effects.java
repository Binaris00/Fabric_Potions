package binaris.fabric_potions.registry;

import binaris.fabric_potions.config.Config;
import binaris.fabric_potions.effects.*;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;

public class FP_Effects {

    public static StatusEffect HEALTH_DECREASE;
    public static StatusEffect BLEED;
    public static StatusEffect WELL_FED;
    public static StatusEffect PERFECTSHOT;
    public static StatusEffect BADSHOT;
    public static StatusEffect ENDERMAN_SOUL;
    public static StatusEffect REPAIRING;
    public static StatusEffect BROKEN_ARMOR;
    public static StatusEffect SOLID_BODY;
    public static StatusEffect PURITY;
    public static StatusEffect ANTIDOTE;
    public static StatusEffect GRAVITATION;
    public static StatusEffect DIAMOND_SKIN;
    public static StatusEffect VULNERABILITY;
    public static StatusEffect CORROSION;
    public static StatusEffect MAGIC_FOCUS;
    public static StatusEffect MAGIC_INHIBITION;
    public static StatusEffect COUNTER;
    public static StatusEffect COMBUSTION;
    public static StatusEffect LIGHTNING;
    public static StatusEffect IRON_SKIN;
    public static StatusEffect MAGIC_SHIELDING;
    public static StatusEffect INMORTALITY;
    public static void registerEffects(){
        HEALTH_DECREASE = new Health_Decrease().addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "4BC011F2-3606-11EE-BE56-0242AC120002", Config.getFloat("health_decrease.hearths"), EntityAttributeModifier.Operation.ADDITION);
        BLEED = new Bleed();
        WELL_FED = new Well_Fed();
        PERFECTSHOT = new PerfectShot();
        BADSHOT = new BadShot();
        ENDERMAN_SOUL = new Enderman_soul();
        REPAIRING = new Repairing();
        BROKEN_ARMOR = new Broken_Armor().addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "5fA8F46A-388E-11EE-BE56-0242AC120002", Config.getFloat("broken_armor.value"), EntityAttributeModifier.Operation.ADDITION);
        SOLID_BODY = new Solid_Body().addAttributeModifier(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, "4AD16B22-3892-11EE-BE56-0242AC120002", Config.getFloat("solid_body.value"), EntityAttributeModifier.Operation.ADDITION);
        PURITY = new Purity();
        ANTIDOTE = new Antidote();
        GRAVITATION = new Gravitation();
        DIAMOND_SKIN = new Diamond_skin().addAttributeModifier(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, "949E9B54-3C92-11EE-BE56-0242AC120002", Config.getFloat("diamond_skin.value"), EntityAttributeModifier.Operation.ADDITION);
        VULNERABILITY = new Vulnerability();
        CORROSION = new Corrosion();
        MAGIC_FOCUS = new MagicFocus();
        MAGIC_INHIBITION = new MagicInhibition();
        COUNTER = new Counter();
        COMBUSTION = new Combustion();
        LIGHTNING = new Lightning();
        IRON_SKIN = new Iron_skin().addAttributeModifier(EntityAttributes.GENERIC_ARMOR, "0347065A-492B-11EE-BE56-0242AC120002", Config.getFloat("iron_skin.value"), EntityAttributeModifier.Operation.ADDITION);
        MAGIC_SHIELDING = new Magic_Shielding();
        INMORTALITY = new Inmortality();
    }
}
