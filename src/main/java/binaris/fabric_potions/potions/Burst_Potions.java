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

public class Burst_Potions extends Potion {

    public static Potion BURST;

    public Burst_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("burst_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("burst.enable", true)){
            BURST = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "burst_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.BURST, 1)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.TNT, BURST);
        }
    }
}
