package goosezilla.greenpower.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBase extends ItemBlock
{
    public ItemBlockBase(Block block)
    {
        super(block);
        this.setHasSubtypes(false);
        this.setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return this.getUnlocalizedName();
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }
}
