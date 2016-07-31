package goosezilla.greenpower.registry;

import goosezilla.greenpower.items.materials.ItemGreenCoal;
import goosezilla.greenpower.items.materials.ItemGreenIron;
import goosezilla.greenpower.items.materials.ItemXPCrystal;
import net.minecraft.item.Item;

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
