package goosezilla.greenpower;

import goosezilla.greenpower.registry.ModBlocks;
import goosezilla.greenpower.registry.ModItems;
import goosezilla.greenpower.registry.ModTools;

/**
 * Created by Goose on 26/07/2016.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers(GreenPower ins) {

        ModItems.initModels();
        ModBlocks.registerRenders();
        ModTools.initModels();
    }
}

