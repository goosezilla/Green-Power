package goosezilla.greenpower.util;


import com.mojang.authlib.GameProfile;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayer;

import java.util.UUID;

/**
 * This class was pulled from COFH Core
 * <p>
 * {@link} https://github.com/CoFH/CoFHCore/blob/master/src/main/java/cofh/core/entity/CoFHFakePlayer.java
 *
 * @author COFH
 */

public class PlayerFake extends FakePlayer {

    private static GameProfile NAME = new GameProfile(UUID.fromString("08B9E87C-A9F9-5161-AEC6-B671C8F4FCB9"), "[VANHAL]");

    public boolean isSneaking = false;
    public ItemStack previousItem = null;
    public String myName = "[VANHAL]";

    public PlayerFake(WorldServer world, String FakeName) {
        this(world, new GameProfile(UUID.randomUUID(), FakeName));
        myName = FakeName;
    }

    public PlayerFake(WorldServer world, GameProfile FakeName) {
        super(world, FakeName);
        this.addedToChunk = false;
        this.onGround = true;
    }

    public PlayerFake(WorldServer world) {
        this(world, NAME);
    }

    @Override
    public boolean canCommandSenderUseCommand(int var1, String var2) {

        return false;
    }

    @Override
    public boolean isSprinting() {
        return false;
    }

    public void setItemInHand(ItemStack m_item) {

        this.inventory.currentItem = 0;
        this.inventory.setInventorySlotContents(0, m_item);
    }

    public void setItemInHand(int slot) {

        this.inventory.currentItem = slot;
    }

    @Override
    public double getDistanceSq(double x, double y, double z) {

        return 0F;
    }

    @Override
    public double getDistance(double x, double y, double z) {

        return 0F;
    }

    @Override
    public boolean isSneaking() {

        return isSneaking;
    }

    @Override
    public void onUpdate() {

        ItemStack itemstack = previousItem;
        ItemStack itemstack1 = getHeldItemMainhand();

        if (!ItemStack.areItemStacksEqual(itemstack1, itemstack)) {
            if (itemstack != null) {
                getAttributeMap().removeAttributeModifiers(itemstack.getAttributeModifiers(null));
            }
            if (itemstack1 != null) {
                getAttributeMap().applyAttributeModifiers(itemstack1.getAttributeModifiers(null));
            }
            myName = "[VANHAL]" + (itemstack1 != null ? " using " + itemstack1.getDisplayName() : "");
        }
        previousItem = itemstack1 == null ? null : itemstack1.copy();
//		theItemInWorldManager.updateBlockRemoving();
    }

    @Override
    public float getEyeHeight() {

        return 1.1F;
    }

    @Override
    public void addChatMessage(ITextComponent chatmessagecomponent) {

    }

    @Override
    public void addChatComponentMessage(ITextComponent chatmessagecomponent) {

    }

    @Override
    public void addStat(StatBase par1StatBase, int par2) {

    }

    @Override
    public void openGui(Object mod, int modGuiId, World world, int x, int y, int z) {

    }

    @Override
    public void onDeath(DamageSource source) {

        return;
    }


    @Override
    public void addPotionEffect(PotionEffect p_70690_1_) {

    }

    public void setItemInUse(ItemStack heldItemMainhand, int i) {
        this.ticksSinceLastSwing = (int) getCooldownPeriod() + 1;
    }
}