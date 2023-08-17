package binaris.fabric_potions.potions;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_PotionsConfig;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Haste_Potions extends Potion {

    public Haste_Potions(){
        if(Fabric_PotionsConfig.CONFIG.getOrDefault("haste_potion.enable", false)){
            Registry.register(Registries.POTION, new Identifier(Fabric_Potions.MOD_ID, "haste_potion"), new Potion(new StatusEffectInstance(StatusEffects.HASTE, 3600, 1)));
        }


    }
}
