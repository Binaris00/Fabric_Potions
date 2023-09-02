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

public class MagicShielding_Potions extends Potion {
    public static Potion MAGIC_SHIELDING;
    public static Potion LONG_MAGIC_SHIELDING;

    public MagicShielding_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("magic_shielding_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("magic_shielding.enable", true)){
            MAGIC_SHIELDING = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "magic_shielding_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.MAGIC_SHIELDING, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(MagicFocus_Potions.MAGIC_FOCUS, Items.IRON_INGOT, MAGIC_SHIELDING);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_magic_shielding_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("magic_shielding.enable", true)){
            LONG_MAGIC_SHIELDING = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_magic_shielding_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.MAGIC_SHIELDING, 9600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(MAGIC_SHIELDING, Items.REDSTONE, LONG_MAGIC_SHIELDING);
        }
    }
}
