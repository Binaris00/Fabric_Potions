package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_PotionsConfig;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Klutz extends StatusEffect {
    public Klutz() {
        super(StatusEffectCategory.HARMFUL, 64102100);

        if(Fabric_PotionsConfig.CONFIG.getOrDefault("klutz.enable", true)){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "klutz"), this);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {return true;}
}
