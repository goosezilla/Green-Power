package goosezilla.greenpower.items.materials;

import goosezilla.greenpower.items.ItemBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemXPCrystal extends ItemBase
{

    public ItemXPCrystal(String name)
    {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer player, EnumHand hand) {
        if (!worldIn.isRemote) {
            worldIn.spawnEntityInWorld(new EntityXPOrb(worldIn, player.posX + 0.5, player.posY + 0.5, player.posZ + 0.5, 20));
            stack.stackSize--;
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }
}

