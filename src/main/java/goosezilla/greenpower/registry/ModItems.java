package goosezilla.greenpower.registry;

import goosezilla.greenpower.blocks.BlockXPCrystal;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import goosezilla.greenpower.items.materials.*;

/**
 * Created by Goose on 26/07/2016.
 */
public class ModItems {

    public static XPCrystal XP_CRYSTAL;
    public static GreenIron GREEN_IRON;

    public static void init() {

        XP_CRYSTAL = new XPCrystal();
        GREEN_IRON = new GreenIron();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {

        XP_CRYSTAL.initModel();
        GREEN_IRON.initModel();
   }
}
