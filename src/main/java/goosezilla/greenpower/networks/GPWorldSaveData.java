package goosezilla.greenpower.networks;

import goosezilla.greenpower.GreenPower;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.WorldSavedData;
import net.minecraftforge.common.util.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GPWorldSaveData extends WorldSavedData {
    public static final String ID = GreenPower.MODID + "-NETWORKS";
    private static final String tagID = "gpNetworkData";

    private Map<UUID, GreenPowerNetwork> gpNetworks = new HashMap<UUID, GreenPowerNetwork>();

    public GPWorldSaveData(String id) {
        super(id);
    }

    public GPWorldSaveData() {
        this(ID);
    }

    public GreenPowerNetwork getNetwork(UUID playerId) {
        if (!gpNetworks.containsKey(playerId))
            gpNetworks.put(playerId, GreenPowerNetwork.create(playerId).setParent(this));
        return gpNetworks.get(playerId);
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        NBTTagList networkData = tagCompound.getTagList(tagID, Constants.NBT.TAG_COMPOUND);

        for (int i = 0; i < networkData.tagCount(); i++) {
            NBTTagCompound data = networkData.getCompoundTagAt(i);
            GreenPowerNetwork network = GreenPowerNetwork.fromNBT(data);
            network.setParent(this);
            gpNetworks.put(network.getPlayerId(), network);
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tagCompound) {
        NBTTagList networkData = new NBTTagList();
        for (GreenPowerNetwork gpNetwork : gpNetworks.values())
            networkData.appendTag(gpNetwork.serializeNBT());

        tagCompound.setTag(tagID, networkData);

        return tagCompound;
    }
}
