package binaris.fabric_potions.mixin;

import binaris.fabric_potions.config.Fabric_Potions_EffectConfig;
import binaris.fabric_potions.registry.FP_Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.hit.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PersistentProjectileEntity.class)
public abstract class PersistentProjectileMixin {
    @Unique
    PersistentProjectileEntity persistentProjectileEntity = (PersistentProjectileEntity) (Object) this;
    @Inject(at = @At("HEAD"), method = "onEntityHit")
    public void FP_checkDamage(EntityHitResult entityHitResult, CallbackInfo ci){
        if(persistentProjectileEntity.getOwner() instanceof LivingEntity user && persistentProjectileEntity instanceof ArrowEntity){

            //True Shot
            // Increase the damage
            if(user.hasStatusEffect(FP_Effects.PERFECTSHOT)) {
                persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() + user.getStatusEffect(FP_Effects.PERFECTSHOT).getAmplifier() + Fabric_Potions_EffectConfig.CONFIG.getOrDefault("perfectshot.base_damage", 1.3));
            }

            //BadShot
            // Decrease the damage
            if(user.hasStatusEffect(FP_Effects.BADSHOT)){
                if (user.getStatusEffect(FP_Effects.BADSHOT).getAmplifier() == 0) {
                    persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() - Fabric_Potions_EffectConfig.CONFIG.getOrDefault("badshot.reduce_damage", 0.55));
                } else {
                    persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() - Fabric_Potions_EffectConfig.CONFIG.getOrDefault("badshot.reduce_damage", 0.55) * 2);
                }
            }
        }
    }
}
