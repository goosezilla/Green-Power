package goosezilla.greenpower.items.materials;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import goosezilla.greenpower.GreenPower;


/**
 * Created by Goose on 26/07/2016.
 */
public class XPCrystal extends Item {

    public XPCrystal(){
        setRegistryName("xp_crystal");
        setUnlocalizedName("BlockXPCrystal");
        GameRegistry.register(this);
        //this.setCreativeTab(GreenPower.TAB_GREENPOWER_ITEMS)
    }

    @SideOnly(Side.CLIENT)
    public void intitModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("greenpower:BlockXPCrystal", "inventory"));
    }
}
