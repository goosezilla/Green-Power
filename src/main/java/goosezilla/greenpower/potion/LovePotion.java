package goosezilla.greenpower.potion;

import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.util.PlayerFake;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Pobiega on 2016-08-01.
 */
public class LovePotion extends Potion {
    public static final String NAME = GreenPower.MODID + ".lovePotion";

    protected PlayerFake fake;

    private LovePotion() {
        super(false, 0);
        setPotionName(NAME);
        setRegistryName(NAME);
    }

    public static LovePotion create() {
        LovePotion res = new LovePotion();
        GameRegistry.register(res);
        return res;
    }

    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    @Override
    public void performEffect(EntityLivingBase entityIn, int amplifier) {
        if (entityIn instanceof EntityAnimal) {
            EntityAnimal animal = (EntityAnimal) entityIn;
            initFake(animal.worldObj);
            if (!animal.isInLove())
                animal.setInLove(fake);
        }
    }

    protected void initFake(World worldin) {
        if (fake == null) {
            fake = new PlayerFake((WorldServer) worldin, "LOVEPOTIONMAN");
            fake.setPosition(0, 0, 0);
        }
        fake.inventory.clear();
    }

    @Override
    public int getLiquidColor() {
        return 0xF71D7F;
    }
}
