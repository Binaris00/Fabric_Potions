package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Config;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MagicInhibition extends StatusEffect {
    public MagicInhibition() {
        super(StatusEffectCategory.HARMFUL, 0x99bf56);

        if(Config.getBool("magic_inhibition.enable")){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "magic_inhibition"), this);
        }
    }
}
