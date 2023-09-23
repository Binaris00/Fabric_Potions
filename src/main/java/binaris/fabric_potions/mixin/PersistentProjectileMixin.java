package binaris.fabric_potions.mixin;

import binaris.fabric_potions.config.Fabric_Potions_EffectConfig;
import binaris.fabric_potions.registry.Fabric_PotionsEffects;
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
public class PersistentProjectileMixin {
    @Unique
    PersistentProjectileEntity persistentProjectileEntity = (PersistentProjectileEntity) (Object) this;
    @Inject(at = @At("HEAD"), method = "onEntityHit")
    public void checkDamage(EntityHitResult entityHitResult, CallbackInfo ci){
        if(persistentProjectileEntity.getOwner() instanceof LivingEntity user && persistentProjectileEntity instanceof ArrowEntity){

            //True Shot
            if(user.hasStatusEffect(Fabric_PotionsEffects.PERFECTSHOT)) {
                persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() + user.getStatusEffect(Fabric_PotionsEffects.PERFECTSHOT).getAmplifier() + Fabric_Potions_EffectConfig.CONFIG.getOrDefault("perfectshot.base_damage", 1.3));
            }

            //BadShot
            if(user.hasStatusEffect(Fabric_PotionsEffects.BADSHOT)){
                if (user.getStatusEffect(Fabric_PotionsEffects.BADSHOT).getAmplifier() == 0) {
                    persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() - Fabric_Potions_EffectConfig.CONFIG.getOrDefault("badshot.reduce_damage", 0.55));
                } else {
                    persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() - Fabric_Potions_EffectConfig.CONFIG.getOrDefault("badshot.reduce_damage", 0.55) * 2);
                }
            }
        }
    }
}
