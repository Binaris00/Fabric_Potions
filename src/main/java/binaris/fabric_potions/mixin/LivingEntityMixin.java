package binaris.fabric_potions.mixin;

import binaris.fabric_potions.config.Fabric_Potions_EffectConfig;
import binaris.fabric_potions.registry.Fabric_PotionsEffects;
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

    @Unique
    LivingEntity livingEntity = (LivingEntity) (Object) (this);


    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    @ModifyVariable(method = "travel", at = @At("STORE"))
    private double inject(double q, Vec3d vec3d6){
        // Gravitation
        if(this.hasStatusEffect(Fabric_PotionsEffects.GRAVITATION)){
            if(livingEntity instanceof PlayerEntity player && player.isSneaking()){
                switch(livingEntity.getStatusEffect(Fabric_PotionsEffects.GRAVITATION).getAmplifier()){
                    case 0 -> q -= 0.06;
                    case 1 -> q -= 0.055;
                    default -> q -= 0.05;
                }
            }
            else{
                switch(livingEntity.getStatusEffect(Fabric_PotionsEffects.GRAVITATION).getAmplifier()){
                    case 0 -> q -= 0.085;
                    case 1 -> q -= 0.089;
                    default -> q -= 0.091;
                }
            }
        }
        return q;
    }
    @Inject(at = @At("HEAD"), method = "tickMovement")
    public void fallDamage(CallbackInfo ci){
        // Gravitation
        if(livingEntity.hasStatusEffect(Fabric_PotionsEffects.GRAVITATION)){
            livingEntity.onLanding();
        }
    }

    @Inject(at = @At("TAIL"), method = "modifyAppliedDamage", cancellable = true)
    public void moreDamage(DamageSource source, float amount, CallbackInfoReturnable<Float> cir){
        float newAmount = cir.getReturnValue();
        LivingEntity attacker = (LivingEntity) source.getAttacker();

        // Vulnerability
        if(livingEntity.hasStatusEffect(Fabric_PotionsEffects.VULNERABILITY)){
            newAmount += (cir.getReturnValue() + (cir.getReturnValue() * (0.2 * livingEntity.getStatusEffect(Fabric_PotionsEffects.VULNERABILITY).getAmplifier() + 1)));
        }

        // Magic focus
        if((source.isOf(DamageTypes.INDIRECT_MAGIC) && livingEntity.hasStatusEffect(Fabric_PotionsEffects.MAGIC_FOCUS)) || (source.isOf(DamageTypes.MAGIC) && livingEntity.hasStatusEffect(Fabric_PotionsEffects.MAGIC_FOCUS))){
            newAmount += (livingEntity.getStatusEffect(Fabric_PotionsEffects.MAGIC_FOCUS).getAmplifier() + 1) * Fabric_Potions_EffectConfig.CONFIG.getOrDefault("magic_focus.damage",2.0F);
        }

        // Magic inhibition
        if((source.isOf(DamageTypes.INDIRECT_MAGIC) && livingEntity.hasStatusEffect(Fabric_PotionsEffects.MAGIC_FOCUS)) || (source.isOf(DamageTypes.MAGIC) && livingEntity.hasStatusEffect(Fabric_PotionsEffects.MAGIC_INHIBITION))){
            newAmount -= (livingEntity.getStatusEffect(Fabric_PotionsEffects.MAGIC_FOCUS).getAmplifier() + 1) * Fabric_Potions_EffectConfig.CONFIG.getOrDefault("magic_inhibition.damage",2.0F);
        }

        // Counter
        if(livingEntity.hasStatusEffect(Fabric_PotionsEffects.COUNTER)){
            attacker.damage(attacker.getDamageSources().indirectMagic(attacker, livingEntity), (float) (newAmount * 0.2) + livingEntity.getStatusEffect(Fabric_PotionsEffects.COUNTER).getAmplifier() + 1);
        }

        //Magic Shielding
        if(attacker != null) {
            if (attacker.hasStatusEffect(Fabric_PotionsEffects.MAGIC_SHIELDING) && source.isOf(DamageTypes.INDIRECT_MAGIC) || attacker.hasStatusEffect(Fabric_PotionsEffects.MAGIC_SHIELDING) && source.isOf(DamageTypes.MAGIC)) {
                newAmount -= ((attacker.getStatusEffect(Fabric_PotionsEffects.MAGIC_SHIELDING).getAmplifier() + 1) * Fabric_Potions_EffectConfig.CONFIG.getOrDefault("magic_shielding.damage", 3.0F));
            }
        }
        cir.setReturnValue(newAmount);
    }
}
