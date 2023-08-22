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
            if(user.hasStatusEffect(Fabric_PotionsEffects.TRUESHOT)) {
                persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() + user.getStatusEffect(Fabric_PotionsEffects.TRUESHOT).getAmplifier() + Fabric_Potions_EffectConfig.CONFIG.getOrDefault("trueshot.base_damage", 1.3));
            }

            //Klutz
            if(user.hasStatusEffect(Fabric_PotionsEffects.KLUTZ)){
                if (user.getStatusEffect(Fabric_PotionsEffects.KLUTZ).getAmplifier() == 0) {
                    persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() - Fabric_Potions_EffectConfig.CONFIG.getOrDefault("klutz.reduce_damage", 0.45));
                } else {
                    persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() - Fabric_Potions_EffectConfig.CONFIG.getOrDefault("klutz.reduce_damage", 0.45) * 2);
                }
            }
        }
    }
}
