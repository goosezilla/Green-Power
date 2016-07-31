package goosezilla.greenpower.util;

import goosezilla.greenpower.CreativeTab;
import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.blocks.ItemBlockBase;
import goosezilla.greenpower.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ItemUtil {
    public static void registerBlock(Block block, ItemBlockBase itemBlock, String name, boolean addToCreativeTab)
    {
        block.setUnlocalizedName(GreenPower.MODID+"."+name);
        block.setRegistryName(GreenPower.MODID, name);
        GameRegistry.register(block);

        itemBlock.setRegistryName(block.getRegistryName());
        GameRegistry.register(itemBlock);

        block.setCreativeTab(addToCreativeTab ? CreativeTab.INSTANCE : null);
    }

    public static void registerItem(ItemBase item, String name, boolean addToCreativeTab)
    {
        item.setUnlocalizedName(GreenPower.MODID+"."+name);
        item.setRegistryName(GreenPower.MODID, name);
        GameRegistry.register(item);

        item.setCreativeTab(addToCreativeTab ? CreativeTab.INSTANCE : null);
    }
}
