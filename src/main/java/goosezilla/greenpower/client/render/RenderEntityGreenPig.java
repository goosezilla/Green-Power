package goosezilla.greenpower.client.render;

import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.entity.EntityGreenPig;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderEntityGreenPig extends RenderLiving<EntityGreenPig> {
    protected final ResourceLocation textures = new ResourceLocation(GreenPower.MODID + ":textures/models/greenpig.png");

    public RenderEntityGreenPig(RenderManager manager) {
        super(manager, new ModelPig(), 0);
        this.addLayer(new LayerHeldItem(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGreenPig entity) {
        return textures;
    }
}
