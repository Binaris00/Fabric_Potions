package binaris.fabric_potions.config;

import com.mojang.datafixers.util.Pair;

public class Fabric_Potions_EffectConfig {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of("Fabric_Potions_EffectConfig").provider(configs).request();
    }
    private static void createConfigs() {
        configs.addComment("Antidote effect config");
        configs.addKeyValuePair(new Pair<>("antidote.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Bleed effect config");
        configs.addKeyValuePair(new Pair<>("bleed.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("bleed.time", 40), "tick");
        configs.addKeyValuePair(new Pair<>("bleed.damage", 3.0F), "float");

        configs.emptyLine();

        configs.addComment("Broken armor effect config");
        configs.addKeyValuePair(new Pair<>("broken_armor.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("broken_armor.value", -2.0), "float");

        configs.emptyLine();

        configs.addComment("Burst effect config");
        configs.addKeyValuePair(new Pair<>("burst.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("burst.explosion", 3.0F), "float");

        configs.emptyLine();

        configs.addComment("Corrosion effect config");
        configs.addKeyValuePair(new Pair<>("corrosion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("corrosion.value", 1), "int");

        configs.emptyLine();

        configs.addComment("Diamond Skin effect config");
        configs.addKeyValuePair(new Pair<>("diamond_skin.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("diamond_skin.value", 1.0), "float");

        configs.emptyLine();

        configs.addComment("Enderman essence effect config");
        configs.addKeyValuePair(new Pair<>("enderman_essence.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("enderman_essence.radius", 128.0), "float");

        configs.emptyLine();

        configs.addComment("Explosion effect config");
        configs.addKeyValuePair(new Pair<>("explosion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("explosion.explosion", 4.0F), "float");

        configs.emptyLine();

        configs.addComment("Flight");
        configs.addKeyValuePair(new Pair<>("flight.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Gravitation effect config");
        configs.addKeyValuePair(new Pair<>("gravitation.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Health decrease effect config");
        configs.addKeyValuePair(new Pair<>("health_decrease.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("health_decrease.hearths", -4.0), "hearths (2 hearths)");

        configs.emptyLine();

        configs.addComment("Klutz effect config");
        configs.addKeyValuePair(new Pair<>("klutz.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("klutz.reduce_damage", 0.45), "float");

        configs.emptyLine();

        configs.addComment("Magic Focus effect config");
        configs.addKeyValuePair(new Pair<>("magic_focus.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("magic_focus.damage", 2.0F), "float");

        configs.emptyLine();

        configs.addComment("Magic Inhibition effect config");
        configs.addKeyValuePair(new Pair<>("magic_inhibition.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("magic_inhibition.damage", 2.0F), "float");

        configs.emptyLine();

        configs.addComment("Purity effect config");
        configs.addKeyValuePair(new Pair<>("purity.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Recoil effect config");
        configs.addKeyValuePair(new Pair<>("recoil.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("recoil.value", 0.2), "float");

        configs.emptyLine();

        configs.addComment("Repairing effect config");
        configs.addKeyValuePair(new Pair<>("repairing.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("repairing.value", 1), "int");

        configs.emptyLine();

        configs.addComment("Solid Body effect config");
        configs.addKeyValuePair(new Pair<>("solid_body.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("solid_body.value", 1.0), "float");


        configs.addComment("True Shot effect config");
        configs.addKeyValuePair(new Pair<>("trueshot.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("trueshot.base_damage", 1.3), "float");

        configs.emptyLine();

        configs.addComment("Vulnerability effect config");
        configs.addKeyValuePair(new Pair<>("vulnerability.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Well fed effect config");
        configs.addKeyValuePair(new Pair<>("well_fed.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("well_fed.time", 40), "float");
        configs.addKeyValuePair(new Pair<>("well_fed.value", 1), "int");
    }

}
