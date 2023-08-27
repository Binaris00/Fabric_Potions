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

public class HealthDecrease_Potions extends Potion {

    public static Potion HEALTH_DECREASE;
    public static Potion LONG_HEALTH_DECREASE;
    public HealthDecrease_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("health_decrease_potion.enable", false) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("health_decrease.enable", true)){
            HEALTH_DECREASE = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "health_decrease_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.HEALTH_DECREASE, 1800, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.ROTTEN_FLESH, HEALTH_DECREASE);
        }
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_health_decrease_potion.enable", false) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("health_decrease.enable", true)){
            LONG_HEALTH_DECREASE = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_health_decrease_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.HEALTH_DECREASE, 4800, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(HEALTH_DECREASE, Items.REDSTONE, LONG_HEALTH_DECREASE);
        }
    }
}
