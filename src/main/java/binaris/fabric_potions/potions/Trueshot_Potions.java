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

public class Trueshot_Potions extends Potion {
    public static Potion TRUESHOT;
    public static Potion LONG_TRUESHOT;
    public static Potion STRONG_TRUESHOT;

    public Trueshot_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("trueshot_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("trueshot.enable", true)){
            TRUESHOT = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "trueshot_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.TRUESHOT, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.FIRE_CHARGE, TRUESHOT);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_trueshot_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("trueshot.enable", true)){
            LONG_TRUESHOT = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_trueshot_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.TRUESHOT, 9600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(TRUESHOT, Items.REDSTONE, LONG_TRUESHOT);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("strong_trueshot.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("trueshot.enable", true)){
            STRONG_TRUESHOT = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "strong_trueshot_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.TRUESHOT, 1800, 1)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(TRUESHOT, Items.GLOWSTONE_DUST, STRONG_TRUESHOT);
        }
    }
}
