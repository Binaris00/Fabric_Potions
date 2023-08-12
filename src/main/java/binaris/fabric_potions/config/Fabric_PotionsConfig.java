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
        configs.addKeyValuePair(new Pair<>("health_decrease.hearths", -4.0), "hearths (2 hearths)");

        configs.emptyLine();

        configs.addComment("Bleed effect config");
        configs.addKeyValuePair(new Pair<>("bleed.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("bleed.damage", 2.0F), "float");

        configs.emptyLine();

        configs.addComment("True Shot effect config");
        configs.addKeyValuePair(new Pair<>("trueshot.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("trueshot.base_damage", 1.15F), "float");

        configs.emptyLine();

        configs.addComment("Klutz effect config");
        configs.addKeyValuePair(new Pair<>("klutz.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("klutz.reduce_damage", 0.45), "float");

        configs.emptyLine();

        configs.addComment("Enderman essence effect config");
        configs.addKeyValuePair(new Pair<>("enderman_essence_enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Broken armor effect config");
        configs.addKeyValuePair(new Pair<>("broken_armor.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("broken_armor", -2.0), "float");

        configs.emptyLine();

        configs.addComment("Repairing effect config");
        configs.addKeyValuePair(new Pair<>("repairing.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("repairing.value", 1), "int");

        configs.emptyLine();

        configs.addComment("Well fed effect config");
        configs.addKeyValuePair(new Pair<>("well_fed.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("well_fed.value", 1), "int");

        configs.emptyLine();

        configs.addComment("Purity effect config");
        configs.addKeyValuePair(new Pair<>("purity.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Antidote effect config");
        configs.addKeyValuePair(new Pair<>("antidote.enable", true), "boolean");
    }

}
