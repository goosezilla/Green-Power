package goosezilla.greenpower;

import goosezilla.greenpower.worldgen.OreGen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


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
