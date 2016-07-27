package goosezilla.greenpower.items.materials;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import goosezilla.greenpower.GreenPower;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;


/**
 * Created by Goose on 26/07/2016.
 */
public class XPCrystal extends Item {

    public XPCrystal(){
        setRegistryName("xp_crystal");
        setUnlocalizedName("XPCrystal");
        GameRegistry.register(this);
        //this.setCreativeTab(GreenPower.TAB_GREENPOWER_ITEMS)
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        if (!world.isRemote) {
            world.spawnEntityInWorld(new EntityXPOrb(world, player.posX + 0.5, player.posY + 0.5, player.posZ + 0.5, 20));
            stack.stackSize--;
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }

        @SideOnly(Side.CLIENT)
        public void initModel() {
            ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("greenpower:XPCrystal", "inventory"));
        }
    }

