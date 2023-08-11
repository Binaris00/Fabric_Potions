package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_PotionsConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Repairing extends StatusEffect {
    public Repairing() {
        super(StatusEffectCategory.BENEFICIAL, 979797);

        if(Fabric_PotionsConfig.CONFIG.getOrDefault("repairing.enable", true)){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "repairing"), this);
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity.getWorld().getTime() % 40 == 0) {
            for (ItemStack stack : entity.getArmorItems()) {
                if (!stack.isEmpty()) {
                    stack.setDamage(stack.getDamage() - amplifier + 1);
                }
            }

            for(ItemStack stack : entity.getHandItems()){
                if (!stack.isEmpty()) {
                    stack.setDamage(stack.getDamage() - amplifier + 1);
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
