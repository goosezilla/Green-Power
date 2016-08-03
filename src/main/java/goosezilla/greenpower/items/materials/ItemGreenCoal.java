package goosezilla.greenpower.items.materials;

import com.google.common.base.Strings;
import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.config.ModConfig;
import goosezilla.greenpower.helper.NBTHelper;
import goosezilla.greenpower.helper.TextHelper;
import goosezilla.greenpower.items.ItemBase;
import goosezilla.greenpower.util.PlayerUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.UUID;

public class ItemGreenCoal extends ItemBase implements IFuelHandler
{
    public ItemGreenCoal(String name)
    {
        super(name);
        this.setHasSubtypes(false);
        this.setMaxStackSize(1);
        this.setMaxDamage(64);
    }

    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if(fuel == null)
            return 0;

        Item fuelItem = fuel.getItem();

        if(fuelItem instanceof ItemGreenCoal)
        {
            if (fuel.getItemDamage() < fuel.getMaxDamage()) {
/*                GreenPowerNetwork gpn = NetworkHelper.getGreenPowerNetwork(getOwnerUUID(fuel));
                if (gpn != null)
                    GreenPower.log.info("Burning. " + gpn.toString());
                    */
                return ModConfig.greenCoalBurnTime;
            }
            return 0;
        }

        return 0;
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack)
    {
        return itemStack.getItemDamage() < itemStack.getMaxDamage();
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        if (itemStack.getItemDamage() < itemStack.getMaxDamage())
        {
            ItemStack copiedStack = itemStack.copy();
            copiedStack.setItemDamage(itemStack.getItemDamage()+1);
            copiedStack.stackSize = 1;
            return copiedStack;
        }

        return itemStack;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        int damage = itemStackIn.getItemDamage();
        if (damage >= ModConfig.greenCoalSmeltsPerLevel && playerIn.experienceLevel > 0) {
            playerIn.addExperienceLevel(-1);
            itemStackIn.setItemDamage(damage - ModConfig.greenCoalSmeltsPerLevel);
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        setDamage(itemStack, this.getMaxDamage() - 8);
        saveOwner(itemStack, PlayerUtil.getUUIDFromPlayer(entityPlayer));
    }

    public void saveOwner(ItemStack stack, UUID owner) {
        GreenPower.log.error("SAVEOWNER IS CALLED.");
        if (owner == null)
            GreenPower.log.info("SetOwner, OWNER IS NULL");
        String uuid = owner.toString();
        GreenPower.log.info("SetOwner, uuid: " + uuid);
        String name = PlayerUtil.getUsernameFromUUID(owner);
        GreenPower.log.info("SetOwner, username: " + name);
        NBTHelper.ensureNBT(stack).getTagCompound().setString(GreenPower.Constants.NBT.OWNER_UUID, owner.toString());
        NBTHelper.ensureNBT(stack).getTagCompound().setString(GreenPower.Constants.NBT.OWNER_NAME, PlayerUtil.getUsernameFromUUID(owner));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        NBTHelper.ensureNBT(stack);

        if (!Strings.isNullOrEmpty(getOwnerUUID(stack)))
            tooltip.add(TextHelper.localizeEffect("tooltip.greenpower.currentOwner", PlayerUtil.getUsernameFromStack(stack)));
    }

    private String getOwnerUUID(ItemStack stack) {
        return stack != null ? NBTHelper.ensureNBT(stack).getTagCompound().getString(GreenPower.Constants.NBT.OWNER_UUID) : null;
    }

}