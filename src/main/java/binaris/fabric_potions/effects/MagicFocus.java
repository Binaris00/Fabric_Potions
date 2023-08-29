package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_Potions_EffectConfig;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MagicFocus extends StatusEffect {
    public MagicFocus() {
        super(StatusEffectCategory.BENEFICIAL, 0x7bc200);

        if(Fabric_Potions_EffectConfig.CONFIG.getOrDefault("magic_focus.enable", true)){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "magic_focus"), this);
        }
    }
}
