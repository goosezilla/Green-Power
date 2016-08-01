package goosezilla.greenpower.potion;

import com.google.common.base.Predicate;
import goosezilla.greenpower.GreenPower;
import goosezilla.greenpower.config.ModConfig;
import goosezilla.greenpower.registry.ModFoods;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import java.lang.reflect.Method;

public class Potions {
    private static final String LOVE = "love";

    private PotionType love;
    private LovePotion potionLove;

    private Method regTypeConvMethod;

    public Potions() {
        potionLove = LovePotion.create();
        love = new PotionType(LOVE, new PotionEffect(potionLove, 100));

        try {
            regTypeConvMethod = ReflectionHelper.findMethod(PotionHelper.class, null, new String[]{"registerPotionTypeConversion", "func_185204_a"},
                    PotionType.class, Predicate.class, PotionType.class);
        } catch (Exception e) {
            GreenPower.log.error("Could not find method to register potions. Potions will not be brewable.");
            e.printStackTrace();
        }
    }

    public PotionType getLove() {
        return love;
    }

    public void registerPotions() {
        PotionType.REGISTRY.register(ModConfig.lovePotionID, new ResourceLocation(LOVE), love);

        Predicate<ItemStack> greenCarrot = new ItemPredicateInstance(ModFoods.foodGreenCarrot);
        registerPotionTypeConversion(PotionTypes.WATER, greenCarrot, love);
    }

    private void registerPotionTypeConversion(PotionType input, Predicate<ItemStack> reagentPredicate, PotionType output) {
        if (regTypeConvMethod == null) {
            return;
        }
        try {
            regTypeConvMethod.invoke(null, input, reagentPredicate, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class ItemPredicateInstance implements Predicate<ItemStack> {
        private final Item item;
        private final int meta;

        public ItemPredicateInstance(Item itemIn) {
            this(itemIn, -1);
        }

        public ItemPredicateInstance(Item itemIn, int metaIn) {
            this.item = itemIn;
            this.meta = metaIn;
        }

        public boolean apply(ItemStack p_apply_1_) {
            return p_apply_1_ != null && p_apply_1_.getItem() == this.item && (this.meta == -1 || this.meta == p_apply_1_.getMetadata());
        }
    }
}
