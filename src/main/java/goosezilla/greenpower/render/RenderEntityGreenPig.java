package goosezilla.greenpower.render;

import goosezilla.greenpower.entity.EntityGreenPig;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderEntityGreenPig extends RenderLiving<EntityGreenPig>
{
	private final ResourceLocation textures = new ResourceLocation("greenpower:textures/models/greenpig.png");

	public RenderEntityGreenPig(RenderManager renderManager)
	{
		super(renderManager, new ModelPig(), 0);
		this.addLayer(new LayerHeldItem(this));
	}

	

	@Override
	protected ResourceLocation getEntityTexture(EntityGreenPig entity)
	{
		return textures;
	}
}