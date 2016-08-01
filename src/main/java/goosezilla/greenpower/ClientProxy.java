package goosezilla.greenpower;

import goosezilla.greenpower.entity.EntityGreenPig;
import goosezilla.greenpower.render.RenderEntityGreenPig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.HashMap;
import java.util.Map;

public class ClientProxy extends CommonProxy
{
    private static final Map<ItemStack, ModelResourceLocation> MODEL_LOCATIONS = new HashMap<ItemStack, ModelResourceLocation>();

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);

        for(Map.Entry<ItemStack, ModelResourceLocation> entry : MODEL_LOCATIONS.entrySet()){
            ModelLoader.setCustomModelResourceLocation(entry.getKey().getItem(), entry.getKey().getItemDamage(), entry.getValue());
        }

        RenderingRegistry.registerEntityRenderingHandler(EntityGreenPig.class, RenderEntityGreenPig::new);
    }

    @Override
    public void addRenderRegister(ItemStack stack, ResourceLocation location, String variant) {
        MODEL_LOCATIONS.put(stack, new ModelResourceLocation(location, variant));
    }
}

