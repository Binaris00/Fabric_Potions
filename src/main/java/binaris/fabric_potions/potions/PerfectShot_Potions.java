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

public class PerfectShot_Potions extends Potion {
    public static Potion PERFECTSHOT;
    public static Potion LONG_PERFECTSHOT;
    public static Potion STRONG_PERFECTSHOT;

    public PerfectShot_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("perfectshot_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("perfectshot.enable", true)){
            PERFECTSHOT = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "perfectshot_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.PERFECTSHOT, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.FIRE_CHARGE, PERFECTSHOT);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_perfectshot_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("perfectshot.enable", true)){
            LONG_PERFECTSHOT = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_perfectshot_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.PERFECTSHOT, 9600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(PERFECTSHOT, Items.REDSTONE, LONG_PERFECTSHOT);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("strong_perfectshot.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("perfectshot.enable", true)){
            STRONG_PERFECTSHOT = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "strong_perfectshot_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.PERFECTSHOT, 1800, 1)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(PERFECTSHOT, Items.GLOWSTONE_DUST, STRONG_PERFECTSHOT);
        }
    }
}
