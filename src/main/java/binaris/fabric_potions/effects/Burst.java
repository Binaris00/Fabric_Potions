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
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

public class Burst extends StatusEffect {
    public Burst() {
        super(StatusEffectCategory.NEUTRAL, 0x9c2200);

        if(Fabric_Potions_EffectConfig.CONFIG.getOrDefault("burst.enable", true)){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "burst"), this);
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.playSound(SoundEvents.ENTITY_TNT_PRIMED, 1.0F, 1.0F);

        Explosion explosion = new Explosion(entity.getWorld(), entity, null, null, entity.getX(), entity.getY(), entity.getZ(), (float) Fabric_Potions_EffectConfig.CONFIG.getOrDefault("burst.explosion", 3.0F), false, Explosion.DestructionType.KEEP);
        explosion.collectBlocksAndDamageEntities();
        explosion.affectWorld(true);
    }

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        source.playSound(SoundEvents.ENTITY_TNT_PRIMED, 1.0F, 1.0F);

        Explosion explosion = new Explosion(source.getWorld(), source, null, null, source.getX(), source.getY(), source.getZ(), (float) Fabric_Potions_EffectConfig.CONFIG.getOrDefault("burst.explosion", 3.0F), false, Explosion.DestructionType.KEEP);
        explosion.collectBlocksAndDamageEntities();
        explosion.affectWorld(true);
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
