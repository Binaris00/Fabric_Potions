package binaris.fabric_potions.registry;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_Potions_PotionsConfig;
import binaris.fabric_potions.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class FB_Potions {
    public static Potion ANTIDOTE;
    public static Potion LONG_ANTIDOTE;
    public static Potion BADSHOT;
    public static Potion LONG_BADSHOT;
    public static Potion BLEED;
    public static Potion LONG_BLEED;
    public static Potion STRONG_BLEED;
    public static Potion BROKEN_ARMOR;
    public static Potion LONG_BROKEN_ARMOR;
    public static Potion COMBUSTION;
    public static Potion LONG_COMBUSTION;
    public static Potion CORROSION;
    public static Potion LONG_CORROSION;
    public static Potion PERFECTSHOT;
    public static Potion LONG_PERFECTSHOT;
    public static Potion STRONG_PERFECTSHOT;
    public static Potion REPAIRING;
    public static Potion LONG_REPAIRING;
    public static Potion COUNTER;
    public static Potion LONG_COUNTER;
    public static Potion DIAMOND_SKIN;
    public static Potion LONG_DIAMOND_SKIN;
    public static Potion ENDERMAN_SOUL;
    public static Potion GRAVITATION;
    public static Potion LONG_GRAVITATION;
    public static Potion STRONG_GRAVITATION;
    public static Potion HEALTH_DECREASE;
    public static Potion LONG_HEALTH_DECREASE;
    public static Potion IRON_SKIN;
    public static Potion LONG_IRON_SKIN;
    public static Potion LIGHTNING;
    public static Potion MAGIC_FOCUS;
    public static Potion LONG_MAGIC_FOCUS;
    public static Potion STRONG_MAGIC_FOCUS;
    public static Potion MAGIC_INHIBITION;
    public static Potion LONG_MAGIC_INHIBITION;
    public static Potion STRONG_MAGIC_INHIBITION;
    public static Potion MAGIC_SHIELDING;
    public static Potion LONG_MAGIC_SHIELDING;
    public static Potion PURITY;
    public static Potion LONG_PURITY;
    public static Potion SOLID_BODY;
    public static Potion VULNERABILITY;
    public static Potion LONG_VULNERABILITY;
    public static Potion STRONG_VULNERABILITY;
    public static Potion WELL_FED;
    public static Potion LONG_WELL_FED;

    public static void registerPotions(){
        ANTIDOTE = registerPotion("antidote_potion", new StatusEffectInstance(FP_Effects.ANTIDOTE, 3600, 0));
        registerRecipe(Potions.FIRE_RESISTANCE, Items.SPIDER_EYE, ANTIDOTE);

        LONG_ANTIDOTE = registerPotion("long_antidote_potion", new StatusEffectInstance(FP_Effects.ANTIDOTE, 9600, 0));
        registerRecipe(ANTIDOTE, Items.REDSTONE, LONG_ANTIDOTE);

        BADSHOT = registerPotion("badshot_potion", new StatusEffectInstance(FP_Effects.BADSHOT, 1800, 0));
        registerRecipe(PERFECTSHOT, Items.FERMENTED_SPIDER_EYE, BADSHOT);

        LONG_BADSHOT = registerPotion("long_badshot_potion", new StatusEffectInstance(FP_Effects.BADSHOT, 4800, 0));
        registerRecipe(BADSHOT, Items.REDSTONE, LONG_BADSHOT);

        BLEED = registerPotion("bleed_potion", new StatusEffectInstance(FP_Effects.BLEED, 900, 0));
        registerRecipe(Potions.AWKWARD, Items.SWEET_BERRIES, BLEED);

        LONG_BLEED = registerPotion("long_bleed_potion", new StatusEffectInstance(FP_Effects.BLEED, 1800, 0));
        registerRecipe(BLEED, Items.REDSTONE, LONG_BLEED);

        STRONG_BLEED = registerPotion("strong_bleed_potion", new StatusEffectInstance(FP_Effects.BLEED, 820, 1));
        registerRecipe(BLEED, Items.GLOWSTONE_DUST, STRONG_BLEED);

        BROKEN_ARMOR = registerPotion("broken_armor_potion", new StatusEffectInstance(FP_Effects.BROKEN_ARMOR, 900, 0));
        registerRecipe(Potions.AWKWARD, Items.IRON_INGOT, BROKEN_ARMOR);

        LONG_BROKEN_ARMOR = registerPotion("long_broken_armor_potion", new StatusEffectInstance(FP_Effects.BROKEN_ARMOR, 1800, 0));
        registerRecipe(BROKEN_ARMOR, Items.REDSTONE, LONG_BROKEN_ARMOR);

        COMBUSTION = registerPotion("combustion_potion", new StatusEffectInstance(FP_Effects.COMBUSTION, 600, 0));
        registerRecipe(Potions.FIRE_RESISTANCE, Items.FERMENTED_SPIDER_EYE, COMBUSTION);

        LONG_COMBUSTION = registerPotion("long_combustion_potion", new StatusEffectInstance(FP_Effects.COMBUSTION, 1400, 0));
        registerRecipe(COMBUSTION, Items.REDSTONE, LONG_COMBUSTION);

        CORROSION = registerPotion("corrosion_potion", new StatusEffectInstance(FP_Effects.CORROSION, 1200, 0));
        registerRecipe(REPAIRING, Items.FERMENTED_SPIDER_EYE, CORROSION);

        LONG_CORROSION = registerPotion("long_corrosion_potion", new StatusEffectInstance(FP_Effects.CORROSION, 3600, 0));
        registerRecipe(CORROSION, Items.REDSTONE, LONG_CORROSION);

        COUNTER = registerPotion("counter_potion", new StatusEffectInstance(FP_Effects.COUNTER, 3600, 0));
        registerRecipe(Potions.AWKWARD, Items.CHARCOAL, COUNTER);

        LONG_COUNTER = registerPotion("long_counter_potion", new StatusEffectInstance(FP_Effects.COUNTER, 9600, 0));
        registerRecipe(COUNTER, Items.REDSTONE, LONG_COUNTER);

        DIAMOND_SKIN = registerPotion("diamond_skin_potion", new StatusEffectInstance(FP_Effects.DIAMOND_SKIN, 3600, 0));
        registerRecipe(Potions.AWKWARD, Items.DIAMOND, DIAMOND_SKIN);

        LONG_DIAMOND_SKIN = registerPotion("long_diamond_skin_potion", new StatusEffectInstance(FP_Effects.DIAMOND_SKIN, 9600, 0));
        registerRecipe(DIAMOND_SKIN, Items.REDSTONE, LONG_DIAMOND_SKIN);

        ENDERMAN_SOUL = registerPotion("enderman_soul_potion", new StatusEffectInstance(FP_Effects.ENDERMAN_SOUL, 1));
        registerRecipe(Potions.AWKWARD, Items.ENDER_PEARL, ENDERMAN_SOUL);

        GRAVITATION = registerPotion("gravitation_potion", new StatusEffectInstance(FP_Effects.GRAVITATION, 1200, 0));
        registerRecipe(Potions.AWKWARD, Items.SHULKER_SHELL, GRAVITATION);

        LONG_GRAVITATION = registerPotion("long_gravitation_potion", new StatusEffectInstance(FP_Effects.GRAVITATION, 3600, 0));
        registerRecipe(GRAVITATION, Items.REDSTONE, LONG_GRAVITATION);

        STRONG_GRAVITATION = registerPotion("strong_gravitation_potion", new StatusEffectInstance(FP_Effects.GRAVITATION, 1000, 1));
        registerRecipe(GRAVITATION, Items.GLOWSTONE_DUST, STRONG_GRAVITATION);

        HEALTH_DECREASE = registerPotion("health_decrease_potion", new StatusEffectInstance(FP_Effects.HEALTH_DECREASE, 1800, 0));
        registerRecipe(Potions.AWKWARD, Items.ROTTEN_FLESH, HEALTH_DECREASE);

        LONG_HEALTH_DECREASE = registerPotion("long_health_decrease_potion", new StatusEffectInstance(FP_Effects.HEALTH_DECREASE, 4800, 0));
        registerRecipe(HEALTH_DECREASE, Items.REDSTONE, LONG_HEALTH_DECREASE);

        IRON_SKIN = registerPotion("iron_skin_potion", new StatusEffectInstance(FP_Effects.IRON_SKIN, 900, 0));
        registerRecipe(BROKEN_ARMOR, Items.GOLD_INGOT, IRON_SKIN);

        LONG_IRON_SKIN = registerPotion("long_iron_skin_potion", new StatusEffectInstance(FP_Effects.IRON_SKIN, 1800, 0));
        registerRecipe(IRON_SKIN, Items.REDSTONE, LONG_IRON_SKIN);

        LIGHTNING = registerPotion("lightning_potion", new StatusEffectInstance(FP_Effects.LIGHTNING, 1));
        registerRecipe(COMBUSTION, Items.BLAZE_POWDER, LIGHTNING);

        MAGIC_FOCUS = registerPotion("magic_focus_potion", new StatusEffectInstance(FP_Effects.MAGIC_FOCUS, 3600, 0));
        registerRecipe(Potions.AWKWARD, Items.GLOWSTONE_DUST, MAGIC_FOCUS);

        LONG_MAGIC_FOCUS = registerPotion("long_magic_focus_potion", new StatusEffectInstance(FP_Effects.MAGIC_FOCUS, 9600, 0));
        registerRecipe(MAGIC_FOCUS, Items.REDSTONE, LONG_MAGIC_FOCUS);

        STRONG_MAGIC_FOCUS = registerPotion("strong_magic_focus_potion", new StatusEffectInstance(FP_Effects.MAGIC_FOCUS, 1800, 1));
        registerRecipe(MAGIC_FOCUS, Items.GLOWSTONE_DUST, LONG_MAGIC_FOCUS);

        MAGIC_INHIBITION = registerPotion("magic_inhibition_potion", new StatusEffectInstance(FP_Effects.MAGIC_INHIBITION, 3600, 0));
        registerRecipe(MAGIC_FOCUS, Items.FERMENTED_SPIDER_EYE, MAGIC_INHIBITION);

        LONG_MAGIC_INHIBITION = registerPotion("long_magic_inhibition_potion", new StatusEffectInstance(FP_Effects.MAGIC_INHIBITION, 9600, 0));
        registerRecipe(MAGIC_INHIBITION, Items.REDSTONE, LONG_MAGIC_INHIBITION);

        STRONG_MAGIC_INHIBITION = registerPotion("strong_magic_inhibition_potion", new StatusEffectInstance(FP_Effects.MAGIC_INHIBITION, 1800, 1));
        registerRecipe(MAGIC_INHIBITION, Items.GLOWSTONE_DUST, STRONG_MAGIC_INHIBITION);

        MAGIC_SHIELDING = registerPotion("magic_shielding_potion", new StatusEffectInstance(FP_Effects.MAGIC_SHIELDING, 3600, 0));
        registerRecipe(MAGIC_FOCUS, Items.IRON_INGOT, MAGIC_SHIELDING);

        LONG_MAGIC_SHIELDING = registerPotion("long_magic_shielding_potion", new StatusEffectInstance(FP_Effects.MAGIC_SHIELDING, 9600, 0));
        registerRecipe(MAGIC_SHIELDING, Items.REDSTONE, LONG_MAGIC_SHIELDING);

        PERFECTSHOT = registerPotion("perfectshot_potion", new StatusEffectInstance(FP_Effects.PERFECTSHOT, 3600, 0));
        registerRecipe(Potions.AWKWARD, Items.FIRE_CHARGE, PERFECTSHOT);

        LONG_PERFECTSHOT = registerPotion("long_perfectshot_potion", new StatusEffectInstance(FP_Effects.PERFECTSHOT, 9600, 0));
        registerRecipe(PERFECTSHOT, Items.REDSTONE, LONG_PERFECTSHOT);

        STRONG_PERFECTSHOT = registerPotion("strong_perfectshot_potion", new StatusEffectInstance(FP_Effects.PERFECTSHOT, 1800, 1));
        registerRecipe(PERFECTSHOT, Items.GLOWSTONE_DUST, STRONG_PERFECTSHOT);

        PURITY = registerPotion("purity_potion", new StatusEffectInstance(FP_Effects.PURITY, 3600, 0));
        registerRecipe(Potions.FIRE_RESISTANCE, Items.CHARCOAL, PURITY);

        LONG_PURITY = registerPotion("long_purity_potion", new StatusEffectInstance(FP_Effects.PURITY, 9600, 0));
        registerRecipe(PURITY, Items.REDSTONE, LONG_PURITY);

        REPAIRING = registerPotion("repairing_potion", new StatusEffectInstance(FP_Effects.REPAIRING, 1200, 0));
        registerRecipe(Potions.AWKWARD, Items.LAPIS_LAZULI, REPAIRING);

        LONG_REPAIRING = registerPotion("long_repairing_potion", new StatusEffectInstance(FP_Effects.REPAIRING, 3600, 0));
        registerRecipe(REPAIRING, Items.REDSTONE, LONG_REPAIRING);

        SOLID_BODY = registerPotion("solid_body_potion", new StatusEffectInstance(FP_Effects.SOLID_BODY, 2400, 0));
        registerRecipe(Potions.AWKWARD, Items.IRON_NUGGET, SOLID_BODY);

        VULNERABILITY = registerPotion("vulnerability_potion", new StatusEffectInstance(FP_Effects.VULNERABILITY, 3600, 0));
        registerRecipe(Potions.HARMING, Items.FERMENTED_SPIDER_EYE, VULNERABILITY);

        LONG_VULNERABILITY = registerPotion("long_vulnerability_potion", new StatusEffectInstance(FP_Effects.VULNERABILITY, 9600, 0));
        registerRecipe(VULNERABILITY, Items.REDSTONE, LONG_VULNERABILITY);

        STRONG_VULNERABILITY = registerPotion("strong_vulnerability_potion", new StatusEffectInstance(FP_Effects.VULNERABILITY, 1800, 1));
        registerRecipe(VULNERABILITY, Items.GLOWSTONE_DUST, STRONG_VULNERABILITY);

        WELL_FED = registerPotion("well_fed_potion", new StatusEffectInstance(FP_Effects.WELL_FED, 3600, 0));
        registerRecipe(Potions.AWKWARD, Items.PUMPKIN_PIE, WELL_FED);

        LONG_WELL_FED = registerPotion("long_well_fed_potion", new StatusEffectInstance(FP_Effects.WELL_FED, 9600, 0));
        registerRecipe(WELL_FED, Items.REDSTONE, LONG_WELL_FED);
    }


    private static void registerRecipe(Potion input, Item item, Potion output){
        if(output != null){
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(input, item, output);
        }
    }
    @Nullable
    private static Potion registerPotion(String name, StatusEffectInstance statusEffectInstance) {
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault(name+".enable", true)){
            return Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, name), new Potion(statusEffectInstance));
        }
        return null;
    }
}
