package goosezilla.greenpower.items;

import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.util.ItemUtil;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

/**
 * Created by Goose on 31/07/2016.
 */
public class FoodBase extends ItemFood
{
    private final String name;

    public FoodBase(int amount, float saturation, boolean isWolfFood, String name) {
        super(amount, saturation, isWolfFood);
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
