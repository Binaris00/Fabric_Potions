package binaris.fabric_potions.config;

import binaris.fabric_potions.Fabric_Potions;
import com.mojang.datafixers.util.Pair;

public class Fabric_PotionsConfig {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(Fabric_Potions.MOD_ID + "config").provider(configs).request();
    }
    private static void createConfigs() {
        configs.addComment("Health decrease effect config");
        configs.addKeyValuePair(new Pair<>("health_decrease.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Bleed effect config");
        configs.addKeyValuePair(new Pair<>("bleed.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("True Shot effect config");
        configs.addKeyValuePair(new Pair<>("trueshot.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("trueshot.base_damage", 1.15F), "float");

        configs.emptyLine();

        configs.addComment("Klutz effect config");
        configs.addKeyValuePair(new Pair<>("klutz.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("klutz.reduce_damage", 0.45), "float");

    }

}
