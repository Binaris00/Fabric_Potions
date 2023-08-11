package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Fabric_PotionsConfig;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Solid_Body extends StatusEffect {
    public Solid_Body() {
        super(StatusEffectCategory.BENEFICIAL, 21621946);

        if(Fabric_PotionsConfig.CONFIG.getOrDefault("solid_body.enable", true)){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "solid_body"), this);
        }
    }

}
