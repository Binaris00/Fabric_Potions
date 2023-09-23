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

public class Counter_Potions extends Potion {

    public static Potion COUNTER;
    public static Potion LONG_COUNTER;

    public Counter_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("counter_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("counter.enable", true)){
            COUNTER = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "counter_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.COUNTER, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.CHARCOAL, COUNTER);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_counter_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("counter.enable", true)){
            LONG_COUNTER = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_counter_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.COUNTER, 9600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(COUNTER, Items.REDSTONE, LONG_COUNTER);
        }
    }
}
