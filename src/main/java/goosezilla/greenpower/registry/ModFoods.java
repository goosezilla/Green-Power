package goosezilla.greenpower.registry;

import goosezilla.greenpower.items.FoodBase;
import goosezilla.greenpower.items.food.FoodGreenCarrot;
import goosezilla.greenpower.items.food.GreenPorkChopCooked;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class ModFoods
{
    public static FoodGreenCarrot foodGreenCarrot;
    public static Item greenPorkChopRaw;
    public static Item greenPorkChopCooked;

    public static void init() {

        foodGreenCarrot = new FoodGreenCarrot(3, 0.6f, ModBlocks.blockGreenCarrots, Blocks.FARMLAND, "foodGreenCarrot");
        greenPorkChopRaw = new FoodBase(3, 0.3f, true, "greenPorkChopRaw");
        greenPorkChopCooked = new GreenPorkChopCooked(8, 0.8F, true, "greenPorkChopCooked");
    }
}
