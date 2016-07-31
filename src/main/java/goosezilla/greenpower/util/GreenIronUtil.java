package goosezilla.greenpower.util;

import goosezilla.greenpower.GreenPower;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class GreenIronUtil
{
    public static List<WeightedRandomCollection<ItemStack>> dropList;

    private static boolean isInitialized = false;

    public static void init()
    {
        dropList = new ArrayList<WeightedRandomCollection<ItemStack>>();

        WeightedRandomCollection tier0 = new WeightedRandomCollection(GreenPower.rand);
        tier0.add(5, new ItemStack(Items.DIAMOND, 1));
        tier0.add(30, new ItemStack(Items.REDSTONE, 3));
        tier0.add(20, new ItemStack(Blocks.GOLD_ORE, 1));
        tier0.add(20, new ItemStack(Blocks.IRON_ORE, 1));
        tier0.add(15, new ItemStack(Items.COAL, 3));
        tier0.add(10, new ItemStack(Items.DYE, 3, 4)); //meta 4 is lapis

        WeightedRandomCollection tier1 = new WeightedRandomCollection(GreenPower.rand);
        tier1.add(20, new ItemStack(Items.DYE, 2, 4)); //meta 4 is lapis
        tier1.add(15, new ItemStack(Items.REDSTONE, 2));
        tier1.add(25, new ItemStack(Blocks.GOLD_ORE, 1));
        tier1.add(25, new ItemStack(Blocks.IRON_ORE, 1));
        tier1.add(15, new ItemStack(Items.COAL, 3));

        WeightedRandomCollection tier2 = new WeightedRandomCollection(GreenPower.rand);
        tier2.add(50, new ItemStack(Blocks.IRON_ORE, 1));
        tier2.add(50, new ItemStack(Items.COAL, 2));

        dropList.add(tier0);
        dropList.add(tier1);
        dropList.add(tier2);

        isInitialized = true;
    }

    public static int getTier(int y)
    {
        if(y <= 15)
            return 0;
        else if(y <= 31)
            return 1;
        else if(y <= 64)
            return 2;
        else
            return -1;
    }

    public static ItemStack getRandomItemstack(int tier)
    {
        if (!isInitialized)
            init();

        if (tier < 0 || tier > 2)
            return null;
        return dropList.get(tier).next().copy();
    }


    public static void checkForMining(World world, IBlockState state, BlockPos pos, EntityLivingBase living)
    {
        if(!world.isRemote)
        {
            //before we even random, make sure the player has food to "trade".
            if (living instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) living;
                if (player.getFoodStats().getFoodLevel() > 0) {
                    //get this from config in the future
                    float chance = 1f;
                    if (state.getBlock() == Blocks.STONE && GreenPower.rand.nextFloat() < chance) {
                        ItemStack drop = GreenIronUtil.getRandomItemstack(GreenIronUtil.getTier(pos.getY()));
                        if (drop != null) {
                            world.spawnEntityInWorld(new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, drop));
                            //add exhaustion. 1.0f is 1/4th of a foodlevel (1/8th of a "club" ingame)
                            player.addExhaustion(1.0f);
                        }
                    }
                }
            }
        }
    }

}
