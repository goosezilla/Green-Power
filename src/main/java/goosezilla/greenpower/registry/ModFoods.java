package goosezilla.greenpower.registry;

import goosezilla.greenpower.items.food.FoodGreenCarrot;
import goosezilla.greenpower.util.ItemUtil;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ModFoods
{
    public static FoodGreenCarrot foodGreenCarrot;
    public static Item greenPorkChop;

    public static void init() {

        foodGreenCarrot = new FoodGreenCarrot(3, 0.6f, ModBlocks.blockGreenCarrots, Blocks.FARMLAND, "foodGreenCarrot");
        greenPorkChop = new ItemFood(3, 0.3F, true);
        ItemUtil.registerItem(greenPorkChop, "greenPorkchopRaw", true);
    }
}
