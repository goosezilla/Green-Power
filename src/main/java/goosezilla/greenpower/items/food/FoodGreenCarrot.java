package goosezilla.greenpower.items.food;

import goosezilla.greenpower.items.SeedFoodBase;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FoodGreenCarrot extends SeedFoodBase

{
    public FoodGreenCarrot(int healAmount, float saturation, Block crops, Block soil, String name) {
        super(healAmount, saturation, crops, soil, name);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote)
        {
            worldIn.spawnEntityInWorld(new EntityXPOrb(worldIn, player.posX + 0.5, player.posY + 0.5, player.posZ + 0.5, 8));
        }
    }
}
