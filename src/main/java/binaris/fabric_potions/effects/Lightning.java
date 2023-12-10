package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class Lightning extends StatusEffect {
    public Lightning() {
        super(StatusEffectCategory.HARMFUL, 0x3bffe5);

        if(Config.getBool("lightning.enable")){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "lightning"), this);
        }
    }

    @Override
    public boolean isInstant() {return true;}

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {return true;}

    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(target.getWorld());
        lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(target.getBlockPos()));
        target.getWorld().spawnEntity(lightningEntity);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(entity.getWorld());
        lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(entity.getBlockPos()));
        entity.getWorld().spawnEntity(lightningEntity);
    }
}
