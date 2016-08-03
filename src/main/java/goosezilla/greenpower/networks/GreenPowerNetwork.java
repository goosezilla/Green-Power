package goosezilla.greenpower.networks;

import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.util.PlayerUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.UUID;


public class GreenPowerNetwork implements INBTSerializable<NBTTagCompound> {
    private GPWorldSaveData parent;
    private EntityPlayer cachedPlayer;
    private UUID playerId;
    private int playerLevel;

    private GreenPowerNetwork() {
    }

    public static GreenPowerNetwork fromNBT(NBTTagCompound tagCompound) {
        GreenPowerNetwork network = new GreenPowerNetwork();
        network.deserializeNBT(tagCompound);
        return network;
    }

    public static GreenPowerNetwork create(UUID uuid) {
        GreenPowerNetwork network = new GreenPowerNetwork();
        network.playerId = uuid;
        return network;
    }

    private void checkPlayerLevel() {
        EntityPlayer player = PlayerUtil.getPlayerFromUUID(playerId);
        if (player != null)
            playerLevel = player.experienceLevel;
    }

    private void markDirty() {
        if (parent != null)
            parent.markDirty();
        else
            GreenPower.log.error("Network created, no parent set.");
    }

    public GreenPowerNetwork setParent(GPWorldSaveData parent) {
        this.parent = parent;
        markDirty();
        return this;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound tagCompound = new NBTTagCompound();
        tagCompound.setString("playerId", getPlayerId().toString());
        tagCompound.setInteger("playerLevel", getPlayerLevel());
        return tagCompound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        this.playerId = UUID.fromString(nbt.getString("playerId"));
        this.playerLevel = nbt.getInteger("playerLevel");
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    @Override
    public String toString() {
        checkPlayerLevel();
        return "GPN " + playerId.toString() + " Level:" + playerLevel;
    }
}
