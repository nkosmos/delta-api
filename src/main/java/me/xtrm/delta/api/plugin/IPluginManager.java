package me.xtrm.delta.api.plugin;

import me.xtrm.delta.api.plugin.manifest.PluginManifest;

import java.util.Collection;

public interface IPluginManager {

    void enablePlugin(IPlugin<?> plugin);

    void disablePlugin(IPlugin<?> plugin);

    boolean isPluginEnabled(IPlugin<?> plugin);

    boolean isPluginLoaded(String name);

    IPlugin<?> getPluginByName(String name);

    IPlugin<?> getPluginById(String id);

    PluginManifest getPluginManifest(IPlugin<?> plugin);

    Collection<IPlugin<?>> getPlugins();

    Collection<PluginManifest> getPluginManifests();

}
