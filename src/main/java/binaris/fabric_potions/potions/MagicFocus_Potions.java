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

public class MagicFocus_Potions extends Potion {
    public static Potion MAGIC_FOCUS;
    public static Potion LONG_MAGIC_FOCUS;
    public static Potion STRONG_MAGIC_FOCUS;
    public MagicFocus_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("magic_focus_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("magic_focus.enable", true)){
            MAGIC_FOCUS = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "magic_focus_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.MAGIC_FOCUS, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.GLOWSTONE_DUST, MAGIC_FOCUS);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_magic_focus_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("magic_focus.enable", true)){
            LONG_MAGIC_FOCUS = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_magic_focus_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.MAGIC_FOCUS, 9600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(MAGIC_FOCUS, Items.REDSTONE, LONG_MAGIC_FOCUS);
        }
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("strong_magic_focus_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("magic_focus.enable", true)){
            STRONG_MAGIC_FOCUS = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "strong_magic_focus_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.MAGIC_FOCUS, 1800, 1)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(MAGIC_FOCUS, Items.GLOWSTONE_DUST, LONG_MAGIC_FOCUS);
        }

    }
}
