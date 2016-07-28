package goosezilla.greenpower.items.tools;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Goose on 28/07/2016.
 */
public class GreenIronPick extends ItemPickaxe{

    public GreenIronPick(){
        super(ToolMaterial.IRON);
        setRegistryName("green_iron_pick");
        setUnlocalizedName("GreenIronPick");
        GameRegistry.register(this);
        //this.setCreativeTab(GreenPower.TAB_GREENPOWER_ITEMS)
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("greenpower:GreenIronPick", "inventory"));
    }


}
