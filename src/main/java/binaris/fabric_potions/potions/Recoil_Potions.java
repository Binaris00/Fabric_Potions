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

public class Recoil_Potions extends Potion {

    public static Potion RECOIL;
    public static Potion LONG_RECOIL;

    public Recoil_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("recoil_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("recoil.enable", true)){
            RECOIL = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "recoil_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.RECOIL, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.CHARCOAL, RECOIL);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_recoil_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("recoil.enable", true)){
            LONG_RECOIL = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_recoil_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.RECOIL, 9600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(RECOIL, Items.REDSTONE, LONG_RECOIL);
        }
    }
}
