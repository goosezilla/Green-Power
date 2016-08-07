package goosezilla.greenpower.items.materials;

import com.google.common.base.Strings;
import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.helper.NBTHelper;
import goosezilla.greenpower.helper.TextHelper;
import goosezilla.greenpower.items.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;


/**
 * Created by Goose on 06/08/2016.
 */
public class ItemXPBank extends ItemBase {

    public ItemXPBank(String name) {
        super(name);
        this.setMaxStackSize(1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        //Take levels out
        if (playerIn.isSneaking()){
            if(getStoredXP(itemStackIn) > convertFromLevel(playerIn.experienceLevel-1)) {
                addStoredXP(itemStackIn, -convertFromLevel(playerIn.experienceLevel));
                GreenPower.log.info("xp after adding: " + getStoredXP(itemStackIn));
                playerIn.addExperienceLevel(1);
            }
        //Put levels in
        } else {
            if (playerIn.experienceLevel >=1) {
                addStoredXP(itemStackIn, convertFromLevel(playerIn.experienceLevel-1));
                GreenPower.log.info("xp after taking: " + getStoredXP(itemStackIn));
                playerIn.addExperienceLevel(-1);
            }
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
    }

    private void addStoredXP(ItemStack itemStackIn, int xp)
    {
      int currentXP = getStoredXP(itemStackIn);
      currentXP += xp;
      setStoredXP(itemStackIn, currentXP);
    }

    public void setStoredXP(ItemStack itemStackIn, int xp){
        NBTHelper.ensureNBT(itemStackIn).getTagCompound().setInteger("Stored", xp);
    }

    public int getStoredXP(ItemStack itemStackIn){
        return NBTHelper.ensureNBT(itemStackIn).getTagCompound().getInteger("Stored");
    }

    public int convertFromLevel(int playerLvl){
        if(playerLvl >30){
            return (playerLvl*9)-158;
        }if (playerLvl >15) {
            return (playerLvl*5)-38;
        }else{
            return (playerLvl*2)+7;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        NBTHelper.ensureNBT(stack);
        tooltip.add(TextHelper.localizeEffect("tooltip.greenpower.storedXP", stack.getTagCompound().getString("Stored")));
    }
}
