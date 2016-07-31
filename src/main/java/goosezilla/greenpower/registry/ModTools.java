package goosezilla.greenpower.registry;
import goosezilla.greenpower.items.tools.GreenIronPick;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Goose on 28/07/2016.
 */
public class ModTools
{
    public static GreenIronPick itemGreenIronPick;

    public static void init() {

        itemGreenIronPick = new GreenIronPick("itemGreenIronPick");
    }
}