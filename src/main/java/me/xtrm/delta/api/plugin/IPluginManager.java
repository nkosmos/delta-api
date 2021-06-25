package me.xtrm.delta.api.plugin;

import java.util.Collection;

public interface IPluginManager {

    void enablePlugin(IPlugin<?> plugin);

    void disablePlugin(IPlugin<?> plugin);

    boolean isPluginLoaded(String name);

    IPlugin<?> getPluginByName(String name);

    IPlugin<?> getPluginById(String id);

    PluginManifest getPluginManifest(IPlugin<?> plugin);

    Collection<IPlugin<?>> getPlugins();

    Collection<PluginManifest> getPluginManifests();

}
