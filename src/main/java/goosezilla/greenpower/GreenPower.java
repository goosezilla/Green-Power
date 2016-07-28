package goosezilla.greenpower;

import goosezilla.greenpower.items.materials.GreenIron;
import goosezilla.greenpower.items.materials.XPCrystal;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import goosezilla.greenpower.registry.*;

import java.io.File;
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

    @EventHandler
    public void init(FMLInitializationEvent event) {

        //ModRecipes
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.GREEN_IRON, 1, 0)," b ", "bgb", " b ", 'b', ModItems.XP_CRYSTAL, 'g', Items.IRON_INGOT);
        GameRegistry.addShapedRecipe(new ItemStack(ModTools.GREEN_IRON_PICK, 1, 0),"ggg", " s ", " s ", 'g', ModItems.GREEN_IRON, 's', Items.STICK);

        //Ores
        registerOre("oreXPCrystal", new ItemStack(ModBlocks.BLOCK_XP_CRYSTAL, 1));

        //Gems
        registerOre("gemXPCrystal", new ItemStack(ModItems.XP_CRYSTAL, 1));

        //ingots
        registerOre("ingotGreenIron", new ItemStack(ModItems.GREEN_IRON, 1));

        //tools
        registerOre("toolGreenIronPick", new ItemStack(ModTools.GREEN_IRON_PICK, 1));

        //This will handle client/common init.
        // proxy.init();


    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.init();
        ModBlocks.init();
        ModBlocks.register();
        ModTools.init();

        proxy.registerRenderers(this);
        proxy.registerWorldGenerators();
    }

    //  @EventHandler
    // public void serverLoad(FMLServerStartingEvent event) {
    //      event.registerServerCommand(new CommandGreenPower());
    // }
}