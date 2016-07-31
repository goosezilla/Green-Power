package goosezilla.greenpower.items.tools;

import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.util.GreenIronUtil;
import goosezilla.greenpower.util.ItemUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GreenIronPick extends ItemPickaxe {

    public GreenIronPick(String name) {
        super(ToolMaterial.IRON);

        ItemUtil.registerItem(this, name, true);
        this.registerRendering();
    }

    protected void registerRendering() {
        GreenPower.proxy.addRenderRegister(new ItemStack(this), this.getRegistryName(), "inventory");
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        GreenIronUtil.checkForMining(worldIn, state, pos, entityLiving);
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}