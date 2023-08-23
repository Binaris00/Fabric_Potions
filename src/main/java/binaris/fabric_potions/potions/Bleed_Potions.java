package binaris.fabric_potions.potions;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_Potions_EffectConfig;
import binaris.fabric_potions.config.Fabric_Potions_PotionsConfig;
import binaris.fabric_potions.mixin.BrewingRecipeRegistryMixin;
import binaris.fabric_potions.registry.Fabric_PotionsEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Bleed_Potions extends Potion {

    public static Potion BLEED;
    public static Potion LONG_BLEED;
    public static Potion STRONG_BLEED;

    public Bleed_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("bleed_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("bleed.enable", true)){
            BLEED = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "bleed_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.BLEED, 900, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.SWEET_BERRIES, BLEED);
        }
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_bleed_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("bleed.enable", true)){
            LONG_BLEED = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_bleed_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.BLEED, 1800, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(BLEED, Items.REDSTONE, LONG_BLEED);
        }
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("strong_bleed_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("bleed.enable", true)){
            STRONG_BLEED = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "strong_bleed_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.BLEED, 820, 1)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(BLEED, Items.GLOWSTONE_DUST, STRONG_BLEED);
        }

    }
}
