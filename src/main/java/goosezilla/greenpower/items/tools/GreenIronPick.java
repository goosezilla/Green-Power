package goosezilla.greenpower.items.tools;

import goosezilla.greenpower.util.GreenIronUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Goose on 28/07/2016.
 */
public class GreenIronPick extends ItemPickaxe {

    public GreenIronPick(){
        super(ToolMaterial.IRON);
        setRegistryName("green_iron_pick");
        setUnlocalizedName("GreenIronPick");
        GameRegistry.register(this);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        GreenIronUtil.checkForMining(worldIn, state, pos);
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("greenpower:GreenIronPick", "inventory"));
    }
}