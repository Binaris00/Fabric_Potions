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

public class DiamondSkin_Potions extends Potion {
    public static Potion DIAMOND_SKIN;
    public static Potion LONG_DIAMOND_SKIN;

    public DiamondSkin_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("diamond_skin_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("diamond_skin.enable", true)){
            DIAMOND_SKIN = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "diamond_skin_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.DIAMOND_SKIN, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.DIAMOND, DIAMOND_SKIN);
        }


        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_diamond_skin_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("diamond_skin.enable", true)){
            LONG_DIAMOND_SKIN = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_diamond_skin_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.DIAMOND_SKIN, 9600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(DIAMOND_SKIN, Items.REDSTONE, LONG_DIAMOND_SKIN);
        }
    }
}
