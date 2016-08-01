package goosezilla.greenpower.blocks;

import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.util.ItemUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public abstract class BlockBase extends Block
{
    private final String name;

    public BlockBase(Material material, String name)
    {
        super(material);
        this.name = name;

        this.register();
    }

    protected void register()
    {
        ItemUtil.registerBlock(this, this.getItemBlock(), this.getBaseName(), this.getAddToCreativeTab());

        this.registerRendering();
    }

    protected void registerRendering()
    {
        GreenPower.proxy.addRenderRegister(new ItemStack(this), this.getRegistryName(), "inventory");
    }

    public boolean getAddToCreativeTab() {
        return true;
    }

    protected String getBaseName() {
        return this.name;
    }

    protected ItemBlockBase getItemBlock()
    {
        return new ItemBlockBase(this);
    }
}
