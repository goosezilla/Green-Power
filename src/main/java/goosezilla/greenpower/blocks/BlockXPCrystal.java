package goosezilla.greenpower.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.registry.ModItems;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockXPCrystal extends BlockBase {

    private Item drop;

    public BlockXPCrystal(String name) {
        super(Material.ROCK, name);
        this.drop = ModItems.itemXPCrystal;
        this.setResistance(10.0F);
        this.setHardness(2.0F);
        this.setHarvestLevel("pickaxe", 1);
    }

    @Override
    public Item getItemDropped(IBlockState blockstate, Random random, int fortune) {
        return this.drop;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }

}
