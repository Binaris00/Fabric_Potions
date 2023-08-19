package binaris.fabric_potions.config;

public class Fabric_Potions_VanillaPotions {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of("Fabric_Potions_EffectConfig").provider(configs).request();
    }

    private static void createConfigs() {

    }
}
