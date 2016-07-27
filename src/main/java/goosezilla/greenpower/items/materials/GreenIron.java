package goosezilla.greenpower.items.materials;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Goose on 27/07/2016.
 */
public class GreenIron extends Item{
    public GreenIron(){
        setRegistryName("green_iron");
        setUnlocalizedName("GreenIron");
        GameRegistry.register(this);
        //this.setCreativeTab(GreenPower.TAB_GREENPOWER_ITEMS)
    }
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("greenpower:GreenIron", "inventory"));
    }
}
