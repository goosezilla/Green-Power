package goosezilla.greenpower.registry;

import goosezilla.greenpower.blocks.*;
import net.minecraft.block.Block;

/**
 * Created by Goose on 26/07/2016.
 */
public class ModBlocks
{
    public static Block blockXPCrystal;

    public static void init()
    {
        blockXPCrystal = new BlockXPCrystal("blockXPCrystal");
    }
}