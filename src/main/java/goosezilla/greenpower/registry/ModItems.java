package goosezilla.greenpower.registry;

import goosezilla.greenpower.items.materials.*;
import net.minecraft.item.Item;

public class ModItems
{
    public static Item itemGreenIron;
    public static Item itemXPCrystal;
    public static Item itemGreenCoal;
    public static Item itemMutationPotion;
    public static Item itemXpBank;

    public static void init()
    {
        itemGreenIron = new ItemGreenIron("itemGreenIron");
        itemXPCrystal = new ItemXPCrystal("itemXPCrystal");
        itemGreenCoal = new ItemGreenCoal("itemGreenCoal");
        itemMutationPotion = new ItemMutationPotion("itemMutationPotion");
        itemXpBank = new ItemXPBank("itemXPBank");
    }
}
