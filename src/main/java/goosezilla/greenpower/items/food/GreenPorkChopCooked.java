package goosezilla.greenpower.items.food;

import goosezilla.greenpower.items.FoodBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Goose on 03/08/2016.
 */
public class GreenPorkChopCooked extends FoodBase {


    public GreenPorkChopCooked(int amount, float saturation, boolean isWolfFood, String name) {
        super(amount, saturation, isWolfFood, name);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            worldIn.spawnEntityInWorld(new EntityXPOrb(worldIn, player.posX + 0.5, player.posY + 0.5, player.posZ + 0.5, 26));
        }
    }
}
