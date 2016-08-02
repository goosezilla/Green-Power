package goosezilla.greenpower.items.materials;

import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.config.ModConfig;
import goosezilla.greenpower.items.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.IFuelHandler;

public class ItemGreenCoal extends ItemBase implements IFuelHandler
{
    public EntityPlayer owner = null;

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
            if(fuel.getItemDamage() < 64)
                return ModConfig.greenCoalBurnTime;
            return 0;
        }

        return 0;
    }

    @Override
    public boolean hasContainerItem(ItemStack itemStack)
    {
        if(itemStack.getItemDamage() < 64)
            return true;
        return false;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        if(itemStack.getItemDamage() < 64)
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
        if(owner == null){
            owner = playerIn;
        } else {
            int damage = itemStackIn.getItemDamage();
            if(damage >= ModConfig.greenCoalSmeltsPerLevel && playerIn.experienceLevel > 0)
            {
              playerIn.addExperienceLevel(-1);
              itemStackIn.setItemDamage(damage-ModConfig.greenCoalSmeltsPerLevel);
            }
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
    }

    @Override
    public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        setDamage(itemStack, this.getMaxDamage()-8);
    }
}