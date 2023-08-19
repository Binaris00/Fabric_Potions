package binaris.fabric_potions.config;

import com.mojang.datafixers.util.Pair;

public class Fabric_Potions_Potions {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of("Fabric_Potions_PotionsConfig").provider(configs).request();
    }

    private static void createConfigs() {
        configs.addComment("Antidote potion");
        configs.addKeyValuePair(new Pair<>("antidote_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Long antidote potion");
        configs.addKeyValuePair(new Pair<>("long_antidote_potion.enable", true), "boolean");
    }
}
