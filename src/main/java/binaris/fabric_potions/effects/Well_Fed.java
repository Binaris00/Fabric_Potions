package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_PotionsConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Well_Fed extends StatusEffect {
    public Well_Fed() {
        super(StatusEffectCategory.BENEFICIAL, 21214719);

        if(Fabric_PotionsConfig.CONFIG.getOrDefault("well_fed.enable", true)){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "well_fed"), this);
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            if(entity.getWorld().getTime() % 40 == 0) {
                player.getHungerManager().add(amplifier + 1, 0.0F);
            }
        }
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {return true;}
}
