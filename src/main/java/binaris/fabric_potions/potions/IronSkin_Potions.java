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

public class IronSkin_Potions extends Potion {
    public static Potion IRON_SKIN;
    public static Potion LONG_IRON_SKIN;
    public IronSkin_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("iron_skin_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("iron_skin.enable", true)){
            IRON_SKIN = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "iron_skin_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.IRON_SKIN, 900, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(BrokenArmor_Potions.BROKEN_ARMOR, Items.GOLD_INGOT, IRON_SKIN);
        }

        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_iron_skin_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("iron_skin.enable", true)){
            LONG_IRON_SKIN = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_iron_skin_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.IRON_SKIN, 1800, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(IRON_SKIN, Items.REDSTONE, LONG_IRON_SKIN);
        }
    }
}
