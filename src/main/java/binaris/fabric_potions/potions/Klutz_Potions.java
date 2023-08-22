package binaris.fabric_potions.potions;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_Potions_PotionsConfig;
import binaris.fabric_potions.mixin.BrewingRecipeRegistryMixin;
import binaris.fabric_potions.registry.Fabric_PotionsEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Klutz_Potions extends Potion {
    public static Potion KLUTZ;

    public static Potion LONG_KLUTZ;

    public Klutz_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("klutz_potion.enable", true)){
            KLUTZ = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "klutz_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.KLUTZ, 1800, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Trueshot_Potions.TRUESHOT, Items.FERMENTED_SPIDER_EYE, KLUTZ);
        }
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_klutz_potion.enable", true)){
            LONG_KLUTZ = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_klutz_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.KLUTZ, 4800, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(KLUTZ, Items.REDSTONE, LONG_KLUTZ);
        }

    }

}
