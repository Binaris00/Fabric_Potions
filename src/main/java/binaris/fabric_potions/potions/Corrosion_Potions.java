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

public class Corrosion_Potions extends Potion {

    public static Potion CORROSION;
    public static Potion LONG_CORROSION;

    public Corrosion_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("corrosion_potion.enable", false) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("corrosion.enable", true)){
            CORROSION = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "corrosion_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.CORROSION, 1200, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Repairing_Potions.REPAIRING, Items.FERMENTED_SPIDER_EYE, CORROSION);
        }
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_corrosion_potion.enable", false) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("corrosion.enable", true)){
            LONG_CORROSION = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_corrosion_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.CORROSION, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(CORROSION, Items.REDSTONE, LONG_CORROSION);
        }

    }
}
