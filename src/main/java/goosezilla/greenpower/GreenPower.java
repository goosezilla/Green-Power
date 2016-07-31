package goosezilla.greenpower;

import goosezilla.greenpower.compat.TinkersCompat;
import goosezilla.greenpower.registry.ModBlocks;
import goosezilla.greenpower.registry.ModItems;
import goosezilla.greenpower.registry.ModTools;
import goosezilla.greenpower.util.GreenIronUtil;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

import static net.minecraftforge.oredict.OreDictionary.registerOre;


/**
 * Created by Goose on 25/07/2016. boo hoo
 */

    @Mod(modid = GreenPower.MODID, version = GreenPower.VERSION, dependencies = GreenPower.DEPEND,  name = GreenPower.MODNAME, acceptedMinecraftVersions = "[1.10.2]")
    public class GreenPower {

    public static final String MODID = "greenpower";
    public static final String DEPEND = "";
    public static final String VERSION = "1.10.2-0.1";
    public static final String MODNAME = "GreenPower";
    public static final String CLIENTPROXY = "goosezilla.greenpower.ClientProxy";
    public static final String COMMONPROXY = "goosezilla.greenpower.CommonProxy";

    @SidedProxy(clientSide = GreenPower.CLIENTPROXY, serverSide = GreenPower.COMMONPROXY)
    public static CommonProxy proxy;

    @Instance(MODID)
    public static GreenPower instance;

    public static Random rand = new Random();
    public static Logger log = LogManager.getLogger(MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModItems.init();
        ModBlocks.init();
        ModTools.init();

        proxy.registerWorldGenerators();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        TinkersCompat.init(event);

        //ModRecipes
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemGreenIron, 1, 0)," b ", "bgb", " b ", 'b', ModItems.itemXPCrystal, 'g', Items.IRON_INGOT);
        GameRegistry.addShapedRecipe(new ItemStack(ModTools.itemGreenIronPick, 1, 0), "ggg", " s ", " s ", 'g', ModItems.itemGreenIron, 's', Items.STICK);

        //Ores
        registerOre("oreXPCrystal", new ItemStack(ModBlocks.blockXPCrystal, 1));

        //Gems
        registerOre("gemXPCrystal", ModItems.itemXPCrystal);
        registerOre("itemGreenCoal", ModItems.itemGreenCoal);

        //ingots
        registerOre("ingotGreenIron", ModItems.itemGreenIron);

        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        GreenIronUtil.init();

        proxy.postInit(event);
        TinkersCompat.postInit(event);
    }
}