package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_Potions_EffectConfig;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Launch extends StatusEffect {
    public Launch() {
        super(StatusEffectCategory.NEUTRAL, 0xf8ffb0);

        if(Fabric_Potions_EffectConfig.CONFIG.getOrDefault("launch.enable", true)){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "launch"), this);
        }
    }
}
