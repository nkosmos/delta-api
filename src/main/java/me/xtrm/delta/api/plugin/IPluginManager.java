package me.xtrm.delta.api.plugin;

import java.util.UUID;

public interface IPluginManager {

    IPlugin<?> getPlugin(String name);

    IPlugin<?> getPlugin(UUID uuid);

    IPlugin<?>[] getPlugins();

    boolean isPluginLoaded(String name);

    boolean isPluginLoaded(UUID uuid);

    void enablePlugin(IPlugin<?> plugin);

    void disablePlugin(IPlugin<?> plugin);

}
