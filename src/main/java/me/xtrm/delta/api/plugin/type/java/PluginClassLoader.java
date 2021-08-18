package me.xtrm.delta.api.plugin.type.java;

import me.xtrm.delta.api.plugin.IPluginLoader;
import org.apache.logging.log4j.Logger;

public interface PluginClassLoader {

    void initialize(JavaPlugin javaPlugin);

    default void init0(JavaPlugin javaPlugin, IPluginLoader pluginLoader, Logger logger, PluginClassLoader classLoader) {
        javaPlugin.init(pluginLoader, logger, classLoader);
    }

}
