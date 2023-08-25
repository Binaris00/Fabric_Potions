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

public class BrokenArmor_Potions extends Potion {

    public static Potion BROKEN_ARMOR;
    public static Potion LONG_BROKEN_ARMOR;
    public BrokenArmor_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("broken_armor_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("broken_armor.enable", true)){
            BROKEN_ARMOR = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "broken_armor_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.BROKEN_ARMOR, 900, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.IRON_INGOT, BROKEN_ARMOR);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_broken_armor_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("broken_armor.enable", true)){
            LONG_BROKEN_ARMOR = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_broken_armor_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.BROKEN_ARMOR, 1800, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(BROKEN_ARMOR, Items.REDSTONE, LONG_BROKEN_ARMOR);
        }
    }
}
