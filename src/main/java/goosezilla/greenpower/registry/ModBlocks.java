package goosezilla.greenpower.registry;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.blocks.*;

/**
 * Created by Goose on 26/07/2016.
 */
public class ModBlocks {
    public static Block BLOCK_XP_CRYSTAL;

    public static void init() {
        BLOCK_XP_CRYSTAL = new BlockXPCrystal().setRegistryName("block_xp_crystal");
    }

    public static void register() {
        registerBlock(BLOCK_XP_CRYSTAL);
    }

    public static void registerRenders() {
        registerRender(BLOCK_XP_CRYSTAL);
    }

    public static void registerBlock(Block block) {
        GameRegistry.registerBlock(block, block.getRegistryName().toString());
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(GreenPower.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
