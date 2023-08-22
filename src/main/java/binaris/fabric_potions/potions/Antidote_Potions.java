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

public class Antidote_Potions extends Potion{
    public static Potion ANTIDOTE;
    public static Potion LONG_ANTIDOTE;
    public Antidote_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("antidote_potion.enable", true)){
            ANTIDOTE = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "antidote_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.ANTIDOTE, 3600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.FIRE_RESISTANCE, Items.SPIDER_EYE, ANTIDOTE);
        }


        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("long_antidote_potion.enable", true)){
            LONG_ANTIDOTE = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "long_antidote_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.ANTIDOTE, 9600, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.LONG_FIRE_RESISTANCE, Items.SPIDER_EYE, LONG_ANTIDOTE);
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ANTIDOTE, Items.REDSTONE_ORE, LONG_ANTIDOTE);
        }
    }
}