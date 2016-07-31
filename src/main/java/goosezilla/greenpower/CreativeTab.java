package goosezilla.greenpower;

import goosezilla.greenpower.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Pobiega on 2016-07-31.
 */
public class CreativeTab extends CreativeTabs
{
    public static final CreativeTab INSTANCE = new CreativeTab();

    public CreativeTab()
    {
        super(GreenPower.MODID);
    }

    @Override
    public ItemStack getIconItemStack(){
        return new ItemStack(this.getTabIconItem());
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.itemXPCrystal;
    }
}