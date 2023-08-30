package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_Potions_EffectConfig;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Recoil extends StatusEffect {
    public Recoil() {
        super(StatusEffectCategory.BENEFICIAL, 0xff8ae2);
        if(Fabric_Potions_EffectConfig.CONFIG.getOrDefault("recoil.enable", true)){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "recoil"), this);
        }
    }
}
