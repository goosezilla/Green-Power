package goosezilla.greenpower.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.registry.ModItems;

//import.java.util.Random;

public class BlockXPCrystal extends Block {

    private Item drop;

    public BlockXPCrystal() {
        super(Material.ROCK);
        this.drop = ModItems.XP_CRYSTAL;
        setUnlocalizedName("BlockXPCrystal");
        this.setResistance(20.0F);
        this.setHardness(5.0F);
        this.setHarvestLevel("pickaxe", 1);
    }
}
