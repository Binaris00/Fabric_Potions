package binaris.fabric_potions;

import binaris.fabric_potions.config.Fabric_PotionsConfig;
import binaris.fabric_potions.registry.Fabric_PotionsEffects;
import binaris.fabric_potions.registry.Fabric_PotionsEffectsPotions;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fabric_Potions implements ModInitializer {

	public static final String MOD_ID = "fabric_potions";
    public static final Logger LOGGER = LoggerFactory.getLogger("fabric_potions");

	@Override
	public void onInitialize() {
		Fabric_PotionsConfig.registerConfigs();
		Fabric_PotionsEffects.registerEffects();

		Fabric_PotionsEffectsPotions.registerPotions();
		Fabric_PotionsEffectsPotions.registerPotionsRecipes();

		LOGGER.info("Loading Fabric Potions");
	}
}