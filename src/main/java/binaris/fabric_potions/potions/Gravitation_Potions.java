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

public class Gravitation_Potions extends Potion {
    public static Potion GRAVITATION;
    public static Potion LONG_GRAVITATION;
    public static Potion STRONG_GRAVITATION;

    public Gravitation_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("gravitation_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("gravitation.enable", true)){
            GRAVITATION = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "gravitation_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.GRAVITATION, 1200, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.SHULKER_SHELL, GRAVITATION);
        }
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_gravitation_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("gravitation.enable", true)){
            LONG_GRAVITATION = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_gravitation_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.GRAVITATION, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(GRAVITATION, Items.REDSTONE, LONG_GRAVITATION);
        }
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("strong_gravitation_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("gravitation.enable", true)){
            STRONG_GRAVITATION = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "strong_gravitation"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.GRAVITATION, 1000, 1)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(GRAVITATION, Items.GLOWSTONE_DUST, STRONG_GRAVITATION);
        }
    }
}
