package goosezilla.greenpower.registry;
import goosezilla.greenpower.items.tools.GreenIronPick;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Goose on 28/07/2016.
 */
public class ModTools {

        public static GreenIronPick GREEN_IRON_PICK;

        public static void init() {

            GREEN_IRON_PICK = new GreenIronPick();
        }

        @SideOnly(Side.CLIENT)
        public static void initModels() {

            GREEN_IRON_PICK.initModel();
        }
    }

