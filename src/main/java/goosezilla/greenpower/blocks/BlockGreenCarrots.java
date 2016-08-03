package goosezilla.greenpower.blocks;

import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.registry.ModFoods;
import goosezilla.greenpower.util.ItemUtil;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

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

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack stack, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (this.getMetaFromState(state) >= 7) {
            if (!world.isRemote) {

                List<ItemStack> drops = this.getDrops(world, pos, state, 0);
                boolean deductedSeedSize = false;
                for (ItemStack drop : drops) {
                    if (drop != null) {
                        /*
                        if(drop.getItem() == this.getSeed() && !deductedSeedSize){
                            drop.stackSize--;
                            deductedSeedSize = true;
                        }
                        */
                        if (drop.stackSize > 0) {
                            EntityItem entity = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, drop);
                            world.spawnEntityInWorld(entity);
                        }
                    }
                }

                world.setBlockState(pos, this.getStateFromMeta(0));
            }
            return true;
        }
        return false;
    }
}
