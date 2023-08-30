package binaris.fabric_potions.potions;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_Potions_EffectConfig;
import binaris.fabric_potions.config.Fabric_Potions_PotionsConfig;
import binaris.fabric_potions.mixin.BrewingRecipeRegistryMixin;
import binaris.fabric_potions.registry.Fabric_PotionsEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MagicInhibition_Potions extends Potion {

    public static Potion MAGIC_INHIBITION;
    public static Potion LONG_MAGIC_INHIBITION;
    public static Potion STRONG_MAGIC_INHIBITION;

    public MagicInhibition_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("magic_inhibition_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("magic_inhibition.enable", true)){
            MAGIC_INHIBITION = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "magic_inhibition_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.MAGIC_INHIBITION, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(MagicFocus_Potions.MAGIC_FOCUS, Items.FERMENTED_SPIDER_EYE, MAGIC_INHIBITION);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_magic_inhibition_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("magic_inhibition.enable", true)){
            LONG_MAGIC_INHIBITION = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_magic_inhibition_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.MAGIC_INHIBITION, 9600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(MAGIC_INHIBITION, Items.REDSTONE, LONG_MAGIC_INHIBITION);
        }
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("strong_magic_inhibition_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("magic_focus.enable", true)){
            STRONG_MAGIC_INHIBITION = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "strong_magic_inhibition_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.MAGIC_INHIBITION, 1800, 1)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(MAGIC_INHIBITION, Items.GLOWSTONE_DUST, STRONG_MAGIC_INHIBITION);
        }

    }
}
