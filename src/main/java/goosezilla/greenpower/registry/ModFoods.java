package goosezilla.greenpower.registry;

import goosezilla.greenpower.items.food.FoodGreenCarrot;
import net.minecraft.init.Blocks;

public class ModFoods
{
    public static FoodGreenCarrot foodGreenCarrot;

    public static void init() {

        foodGreenCarrot = new FoodGreenCarrot(3, 0.6f, ModBlocks.blockGreenCarrots, Blocks.FARMLAND, "foodGreenCarrot");
    }
}
