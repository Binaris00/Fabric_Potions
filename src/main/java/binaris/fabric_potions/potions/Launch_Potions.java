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

public class Launch_Potions extends Potion {
    public static Potion LAUNCH;

    public Launch_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("launch_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("lightning.enable", true)){
            LAUNCH = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "launch_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.LAUNCH, 140, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Gravitation_Potions.GRAVITATION, Items.BROWN_MUSHROOM, LAUNCH);
        }
    }
}
