package goosezilla.greenpower.registry;

import goosezilla.greenpower.blocks.BlockGreenCarrots;
import goosezilla.greenpower.blocks.BlockXPCrystal;
import net.minecraft.block.Block;

public class ModBlocks
{
    public static Block blockXPCrystal;
    public static Block blockGreenCarrots;

    public static void init()
    {
        blockXPCrystal = new BlockXPCrystal("blockXPCrystal");
        blockGreenCarrots = new BlockGreenCarrots("blockGreenCarrots");
    }

}