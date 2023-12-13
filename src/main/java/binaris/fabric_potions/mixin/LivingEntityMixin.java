package binaris.fabric_potions.mixin;

import binaris.fabric_potions.config.Config;
import binaris.fabric_potions.registry.FP_Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
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
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    // This is the entity that has the effect :p
    @Unique
    LivingEntity livingEntity = (LivingEntity) (Object) (this);
    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);
    @ModifyVariable(method = "travel", at = @At("STORE"))
    private double FB_inject(double q, Vec3d vec3d6){
        // Gravitation
        // Change the value of q to change the gravity
        // q = 0.05 is the default value
        if(this.hasStatusEffect(FP_Effects.GRAVITATION)){
            if(livingEntity instanceof PlayerEntity player && player.isSneaking()){
                switch(livingEntity.getStatusEffect(FP_Effects.GRAVITATION).getAmplifier()){
                    case 0 -> q -= 0.06;
                    case 1 -> q -= 0.055;
                    default -> q -= 0.05;
                }
            }
            else{
                switch(livingEntity.getStatusEffect(FP_Effects.GRAVITATION).getAmplifier()){
                    case 0 -> q -= 0.085;
                    case 1 -> q -= 0.089;
                    default -> q -= 0.091;
                }
            }
        }
        return q;
    }
    @Inject(at = @At("HEAD"), method = "tickMovement")
    public void FB_fallDamage(CallbackInfo ci){
        // Gravitation
        // just to make sure that the entity takes fall damage when it has the effect
        if(livingEntity.hasStatusEffect(FP_Effects.GRAVITATION)){
            livingEntity.onLanding();
        }
    }

    @Inject(at = @At("TAIL"), method = "modifyAppliedDamage", cancellable = true)
    public void FP_changeDamage(DamageSource source, float amount, CallbackInfoReturnable<Float> cir){
        float newAmount = cir.getReturnValue();
        LivingEntity attacker = (LivingEntity) source.getAttacker();

        // Vulnerability
        // Changes the value of newAmount to add more damage
        if(livingEntity.hasStatusEffect(FP_Effects.VULNERABILITY)){
            newAmount += (cir.getReturnValue() + (cir.getReturnValue() * (0.2 * livingEntity.getStatusEffect(FP_Effects.VULNERABILITY).getAmplifier() + 1)));
        }

        // Magic focus
        // Changes the value of newAmount to add more damage
        // Not effecting when attacker damages himself
        // to the target
        // only if the damage is indirect magic or magic
        if(attacker != null && attacker != livingEntity) {
            if (attacker.hasStatusEffect(FP_Effects.MAGIC_FOCUS) && source.isOf(DamageTypes.INDIRECT_MAGIC) || attacker.hasStatusEffect(FP_Effects.MAGIC_FOCUS) && source.isOf(DamageTypes.MAGIC)) {
                newAmount += ((attacker.getStatusEffect(FP_Effects.MAGIC_FOCUS).getAmplifier() + 1) * Config.getFloat("magic_focus.damage"));
            }
        }

        // Magic inhibition
        // Changes the value of newAmount to reduce damage done
        // Not effecting when attacker damages himself
        // to the target
        // only if the damage is indirect magic or magic
        if(attacker != null && attacker != livingEntity) {
            if (attacker.hasStatusEffect(FP_Effects.MAGIC_INHIBITION) && source.isOf(DamageTypes.INDIRECT_MAGIC) || attacker.hasStatusEffect(FP_Effects.MAGIC_INHIBITION) && source.isOf(DamageTypes.MAGIC)) {
                newAmount -= ((attacker.getStatusEffect(FP_Effects.MAGIC_INHIBITION).getAmplifier() + 1) * Config.getFloat("magic_inhibition.damage"));
            }
        }

        // Counter
        // Return damage to the attacker
        if(livingEntity.hasStatusEffect(FP_Effects.COUNTER)){
            if(attacker != null) {
                attacker.damage(attacker.getDamageSources().indirectMagic(attacker, livingEntity), (float) (newAmount * 0.2) + livingEntity.getStatusEffect(FP_Effects.COUNTER).getAmplifier() + 1);
            }
        }

        //Magic Shielding
        // Reduces damage done
        if (livingEntity.hasStatusEffect(FP_Effects.MAGIC_SHIELDING) && source.isOf(DamageTypes.INDIRECT_MAGIC) || livingEntity.hasStatusEffect(FP_Effects.MAGIC_SHIELDING) && source.isOf(DamageTypes.MAGIC)) {
            newAmount -= ((livingEntity.getStatusEffect(FP_Effects.MAGIC_SHIELDING).getAmplifier() + 1) * Config.getFloat("magic_shielding.damage"));
        }

        // Inmortality
        // Makes the entity invulnerable
        if(livingEntity.hasStatusEffect(FP_Effects.INMORTALITY)){
            newAmount = 0;
        }
        cir.setReturnValue(newAmount);
    }
}
