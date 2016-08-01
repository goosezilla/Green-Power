package goosezilla.greenpower.config;

import com.google.common.collect.Lists;
import goosezilla.greenpower.GreenPower;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.List;

public class ModConfig {
    public static double exhaustiveChance = 0.1;
    public static double exhaustiveExhaustion = 1;
    static ConfigCategory Balance;
    private static Configuration config;

    public static Configuration getConfig() {
        return config;
    }

    public static void preInit(FMLPreInitializationEvent event) {
        GreenPower.log.info("Loading configuration.");
        config = new Configuration(event.getSuggestedConfigurationFile(), "0.1", false);
        loadFromFile();
    }

    public static void loadFromFile() {
        syncConfig(true);
    }

    public static void loadFromMemory() {
        syncConfig(false);
    }

    private static void syncConfig(boolean loadFromFile) {
        Property prop;

        if (loadFromFile)
            config.load();

        //Balance
        {
            String cat = "balance";
            List<String> propOrder = Lists.newArrayList();
            Balance = config.getCategory(cat);

            prop = config.get(cat, "exhaustiveChance", exhaustiveChance);
            prop.setComment("Chance for exhaustive trait and green iron pickaxe to generate bonus stuff.");
            prop.setMinValue(0);
            prop.setMaxValue(1);
            exhaustiveChance = prop.getDouble();
            prop.setLanguageKey("gui.greenpower.config.exhaustiveChance");
            propOrder.add(prop.getName());

            prop = config.get(cat, "exhaustiveExhaustion", exhaustiveExhaustion);
            prop.setComment("How much exhaustion to give the player on successful proc. 4 is 1/20th of the full foodbar.");
            prop.setMinValue(0);
            prop.setMaxValue(80);
            exhaustiveExhaustion = prop.getDouble();
            prop.setLanguageKey("gui.greenpower.config.exhaustiveExhaustion");
            propOrder.add(prop.getName());

            config.setCategoryPropertyOrder(cat, propOrder);
        }

        if (config.hasChanged())
            config.save();
    }
}
