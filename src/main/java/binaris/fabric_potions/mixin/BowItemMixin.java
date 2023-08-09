package binaris.fabric_potions.mixin;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_PotionsConfig;
import binaris.fabric_potions.registry.Fabric_PotionsEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BowItem.class)
public class BowItemMixin {

    @Inject(method = "onStoppedUsing", at =
    @At(value = "INVOKE",
            target = "Lnet/minecraft/entity/projectile/PersistentProjectileEntity;setVelocity(Lnet/minecraft/entity/Entity;FFFFF)V",
            shift = At.Shift.AFTER

    ),
            locals = LocalCapture.CAPTURE_FAILSOFT
    )
    public void setPersistentProjectileEntity(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo ci, PlayerEntity playerEntity, boolean bl, ItemStack itemStack, int i, float f, boolean bl2, ArrowItem arrowItem, PersistentProjectileEntity persistentProjectileEntity){

        //True Shot
        if(user.hasStatusEffect(Fabric_PotionsEffects.TRUESHOT)){
            persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() *
                    Fabric_PotionsConfig.CONFIG.getOrDefault("trueshot.base_damage", 1.15F) + user.getStatusEffect(Fabric_PotionsEffects.TRUESHOT).getAmplifier());
        }


        //Klutz
        if(user.hasStatusEffect(Fabric_PotionsEffects.KLUTZ)){
            Fabric_Potions.LOGGER.info("Damage: " + persistentProjectileEntity.getDamage());
            switch (user.getStatusEffect(Fabric_PotionsEffects.KLUTZ).getAmplifier()){
                case 0 -> persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() - Fabric_PotionsConfig.CONFIG.getOrDefault("klutz.reduce_damage", 0.45));

                case 1 -> persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() - Fabric_PotionsConfig.CONFIG.getOrDefault("klutz.reduce_damage", 0.45) * 2);

                default -> persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() - Fabric_PotionsConfig.CONFIG.getOrDefault("klutz.reduce_damage", 0.45) * 3);
            }
            Fabric_Potions.LOGGER.info("Damage: " + persistentProjectileEntity.getDamage());
        }
    }
}
