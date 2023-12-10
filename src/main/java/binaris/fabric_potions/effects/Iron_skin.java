package binaris.fabric_potions.effects;

import binaris.fabric_potions.Fabric_Potions;
import binaris.fabric_potions.config.Config;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Iron_skin extends StatusEffect {
    public Iron_skin() {
        super(StatusEffectCategory.BENEFICIAL, 0xadadad);

        if(Config.getBool("iron_skin.enable")){
            Registry.register(Registries.STATUS_EFFECT, new Identifier(Fabric_Potions.MOD_ID, "iron_skin"), this);
        }

    }
}
