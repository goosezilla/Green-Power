package goosezilla.greenpower.registry;

import net.minecraft.item.Item;
import goosezilla.greenpower.items.materials.*;

/**
 * Created by Goose on 26/07/2016.
 */
public class ModItems
{
    public static Item itemGreenIron;
    public static Item itemXPCrystal;
    public static Item itemGreenCoal;

    public static void init()
    {
        itemGreenIron = new ItemGreenIron("itemGreenIron");
        itemXPCrystal = new ItemXPCrystal("itemXPCrystal");
        itemGreenCoal = new ItemGreenCoal("itemGreenCoal");

    }
}
