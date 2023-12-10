package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_Potions_EffectConfig;
import binaris.fabric_potions.registry.FP_Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Bleed extends StatusEffect {
    public Bleed() {
        super(StatusEffectCategory.HARMFUL, 41099030);

        if(Fabric_Potions_EffectConfig.CONFIG.getOrDefault("bleed.enable", true)){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "bleed"), this);
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(this == FP_Effects.BLEED){
            if(entity.getWorld().getTime() % Fabric_Potions_EffectConfig.CONFIG.getOrDefault("bleed.time", 40) / (entity.getStatusEffect(FP_Effects.BLEED).getAmplifier() + 1) == 0){
                entity.damage(entity.getDamageSources().magic(), (float) Fabric_Potions_EffectConfig.CONFIG.getOrDefault("bleed.damage", 3.0F) + entity.getStatusEffect(FP_Effects.BLEED).getAmplifier());
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
