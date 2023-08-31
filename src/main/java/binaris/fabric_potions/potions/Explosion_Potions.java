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

public class Explosion_Potions extends Potion {

    public static Potion EXPLOSION;

    public Explosion_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("explosion_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("explosion.enable", true)){
            EXPLOSION = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "explosion_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.EXPLOSION, 1)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Burst_Potions.BURST, Items.FERMENTED_SPIDER_EYE, EXPLOSION);
        }
    }
}
