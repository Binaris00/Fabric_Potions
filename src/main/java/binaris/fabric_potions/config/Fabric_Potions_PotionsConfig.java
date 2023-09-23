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

        configs.addComment("BadShot potion");
        configs.addKeyValuePair(new Pair<>("badshot_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_badshot_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Bleed potion");
        configs.addKeyValuePair(new Pair<>("bleed_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_bleed_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("strong_bleed_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Broken armor potion");
        configs.addKeyValuePair(new Pair<>("broken_armor_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_broken_armor_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Corrosion potion (Disabled by default)");
        configs.addKeyValuePair(new Pair<>("corrosion_potion.enable", false), "boolean");
        configs.addKeyValuePair(new Pair<>("long_corrosion_potion.enable", false), "boolean");

        configs.emptyLine();

        configs.addComment("Counter potion");
        configs.addKeyValuePair(new Pair<>("counter_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_counter_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Diamond skin potion");
        configs.addKeyValuePair(new Pair<>("diamond_skin_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_diamond_skin_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Enderman soul potion");
        configs.addKeyValuePair(new Pair<>("enderman_soul_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Flight potion (Disabled by default)");
        configs.addKeyValuePair(new Pair<>("flight_potion.enable", false), "boolean");
        configs.addKeyValuePair(new Pair<>("long_flight_potion.enable", false), "boolean");

        configs.emptyLine();

        configs.addComment("Gravitation potion");
        configs.addKeyValuePair(new Pair<>("gravitation_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_gravitation_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("strong_gravitation_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Health Decrease potion (Disabled by default)");
        configs.addKeyValuePair(new Pair<>("health_decrease_potion.enable", false), "boolean");
        configs.addKeyValuePair(new Pair<>("long_health_decrease_potion.enable", false), "boolean");

        configs.emptyLine();

        configs.addComment("Iron skin potion");
        configs.addKeyValuePair(new Pair<>("iron_skin.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_iron_skin.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Lightning potion");
        configs.addKeyValuePair(new Pair<>("lightning_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Magic focus potion");
        configs.addKeyValuePair(new Pair<>("magic_focus_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_magic_focus_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("strong_magic_focus_potion", true), "boolean");

        configs.emptyLine();

        configs.addComment("Magic inhibition potion");
        configs.addKeyValuePair(new Pair<>("magic_inhibition_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_magic_inhibition_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("strong_magic_inhibition_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Magic shielding potion");
        configs.addKeyValuePair(new Pair<>("magic_shielding_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_magic_shielding_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("PerfectShot potion");
        configs.addKeyValuePair(new Pair<>("perfectshot_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_perfectshot_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("strong_perfectshot.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Purity potion");
        configs.addKeyValuePair(new Pair<>("purity_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_purity_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Repairing potion (Disabled by default)");
        configs.addKeyValuePair(new Pair<>("repairing_potion.enable", false), "boolean");
        configs.addKeyValuePair(new Pair<>("long_repairing_potion.enable", false), "boolean");

        configs.emptyLine();

        configs.addComment("Solid body potion");
        configs.addKeyValuePair(new Pair<>("solid_body.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Vulnerability potion (Disabled by default)");
        configs.addKeyValuePair(new Pair<>("vulnerability_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_vulnerability_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("strong_vulnerability_potion.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Well fed potion");
        configs.addKeyValuePair(new Pair<>("well_fed_potion.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("long_well_fed_potion.enable", true), "boolean");
    }
}
