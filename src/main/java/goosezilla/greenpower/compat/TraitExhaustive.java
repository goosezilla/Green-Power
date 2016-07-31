package goosezilla.greenpower.compat;

import goosezilla.greenpower.util.GreenIronUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import static goosezilla.greenpower.compat.TinkersCompat.GREENIRON_COLOR;

public class TraitExhaustive extends AbstractTrait
{
    public TraitExhaustive()
    {
        super("exhaustive", GREENIRON_COLOR);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        super.afterBlockBreak(tool, world, state, pos, player, wasEffective);

        GreenIronUtil.checkForMining(world, state, pos, player);
    }
}
