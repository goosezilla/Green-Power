package goosezilla.greenpower.items.materials;

import goosezilla.greenpower.items.ItemBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class ItemMutationPotion extends ItemBase {
    public ItemMutationPotion(String name) {
        super(name);
        this.setHasSubtypes(false);
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack item, EntityPlayer player, EntityLivingBase entity, EnumHand hand) {
        if (entity.worldObj.isRemote || player == null) {
            return false;
        }

        if (entity instanceof EntityPig) {
            Entity greenPig = ItemMonsterPlacer.spawnCreature(entity.worldObj, "greenpower.entityGreenPig", entity.posX, entity.posY, entity.posZ);
            if (greenPig == null)
                return false;
            entity.worldObj.removeEntity(entity);

            if (!player.capabilities.isCreativeMode) {
                --item.stackSize;
            }

            return true;
        }

        return false;
    }

}
