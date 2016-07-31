package goosezilla.greenpower.registry;

import goosezilla.greenpower.items.food.FoodGreenCarrot;

/**
 * Created by Goose on 31/07/2016.
 */
public class ModFoods
{
    public static FoodGreenCarrot foodGreenCarrot;

    public static void init() {

        foodGreenCarrot = new FoodGreenCarrot(3, 0.6f, false, "foodGreenCarrot");
    }
}
