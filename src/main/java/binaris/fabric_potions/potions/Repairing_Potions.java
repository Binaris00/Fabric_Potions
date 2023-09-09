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

public class Repairing_Potions extends Potion {
    public static Potion REPAIRING;
    public static Potion LONG_REPAIRING;

    public Repairing_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("repairing_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("repairing.enable", true)){
            REPAIRING = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "repairing_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.REPAIRING, 1200, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.LAPIS_LAZULI, REPAIRING);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_repairing_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("repairing.enable", true)){
            LONG_REPAIRING = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_repairing_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.REPAIRING, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(REPAIRING, Items.REDSTONE, LONG_REPAIRING);
        }
    }
}
