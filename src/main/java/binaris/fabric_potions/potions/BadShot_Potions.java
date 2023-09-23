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

public class BadShot_Potions extends Potion {
    public static Potion BADSHOT;

    public static Potion LONG_BADSHOT;

    public BadShot_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("badshot_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("badshot.enable", true)){
            BADSHOT = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "badshot_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.BADSHOT, 1800, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(PerfectShot_Potions.PERFECTSHOT, Items.FERMENTED_SPIDER_EYE, BADSHOT);
        }
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_badshot_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("badshot.enable", true)){
            LONG_BADSHOT = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_badshot_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.BADSHOT, 4800, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(BADSHOT, Items.REDSTONE, LONG_BADSHOT);
        }

    }

}
