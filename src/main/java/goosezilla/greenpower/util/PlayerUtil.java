package goosezilla.greenpower.util;

import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.helper.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.UsernameCache;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.util.UUID;


public class PlayerUtil {
    private PlayerUtil() {
    }

    public static EntityPlayer getPlayerFromUUID(String uuid) {
        return getPlayerFromUsername(getUsernameFromUUID(uuid));
    }

    public static EntityPlayer getPlayerFromUUID(UUID uuid) {
        return getPlayerFromUsername(getUsernameFromUUID(uuid));
    }

    public static UUID getUUIDFromPlayer(EntityPlayer player) {
        return player.getGameProfile().getId();
    }

    public static String getUsernameFromUUID(String uuid) {
        return UsernameCache.getLastKnownUsername(UUID.fromString(uuid));
    }

    public static String getUsernameFromUUID(UUID uuid) {
        return UsernameCache.getLastKnownUsername(uuid);
    }

    public static EntityPlayer getPlayerFromUsername(String username) {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
            return null;

        return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(username);
    }

    public static String getUsernameFromStack(ItemStack stack) {
            stack = NBTHelper.ensureNBT(stack);
        return stack.getTagCompound().getString(GreenPower.Constants.NBT.OWNER_NAME);
    }
}
