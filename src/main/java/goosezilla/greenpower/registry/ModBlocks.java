package goosezilla.greenpower.registry;

import goosezilla.greenpower.blocks.BlockXPCrystal;
import net.minecraft.block.Block;

public class ModBlocks
{
    public static Block blockXPCrystal;

    public static void init()
    {
        blockXPCrystal = new BlockXPCrystal("blockXPCrystal");
    }
}