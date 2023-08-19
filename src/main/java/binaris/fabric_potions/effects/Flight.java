package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_Potions_EffectConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class Flight extends StatusEffect {
    public Flight() {
        super(StatusEffectCategory.BENEFICIAL, 151237252);

        if(Fabric_Potions_EffectConfig.CONFIG.getOrDefault("flight.enable", false)){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "flight"), this);
        }
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if(entity instanceof ServerPlayerEntity serverPlayerEntity){
            serverPlayerEntity.getAbilities().allowFlying = true;
            serverPlayerEntity.sendAbilitiesUpdate();
        }
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if(entity instanceof ServerPlayerEntity serverPlayerEntity){
            if(!serverPlayerEntity.isCreative()) {
                serverPlayerEntity.getAbilities().allowFlying = false;
                serverPlayerEntity.getAbilities().flying = false;
                serverPlayerEntity.sendAbilitiesUpdate();
            }
        }
    }

}
