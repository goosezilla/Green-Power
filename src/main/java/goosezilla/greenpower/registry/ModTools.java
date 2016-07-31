package goosezilla.greenpower.registry;

import goosezilla.greenpower.items.tools.GreenIronPick;

public class ModTools
{
    public static GreenIronPick itemGreenIronPick;

    public static void init() {

        itemGreenIronPick = new GreenIronPick("itemGreenIronPick");
    }
}