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

public class Combustion_Potions extends Potion {
    public static Potion COMBUSTION;
    public static Potion LONG_COMBUSTION;

    public Combustion_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("combustion_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("combustion.enable", true)){
            COMBUSTION = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "combustion_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.COMBUSTION, 600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.FIRE_RESISTANCE, Items.FERMENTED_SPIDER_EYE, COMBUSTION);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_combustion_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("combustion.enable", true)){
            LONG_COMBUSTION = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_combustion_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.COMBUSTION, 1400, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(COMBUSTION, Items.REDSTONE, LONG_COMBUSTION);
        }
    }
}
