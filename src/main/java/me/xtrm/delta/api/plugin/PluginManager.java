package me.xtrm.delta.api.plugin;

import java.util.UUID;

public interface PluginManager {

    Plugin<?> getPlugin(String name);

    Plugin<?> getPlugin(UUID uuid);

    Plugin<?>[] getPlugins();

    boolean isPluginLoaded(String name);

    boolean isPluginLoaded(UUID uuid);

    void enablePlugin(Plugin<?> plugin);

    void disablePlugin(Plugin<?> plugin);

}
