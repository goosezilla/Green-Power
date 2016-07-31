package goosezilla.greenpower.items;

import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.util.ItemUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBase extends Item
{
    private final String name;

    public ItemBase(String name)
    {
        this.name = name;

        this.register();
    }

    private void register()
    {
        ItemUtil.registerItem(this, this.getBaseName(), this.getAddToCreativeTab());
        this.registerRendering();
    }

    protected void registerRendering()
    {
        GreenPower.proxy.addRenderRegister(new ItemStack(this), this.getRegistryName(), "inventory");
    }

    protected String getBaseName() {
        return name;
    }

    public boolean getAddToCreativeTab() {
        return true;
    }
}
