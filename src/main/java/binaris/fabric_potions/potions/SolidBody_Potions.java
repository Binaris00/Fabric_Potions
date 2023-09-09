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

public class SolidBody_Potions extends Potion {
    public static Potion SOLID_BODY;

    public SolidBody_Potions(){
        if(Fabric_Potions_PotionsConfig.CONFIG.getOrDefault("solid_body_potion.enable", true) && Fabric_Potions_EffectConfig.CONFIG.getOrDefault("solid_body.enable", true)){
            SOLID_BODY = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "solid_body_potion"), new Potion(new StatusEffectInstance(Fabric_PotionsEffects.SOLID_BODY, 2400, 0)));
            BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.IRON_NUGGET, SOLID_BODY);
        }
    }
}
