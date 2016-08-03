package goosezilla.greenpower.networks;

import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.util.PlayerUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

import java.util.UUID;

public class NetworkHelper {
    public static GreenPowerNetwork getGreenPowerNetwork(UUID uuid) {
        World world = DimensionManager.getWorld(0);
        if (world == null || world.getMapStorage() == null)
            return new GPWorldSaveData().getNetwork(uuid);

        GPWorldSaveData saveData = (GPWorldSaveData) world.getMapStorage().getOrLoadData(GPWorldSaveData.class, GPWorldSaveData.ID);
        if (saveData == null) {
            saveData = new GPWorldSaveData();
            world.getMapStorage().setData(GPWorldSaveData.ID, saveData);
        }

        return saveData.getNetwork(uuid);
    }

    public static GreenPowerNetwork getGreenPowerNetwork(EntityPlayer player) {
        return getGreenPowerNetwork(PlayerUtil.getUUIDFromPlayer(player));
    }

    public static GreenPowerNetwork getGreenPowerNetwork(String uuid) {
        try {
            return getGreenPowerNetwork(UUID.fromString(uuid));
        } catch (IllegalArgumentException e) {
            GreenPower.log.error("Unable to convert string to UUID in NetworkHelper. string: " + uuid);
            return null;
        }
    }
}
