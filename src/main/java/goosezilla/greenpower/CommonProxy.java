package goosezilla.greenpower;
import net.minecraftforge.fml.common.registry.GameRegistry;
import goosezilla.greenpower.worldgen.OreGen;


/**
 * Created by Goose on 26/07/2016.
 */
public class CommonProxy {

    public void loadRenders() {
    }

    public void addChatMessage(String string) {
    }

    public void addChatMessage(String string, int id) {
    }

    public void registerRenderers(GreenPower greenPower) {
    }

    public void registerWorldGenerators() {
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
    }
}
