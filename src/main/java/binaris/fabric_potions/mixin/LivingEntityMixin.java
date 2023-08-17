package binaris.fabric_potions.mixin;

import binaris.fabric_potions.registry.Fabric_PotionsEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Unique
    LivingEntity livingEntity = (LivingEntity) (Object) (this);


    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    @ModifyVariable(method = "travel", at = @At("STORE"))
    private double inject(double q, Vec3d vec3d6){
        if(this.hasStatusEffect(Fabric_PotionsEffects.GRAVITATION)){
            if(livingEntity instanceof PlayerEntity player && player.isSneaking()){
                switch(livingEntity.getStatusEffect(Fabric_PotionsEffects.GRAVITATION).getAmplifier()){
                    case 0 -> {q += -0.06;}
                    case 1 -> {q += -0.055;}
                    default -> {q += -0.05;}
                }
            }
            else{
                switch(livingEntity.getStatusEffect(Fabric_PotionsEffects.GRAVITATION).getAmplifier()){
                    case 0 -> {q += -0.085;}
                    case 1 -> {q += -0.089;}
                    default -> {q += -0.091;}
                }
            }
        }

        return q;
    }
    @Inject(at = @At("HEAD"), method = "tickMovement")
    public void fallDamage(CallbackInfo ci){
        if(livingEntity.hasStatusEffect(Fabric_PotionsEffects.GRAVITATION)){
            livingEntity.onLanding();
        }
    }
}
