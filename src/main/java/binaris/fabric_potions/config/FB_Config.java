package binaris.fabric_potions.config;

/**
 * Config from <a href="https://github.com/Binaris00/just_another_config">...</a>
 * All the credits to... ME :D
 * */
public class FB_Config {
    public static Config CONFIG_POTIONS = new Config("fabric_potions", "potions_config", true);
    public static Config CONFIG_EFFECTS = new Config("fabric_potions", "effects_config", true);

    public static void registerConfigEffects(){
        CONFIG_EFFECTS.addComment("Antidote effect config");
        CONFIG_EFFECTS.set("antidote.enable", true);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("BadShot effect config");
        CONFIG_EFFECTS.set("badshot.enable", true);
        CONFIG_EFFECTS.set("badshot.reduce_damage", 0.55);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Bleed effect config");
        CONFIG_EFFECTS.set("bleed.enable", true);
        CONFIG_EFFECTS.set("bleed.time", 40);
        CONFIG_EFFECTS.set("bleed.damage", 3.0F);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Broken armor effect config");
        CONFIG_EFFECTS.set("broken_armor.enable", true);
        CONFIG_EFFECTS.set("broken_armor.value", -2.0f);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Combustion effect config");
        CONFIG_EFFECTS.set("combustion.enable", true);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Corrosion effect config");
        CONFIG_EFFECTS.set("corrosion.enable", true);
        CONFIG_EFFECTS.set("corrosion.value", 1);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Counter effect config");
        CONFIG_EFFECTS.set("counter.enable", true);
        CONFIG_EFFECTS.set("counter.value", 0.2f);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Diamond Skin effect config");
        CONFIG_EFFECTS.set("diamond_skin.enable", true);
        CONFIG_EFFECTS.set("diamond_skin.value", 1.0f);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Enderman soul effect config");
        CONFIG_EFFECTS.set("enderman_soul.enable", true);
        CONFIG_EFFECTS.set("enderman_soul.radius", 128.0f);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Flight");
        CONFIG_EFFECTS.set("flight.enable", true);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Gravitation effect config");
        CONFIG_EFFECTS.set("gravitation.enable", true);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Health decrease effect config");
        CONFIG_EFFECTS.set("health_decrease.enable", true);
        CONFIG_EFFECTS.set("health_decrease.hearths", -4.0);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Iron skin effect config");
        CONFIG_EFFECTS.set("iron_skin.enable", true);
        CONFIG_EFFECTS.set("iron_skin.value", 2.0);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Lightning effect config");
        CONFIG_EFFECTS.set("lightning.enable", true);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Magic Shielding effect config");
        CONFIG_EFFECTS.set("magic_shielding.enable", true);
        CONFIG_EFFECTS.set("magic_shielding.damage", 3.0F);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Magic Focus effect config");
        CONFIG_EFFECTS.set("magic_focus.enable", true);
        CONFIG_EFFECTS.set("magic_focus.damage", 2.0F);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Magic Inhibition effect config");
        CONFIG_EFFECTS.set("magic_inhibition.enable", true);
        CONFIG_EFFECTS.set("magic_inhibition.damage", 2.0F);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("PerfectShot effect config");
        CONFIG_EFFECTS.set("perfectshot.enable", true);
        CONFIG_EFFECTS.set("perfectshot.base_damage", 1.3f);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Purity effect config");
        CONFIG_EFFECTS.set("purity.enable", true);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Repairing effect config");
        CONFIG_EFFECTS.set("repairing.enable", true);
        CONFIG_EFFECTS.set("repairing.value", 1);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Solid Body effect config");
        CONFIG_EFFECTS.set("solid_body.enable", true);
        CONFIG_EFFECTS.set("solid_body.value", 1.0f);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Vulnerability effect config");
        CONFIG_EFFECTS.set("vulnerability.enable", true);

        CONFIG_EFFECTS.emptyLine();

        CONFIG_EFFECTS.addComment("Well fed effect config");
        CONFIG_EFFECTS.set("well_fed.enable", true);
        CONFIG_EFFECTS.set("well_fed.time", 40f);
        CONFIG_EFFECTS.set("well_fed.value", 1);

        CONFIG_EFFECTS.load();
    }

    public static void registerConfigPotions(){
        CONFIG_POTIONS.addComment("Antidote potion");
        CONFIG_POTIONS.set("antidote_potion.enable", true);
        CONFIG_POTIONS.set("long_antidote_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("BadShot potion");
        CONFIG_POTIONS.set("badshot_potion.enable", true);
        CONFIG_POTIONS.set("long_badshot_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Bleed potion");
        CONFIG_POTIONS.set("bleed_potion.enable", true);
        CONFIG_POTIONS.set("long_bleed_potion.enable", true);
        CONFIG_POTIONS.set("strong_bleed_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Broken armor potion");
        CONFIG_POTIONS.set("broken_armor_potion.enable", true);
        CONFIG_POTIONS.set("long_broken_armor_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Corrosion potion (Disabled by default)");
        CONFIG_POTIONS.set("corrosion_potion.enable", false);
        CONFIG_POTIONS.set("long_corrosion_potion.enable", false);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Counter potion");
        CONFIG_POTIONS.set("counter_potion.enable", true);
        CONFIG_POTIONS.set("long_counter_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Diamond skin potion");
        CONFIG_POTIONS.set("diamond_skin_potion.enable", true);
        CONFIG_POTIONS.set("long_diamond_skin_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Enderman soul potion");
        CONFIG_POTIONS.set("enderman_soul_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Flight potion (Disabled by default)");
        CONFIG_POTIONS.set("flight_potion.enable", false);
        CONFIG_POTIONS.set("long_flight_potion.enable", false);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Gravitation potion");
        CONFIG_POTIONS.set("gravitation_potion.enable", true);
        CONFIG_POTIONS.set("long_gravitation_potion.enable", true);
        CONFIG_POTIONS.set("strong_gravitation_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Health Decrease potion (Disabled by default)");
        CONFIG_POTIONS.set("health_decrease_potion.enable", false);
        CONFIG_POTIONS.set("long_health_decrease_potion.enable", false);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Iron skin potion");
        CONFIG_POTIONS.set("iron_skin_potion.enable", true);
        CONFIG_POTIONS.set("long_iron_skin_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Lightning potion");
        CONFIG_POTIONS.set("lightning_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Magic focus potion");
        CONFIG_POTIONS.set("magic_focus_potion.enable", true);
        CONFIG_POTIONS.set("long_magic_focus_potion.enable", true);
        CONFIG_POTIONS.set("strong_magic_focus_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Magic inhibition potion");
        CONFIG_POTIONS.set("magic_inhibition_potion.enable", true);
        CONFIG_POTIONS.set("long_magic_inhibition_potion.enable", true);
        CONFIG_POTIONS.set("strong_magic_inhibition_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Magic shielding potion");
        CONFIG_POTIONS.set("magic_shielding_potion.enable", true);
        CONFIG_POTIONS.set("long_magic_shielding_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("PerfectShot potion");
        CONFIG_POTIONS.set("perfectshot_potion.enable", true);
        CONFIG_POTIONS.set("long_perfectshot_potion.enable", true);
        CONFIG_POTIONS.set("strong_perfectshot_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Purity potion");
        CONFIG_POTIONS.set("purity_potion.enable", true);
        CONFIG_POTIONS.set("long_purity_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Repairing potion (Disabled by default)");
        CONFIG_POTIONS.set("repairing_potion.enable", false);
        CONFIG_POTIONS.set("long_repairing_potion.enable", false);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Solid body potion");
        CONFIG_POTIONS.set("solid_body_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Vulnerability potion (Disabled by default)");
        CONFIG_POTIONS.set("vulnerability_potion.enable", true);
        CONFIG_POTIONS.set("long_vulnerability_potion.enable", true);
        CONFIG_POTIONS.set("strong_vulnerability_potion.enable", true);

        CONFIG_POTIONS.emptyLine();

        CONFIG_POTIONS.addComment("Well fed potion");
        CONFIG_POTIONS.set("well_fed_potion.enable", true);
        CONFIG_POTIONS.set("long_well_fed_potion.enable", true);

        CONFIG_POTIONS.load();
    }

}
