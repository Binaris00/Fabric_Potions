package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_Potions_EffectConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Explosion extends StatusEffect {
    public Explosion() {
        super(StatusEffectCategory.HARMFUL, 0x421512);

        if(Fabric_Potions_EffectConfig.CONFIG.getOrDefault("explosion.enable", true)){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "explosion"), this);
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.playSound(SoundEvents.ENTITY_TNT_PRIMED, 1.0F, 1.0F);

        entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 4.0F, World.ExplosionSourceType.MOB);
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        source.playSound(SoundEvents.ENTITY_TNT_PRIMED, 1.0F, 1.0F);

        source.getWorld().createExplosion(source, source.getX(), source.getY(), source.getZ(), 4.0F, World.ExplosionSourceType.MOB);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean isInstant() {
        return true;
    }
}
