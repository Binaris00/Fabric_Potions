package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Corrosion extends StatusEffect {
    public Corrosion() {
        super(StatusEffectCategory.HARMFUL, 13033099);

        if(Config.getBool("corrosion.enable")){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "corrosion"), this);
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity.getWorld().getTime() % 40 == 0) {
            for (ItemStack stack : entity.getArmorItems()) {
                if (!stack.isEmpty()) {
                    stack.setDamage(stack.getDamage() + amplifier + Config.getInt("corrosion.value"));
                }
            }

            for(ItemStack stack : entity.getHandItems()){
                if (!stack.isEmpty()) {
                    stack.setDamage(stack.getDamage() + amplifier + Config.getInt("corrosion.value"));
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
