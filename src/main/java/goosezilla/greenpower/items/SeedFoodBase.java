package goosezilla.greenpower.items;

import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.util.ItemUtil;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;

/**
 * Created by Goose on 01/08/2016.
 */
public class SeedFoodBase extends ItemSeedFood {

    private final String name;

    public SeedFoodBase(int healAmount, float saturation, Block crops, Block soil, String name) {
        super(healAmount, saturation, crops, soil);
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
