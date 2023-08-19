package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_Potions_EffectConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.event.GameEvent;

public class Enderman_essence extends StatusEffect {
    public Enderman_essence() {
        super(StatusEffectCategory.NEUTRAL, 15619171);

        if(Fabric_Potions_EffectConfig.CONFIG.getOrDefault("enderman_essence.enable", true)){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "enderman_essence"), this);
        }
    }

    @Override
    public boolean isInstant() {
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        double d = entity.getX();
        double e = entity.getY();
        double f = entity.getZ();

        for (int i = 0; i < 16; ++i) {
            double g = entity.getX() + (entity.getRandom().nextDouble() - 0.5) * Fabric_Potions_EffectConfig.CONFIG.getOrDefault("enderman_essence.radius", 128.0);
            double h = MathHelper.clamp(entity.getY() + (double) (entity.getRandom().nextInt(16) - 8), (double) entity.getWorld().getBottomY(), (double) (entity.getWorld().getBottomY() + ((ServerWorld) entity.getWorld()).getLogicalHeight() - 1));
            double j = entity.getZ() + (entity.getRandom().nextDouble() - 0.5) * Fabric_Potions_EffectConfig.CONFIG.getOrDefault("enderman_essence.radius", 128.0);
            if (entity.hasVehicle()) {
                entity.stopRiding();
            }

            Vec3d vec3d = entity.getPos();
            if (entity.teleport(g, h, j, true)) {
                entity.getWorld().emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(entity));
                entity.getWorld().playSound(null, d, e, f, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                entity.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
                break;
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {return true;}
}
