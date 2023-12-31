package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Config;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Health_Decrease extends StatusEffect {
    public Health_Decrease() {
        super(StatusEffectCategory.HARMFUL, 0xff5e5e);

        if(Config.getBool("health_decrease.enable")){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "health_decrease"), this);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {return true;}

}
