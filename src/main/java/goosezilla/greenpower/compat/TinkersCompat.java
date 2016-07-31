package goosezilla.greenpower.compat;

import goosezilla.greenpower.registry.ModItems;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.TinkerIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.fluid.FluidMolten;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

import static slimeknights.tconstruct.library.utils.HarvestLevels.DIAMOND;

public class TinkersCompat
{
    public static final int GREENIRON_COLOR = 0x319C03;

    public static final Material greeniron = new Material("greeniron", GREENIRON_COLOR);
    public static final FluidMolten fluidGreeniron = new FluidMolten("greeniron", GREENIRON_COLOR);
    //public static Block blockMoltenGreenIron;

    public static final AbstractTrait traitExhaustive = new TraitExhaustive();

    public static void init(FMLInitializationEvent event)
    {
        fluidGreeniron.setUnlocalizedName(fluidGreeniron.getName());
        fluidGreeniron.setTemperature(769);
        FluidRegistry.registerFluid(fluidGreeniron);
        //blockMoltenGreenIron = registerMoltenBlock(fluidGreeniron);
        //fluidGreeniron.setBlock(blockMoltenGreenIron);
        //FluidRegistry.addBucketForFluid(fluidGreeniron);

        greeniron.setCraftable(true);
        greeniron.setCastable(true);
        greeniron.addItem(ModItems.itemGreenIron);
        greeniron.setRepresentativeItem(ModItems.itemGreenIron);
        greeniron.setFluid(fluidGreeniron);
        greeniron.addTrait(traitExhaustive);

        TinkerRegistry.addMaterial(greeniron);
        TinkerRegistry.addMaterialStats(greeniron,
                new HeadMaterialStats(204, 6.00f, 4.00f, DIAMOND),
                new HandleMaterialStats(0.85f, 60),
                new ExtraMaterialStats(50));

        TinkerIntegration.integrate(greeniron, fluidGreeniron, "GreenIron").toolforge();

        TinkerRegistry.registerMelting(ModItems.itemGreenIron, fluidGreeniron, 144);

        TinkerSmeltery.registerToolpartMeltingCasting(greeniron);
        TinkerSmeltery.registerOredictMeltingCasting(fluidGreeniron, "GreenIron");
    }

    public static void postInit(FMLPostInitializationEvent event)
    {
        if(event.getSide().isClient())
        {
            registerMaterialRendering();
        }
    }

    @SideOnly(Side.CLIENT)
    private static void registerMaterialRendering()
    {
        greeniron.setRenderInfo(new MaterialRenderInfo.Metal(GREENIRON_COLOR, 0f, 0.3f, 0f));
    }

    public static BlockMolten registerMoltenBlock(Fluid fluid) {
        BlockMolten block = new BlockMolten(fluid);
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName("blockMoltenGreenIron");
        itemBlock.setUnlocalizedName("blockMoltenGreenIron");
        block.setUnlocalizedName("blockMoltenGreenIron");
        block.setRegistryName("blockMoltenGreenIron");
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);

        return block;
    }

}
