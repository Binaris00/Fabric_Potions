package binaris.fabric_potions.mixin;

import binaris.fabric_potions.config.Fabric_PotionsConfig;
import binaris.fabric_potions.registry.Fabric_PotionsEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PersistentProjectileEntity.class)
public class PersistentProjectileMixin {
    @Unique
    PersistentProjectileEntity persistentProjectileEntity = (PersistentProjectileEntity) (Object) this;

    @Inject(at = @At("HEAD"), method = "tick")
    public void checkTick(CallbackInfo ci){
        if(persistentProjectileEntity.getOwner() instanceof LivingEntity user && persistentProjectileEntity instanceof ArrowEntity){

            //True Shot
            if(user.hasStatusEffect(Fabric_PotionsEffects.TRUESHOT)){
                persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() *
                        Fabric_PotionsConfig.CONFIG.getOrDefault("trueshot.base_damage", 1.15F) + user.getStatusEffect(Fabric_PotionsEffects.TRUESHOT).getAmplifier());
            }

            //Klutz
            if(user.hasStatusEffect(Fabric_PotionsEffects.KLUTZ)){
                switch (user.getStatusEffect(Fabric_PotionsEffects.KLUTZ).getAmplifier()){
                    case 0 -> persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() - Fabric_PotionsConfig.CONFIG.getOrDefault("klutz.reduce_damage", 0.45));

                    case 1 -> persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() - Fabric_PotionsConfig.CONFIG.getOrDefault("klutz.reduce_damage", 0.45) * 2);

                    default -> persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() - Fabric_PotionsConfig.CONFIG.getOrDefault("klutz.reduce_damage", 0.45) * 3);
                }
            }
        }
    }

}
