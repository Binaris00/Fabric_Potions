package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_Potions_EffectConfig;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Gravitation extends StatusEffect {
    public Gravitation() {
        super(StatusEffectCategory.NEUTRAL, 12202158);

        if(Fabric_Potions_EffectConfig.CONFIG.getOrDefault("gravitation.enable", true)){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "gravitation"), this);
        }
    }
}
