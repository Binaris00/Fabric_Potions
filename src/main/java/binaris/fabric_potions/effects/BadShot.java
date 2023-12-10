package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Config;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BadShot extends StatusEffect {
    public BadShot() {
        super(StatusEffectCategory.HARMFUL, 0xff4800);

        if(Config.getBool("badshot.enable")){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "badshot"), this);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {return true;}
}
