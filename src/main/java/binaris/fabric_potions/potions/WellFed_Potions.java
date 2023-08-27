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

public class WellFed_Potions extends Potion {

    public static Potion WELL_FED;
    public static Potion LONG_WELL_FED;
    public WellFed_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("well_fed_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("well_fed.enable", true)){
            WELL_FED = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "well_fed_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.WELL_FED, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.PUMPKIN_PIE, WELL_FED);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_well_fed_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("well_fed.enable", true)){
            LONG_WELL_FED = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_well_fed_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.WELL_FED, 9600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(WELL_FED, Items.REDSTONE, LONG_WELL_FED);
        }
    }
}
