package goosezilla.greenpower.config;

import com.google.common.collect.Lists;
import goosezilla.greenpower.GreenPower;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.GuiModList;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.List;
import java.util.Set;

public class ConfigGui extends GuiConfig {
    public ConfigGui(GuiScreen parentScreen) {
        super(parentScreen, getConfigElements(), GreenPower.MODID, false, false, getTitle(parentScreen));
    }

    private static String getTitle(GuiScreen parent) {
        if (parent instanceof GuiModList) {
            return GuiConfig.getAbridgedConfigPath(ModConfig.getConfig().toString());
        }
        return GreenPower.MODNAME;
    }

    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = Lists.newArrayList();

        list.add(new ConfigElement(ModConfig.Balance));

        return list;
    }

    public static class ConfigGuiFactory implements IModGuiFactory {

        @Override
        public void initialize(Minecraft minecraftInstance) {

        }

        @Override
        public Class<? extends GuiScreen> mainConfigGuiClass() {
            return ConfigGui.class;
        }

        @Override
        public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
            // dead code
            return null;
        }

        @Override
        public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
            // dead code
            return null;
        }
    }
}
