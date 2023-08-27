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

public class Flight_Potions extends Potion {
    public static Potion FLIGHT;
    public static Potion LONG_FLIGHT;

    public Flight_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("flight_potion.enable", false) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("flight.enable", true)){
            FLIGHT = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "flight_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.FLIGHT, 1200, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.FEATHER, FLIGHT);
        }
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_flight_potion.enable", false) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("flight.enable", true)){
            LONG_FLIGHT = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_flight_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.FLIGHT, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(FLIGHT, Items.REDSTONE, LONG_FLIGHT);
        }
    }
}