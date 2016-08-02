package goosezilla.greenpower.config;

import com.google.common.collect.Lists;
import goosezilla.greenpower.GreenPower;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

public final class ModConfig {
    public static double exhaustiveChance = 0.1;
    public static double exhaustiveExhaustion = 1;
    public static int lovePotionID = 51100;
    public static int greenCoalBurnTime = 200;
    public static int greenCoalSmeltsPerLevel = 8;
    public static int xpOreVeinSize = 8;
    public static int xpOreRarity = 10;
    public static int xpOreMinY = 50;
    public static int xpOreMaxY = 70;

    public static ModConfig instance = new ModConfig();
    static ConfigCategory Balance;
    static ConfigCategory IDs;
    static ConfigCategory Worldgen;
    private static Configuration config;

    private ModConfig() {
    }

    public static Configuration getConfig() {
        return config;
    }

    public static void preInit(FMLPreInitializationEvent event) {
        GreenPower.log.info("Loading configuration.");
        config = new Configuration(event.getSuggestedConfigurationFile(), "0.1", false);
        MinecraftForge.EVENT_BUS.register(instance);
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
            String cat = "Balance";
            List<String> propOrder = Lists.newArrayList();
            Balance = config.getCategory(cat);

            prop = config.get(cat, "exhaustiveChance", exhaustiveChance);
            prop.setComment("Chance for exhaustive trait and green iron pickaxe to generate bonus stuff.");
            prop.setMinValue(0);
            prop.setMaxValue(1);
            exhaustiveChance = prop.getDouble();
            prop.setLanguageKey("gui.greenpower.config.exhaustiveChance");
            prop.setComment(addDefaultToComment(prop));
            propOrder.add(prop.getName());

            prop = config.get(cat, "exhaustiveExhaustion", exhaustiveExhaustion);
            prop.setComment("How much exhaustion to give the player on successful proc. 4 is 1/20th of the full foodbar.");
            prop.setMinValue(0);
            prop.setMaxValue(80);
            exhaustiveExhaustion = prop.getDouble();
            prop.setLanguageKey("gui.greenpower.config.exhaustiveExhaustion");
            prop.setComment(addDefaultToComment(prop));
            propOrder.add(prop.getName());

            prop = config.get(cat, "greenCoalBurnTime", greenCoalBurnTime);
            prop.setComment("How much burntime one damage on the green coal is worth.");
            prop.setMinValue(1);
            prop.setMaxValue(Integer.MAX_VALUE);
            greenCoalBurnTime = prop.getInt();
            prop.setLanguageKey("gui.greenpower.config.greenCoalBurnTime");
            prop.setComment(addDefaultToComment(prop));
            propOrder.add(prop.getName());

            prop = config.get(cat, "greenCoalSmeltsPerLevel", greenCoalSmeltsPerLevel);
            prop.setComment("How many smelting operations a Green coal will perform per level absorbed");
            prop.setMinValue(1);
            prop.setMaxValue(64);
            greenCoalSmeltsPerLevel = prop.getInt();
            prop.setLanguageKey("gui.greenpower.config.greenCoalSmeltsPerLevel");
            prop.setComment(addDefaultToComment(prop));
            propOrder.add(prop.getName());

            config.setCategoryPropertyOrder(cat, propOrder);
        }

        //Worldgen
        {
            String cat = "Worldgen";
            List<String> propOrder = Lists.newArrayList();
            Worldgen = config.getCategory(cat);

            prop = config.get(cat, "xpOreVeinSize", xpOreVeinSize);
            prop.setComment("How large an XP Crystal vein can be.");
            prop.setMinValue(1);
            prop.setMaxValue(64);
            xpOreVeinSize = prop.getInt();
            prop.setLanguageKey("gui.greenpower.config.xpOreVeinSize");
            prop.setComment(addDefaultToComment(prop));
            propOrder.add(prop.getName());

            prop = config.get(cat, "xpOreRarity", xpOreRarity);
            prop.setComment("How Rarely XP Ore will spawn (lower is rarer)");
            prop.setMinValue(1);
            prop.setMaxValue(100);
            xpOreRarity = prop.getInt();
            prop.setLanguageKey("gui.greenpower.config.xpOreRarity");
            prop.setComment(addDefaultToComment(prop));
            propOrder.add(prop.getName());

            prop = config.get(cat, "xpOreMinY", xpOreMinY);
            prop.setComment("Min Y level for spawning XP ore.");
            prop.setMinValue(1);
            prop.setMaxValue(255);
            xpOreMinY = prop.getInt();
            prop.setLanguageKey("gui.greenpower.config.xpOreMinY");
            prop.setComment(addDefaultToComment(prop));
            propOrder.add(prop.getName());

            prop = config.get(cat, "xpOreMaxY", xpOreMaxY);
            prop.setComment("XPMax Y level for spawning XP ore.");
            prop.setMinValue(1);
            prop.setMaxValue(255);
            xpOreMaxY = prop.getInt();
            prop.setLanguageKey("gui.greenpower.config.xpOreMaxY");
            prop.setComment(addDefaultToComment(prop));
            propOrder.add(prop.getName());

            config.setCategoryPropertyOrder(cat, propOrder);
        }

        //IDs
        {
            String cat = "IDs";
            List<String> propOrder = Lists.newArrayList();
            IDs = config.getCategory(cat);

            prop = config.get(cat, "lovePotionID", lovePotionID);
            prop.setComment("ID for Love Potion.");
            lovePotionID = prop.getInt();
            prop.setLanguageKey("gui.greenpower.config.lovePotionID");
            prop.setComment(addDefaultToComment(prop));
            propOrder.add(prop.getName());

            config.setCategoryPropertyOrder(cat, propOrder);
        }

        if (config.hasChanged())
            config.save();
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equalsIgnoreCase(GreenPower.MODID))
            syncConfig(false);
    }

    protected static String addDefaultToComment(Property prop)
    {
        String res = prop.getComment() + " ";
        res += "[default:" + prop.getDefault() +"]";
        res += "[min:" + prop.getMinValue() +"]";
        res += "[max:" + prop.getMaxValue() +"]";
        return res;
    }
}
