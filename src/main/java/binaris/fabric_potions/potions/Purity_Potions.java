package binaris.fabric_potions.potions;

import binaris.fabric_potions.Fabric_Potions;
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

public class Purity_Potions extends Potion {
    public static Potion PURITY;
    public static Potion LONG_PURITY;

    public Purity_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("purity_potion.enable", true)){
            PURITY = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "purity_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.PURITY, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.FIRE_RESISTANCE, Items.CHARCOAL, PURITY);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_purity_potion.enable", true)){
            LONG_PURITY = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_purity_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.PURITY, 9600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.LONG_FIRE_RESISTANCE, Items.CHARCOAL, LONG_PURITY);
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(PURITY, Items.REDSTONE, LONG_PURITY);
        }
    }
}
