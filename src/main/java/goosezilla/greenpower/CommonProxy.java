package goosezilla.greenpower;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import goosezilla.greenpower.worldgen.OreGen;


/**
 * Created by Goose on 26/07/2016.
 */
public class CommonProxy {

    public void registerWorldGenerators()
    {
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
    }

    public void addRenderRegister(ItemStack itemStack, ResourceLocation registryName, String inventory)
    {
    }

    public void preInit(FMLPreInitializationEvent e) {

    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
