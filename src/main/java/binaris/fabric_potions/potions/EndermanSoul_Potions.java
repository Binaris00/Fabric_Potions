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

public class EndermanSoul_Potions extends Potion {
    public static Potion ENDERMAN_SOUL;
    public EndermanSoul_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("enderman_soul_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("enderman_soul.enable", true)){
            ENDERMAN_SOUL = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "enderman_soul_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.ENDERMAN_SOUL, 1)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.ENDER_PEARL, ENDERMAN_SOUL);
        }
    }
}