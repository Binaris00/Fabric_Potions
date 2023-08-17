package binaris.fabric_potions.registry;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Fabric_PotionsEffectsPotions {

    public static Potion HASTE_POTION = Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "haste_potion"), new Potion(new StatusEffectInstance(StatusEffects.HASTE, 3600, 1)));

    public static void registerPotions(){
    }


    public static void registerPotionsRecipes(){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, Items.FEATHER, Fabric_PotionsEffectsPotions.HASTE_POTION);
    }
}
