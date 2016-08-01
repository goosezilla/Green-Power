package goosezilla.greenpower.blocks;

import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.registry.ModFoods;
import goosezilla.greenpower.util.ItemUtil;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockGreenCarrots extends BlockCrops
{
    private static final AxisAlignedBB[] GREENCARROT_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.4375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5625D, 1.0D)};
    private final String name;

    public BlockGreenCarrots(String name) {
        this.name = name;

        this.register();
    }

    protected Item getSeed()
    {
        return ModFoods.foodGreenCarrot;
    }

    protected Item getCrop()
    {
        return ModFoods.foodGreenCarrot;
    }

    protected void register() {
        ItemUtil.registerBlock(this, this.getItemBlock(), this.getBaseName(), this.getAddToCreativeTab());

        this.registerRendering();
    }

    protected boolean getAddToCreativeTab() {
        return true;
    }

    protected String getBaseName() {
        return name;
    }

    protected ItemBlockBase getItemBlock() {
        return new ItemBlockBase(this);
    }

    protected void registerRendering() {
        GreenPower.proxy.addRenderRegister(new ItemStack(this), this.getRegistryName(), "inventory");
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return GREENCARROT_AABB[state.getValue(this.getAgeProperty()).intValue()];
    }
}
