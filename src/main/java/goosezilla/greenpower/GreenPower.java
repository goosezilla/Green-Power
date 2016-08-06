package goosezilla.greenpower;

import goosezilla.greenpower.compat.TinkersCompat;
import goosezilla.greenpower.config.ModConfig;
import goosezilla.greenpower.entity.EntityGreenPig;
import goosezilla.greenpower.potion.Potions;
import goosezilla.greenpower.registry.ModBlocks;
import goosezilla.greenpower.registry.ModFoods;
import goosezilla.greenpower.registry.ModItems;
import goosezilla.greenpower.registry.ModTools;
import goosezilla.greenpower.util.GreenIronUtil;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

import static net.minecraftforge.oredict.OreDictionary.registerOre;

@Mod(modid = GreenPower.MODID, version = GreenPower.VERSION, dependencies = GreenPower.DEPEND, name = GreenPower.MODNAME, acceptedMinecraftVersions = "[1.10.2]", guiFactory = GreenPower.GUIFACTORY)
    public class GreenPower {

    public static final String MODID = "greenpower";
    public static final String DEPEND = "";
    public static final String VERSION = "1.10.2-0.1";
    public static final String MODNAME = "GreenPower";
    public static final String CLIENTPROXY = "goosezilla.greenpower.ClientProxy";
    public static final String COMMONPROXY = "goosezilla.greenpower.CommonProxy";
    public static final String GUIFACTORY = "goosezilla.greenpower.config.ConfigGui$ConfigGuiFactory";

    @SidedProxy(clientSide = GreenPower.CLIENTPROXY, serverSide = GreenPower.COMMONPROXY)
    public static CommonProxy proxy;

    @Instance(MODID)
    public static GreenPower instance;

    public static Random rand = new Random();
    public static Logger log = LogManager.getLogger(MODID);

    private static int entityID = 0;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        ModConfig.preInit(event);

        ModItems.init();
        ModBlocks.init();
        ModTools.init();
        ModFoods.init();

        //TODO: Clean up the entity registering mess and move it to its own file.

        registerEntity(EntityGreenPig.class, "entityGreenPig", 0x008500, 0x98FB98);

        new Potions().registerPotions();

        proxy.registerWorldGenerators();
        proxy.preInit(event);
    }

    private void registerEntity(Class<? extends Entity> entityClass, String entityName, int bkEggColor, int fgEggColor) {
        EntityRegistry.registerModEntity(entityClass, entityName, entityID++, GreenPower.instance, 80, 3, true, bkEggColor, fgEggColor);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        TinkersCompat.init(event);

        //ModRecipes
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemGreenIron, 1, 0), " b ", "bgb", " b ", 'b', ModItems.itemXPCrystal, 'g', Items.IRON_INGOT);
        GameRegistry.addShapedRecipe(new ItemStack(ModTools.itemGreenIronPick, 1, 0), "ggg", " s ", " s ", 'g', ModItems.itemGreenIron, 's', Items.STICK);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemGreenCoal, 1, 0), "bbb", "bcb", "bbb", 'b', ModItems.itemXPCrystal, 'c', Items.COAL);
        GameRegistry.addShapedRecipe(new ItemStack(ModFoods.foodGreenCarrot, 1, 0), " b ", "bgb", " b ", 'b', ModItems.itemXPCrystal, 'g', Items.CARROT);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemMutationPotion, 1, 0), Items.GLASS_BOTTLE, ModFoods.foodGreenCarrot);

        //Ores
        registerOre("oreXPCrystal", new ItemStack(ModBlocks.blockXPCrystal, 1));

        //blocks
        registerOre("blockGreenCarrots", ModBlocks.blockGreenCarrots);

        //Gems
        registerOre("gemXPCrystal", ModItems.itemXPCrystal);
        registerOre("itemGreenCoal", ModItems.itemGreenCoal);
        GameRegistry.registerFuelHandler((IFuelHandler)ModItems.itemGreenCoal);

        //ingots
        registerOre("ingotGreenIron", ModItems.itemGreenIron);

        //foods
        registerOre("foodGreenCarrot", ModFoods.foodGreenCarrot);

        GameRegistry.addSmelting(new ItemStack(ModFoods.greenPorkChopRaw), new ItemStack(ModFoods.greenPorkChopCooked), 0.35f);

        LootTableList.register(EntityGreenPig.lootTable);

        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        GreenIronUtil.init();

        proxy.postInit(event);
        TinkersCompat.postInit(event);
    }

    public static class Constants {
        public static class NBT {
            public static final String OWNER_UUID = "ownerUUID";
            public static final String OWNER_NAME = "ownerNAME";
        }
    }
}