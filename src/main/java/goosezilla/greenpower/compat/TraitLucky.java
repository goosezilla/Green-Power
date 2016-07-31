package goosezilla.greenpower.compat;

import goosezilla.greenpower.util.GreenIronUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by Pobiega on 2016-07-31.
 */
public class TraitLucky extends AbstractTrait
{
    public TraitLucky()
    {
        super("lucky", 0x0cff28);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        super.afterBlockBreak(tool, world, state, pos, player, wasEffective);

        GreenIronUtil.checkForMining(world, state, pos);
    }
}
