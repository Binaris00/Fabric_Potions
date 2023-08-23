package binaris.fabric_potions.config;

import com.mojang.datafixers.util.Pair;

public class Fabric_Potions_PotionsConfig {
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
        configs.addKeyValuePair(new Pair<>("long_antidote_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Purity potion");
        configs.addKeyValuePair(new Pair<>("purity_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_purity_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Bleed potion");
        configs.addKeyValuePair(new Pair<>("bleed_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_bleed_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("strong_bleed_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Trueshot potion");
        configs.addKeyValuePair(new Pair<>("trueshot_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_trueshot_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("strong_trueshot.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Klutz potion");
        configs.addKeyValuePair(new Pair<>("klutz_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_klutz_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Gravitation potion");
        configs.addKeyValuePair(new Pair<>("gravitation_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_gravitation_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("strong_gravitation_potion.enable", true), "boolean");
    }
}
