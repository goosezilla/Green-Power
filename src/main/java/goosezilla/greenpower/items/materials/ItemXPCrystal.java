package goosezilla.greenpower.items.materials;
import goosezilla.greenpower.items.ItemBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;


/**
 * Created by Goose on 26/07/2016.
 */
public class ItemXPCrystal extends ItemBase
{

    public ItemXPCrystal(String name)
    {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        if (!world.isRemote) {
            world.spawnEntityInWorld(new EntityXPOrb(world, player.posX + 0.5, player.posY + 0.5, player.posZ + 0.5, 20));
            stack.stackSize--;
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }
}

