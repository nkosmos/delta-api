package me.xtrm.delta.api.plugin;

import me.xtrm.delta.api.API;
import me.xtrm.delta.api.exception.InvalidManifestException;
import me.xtrm.delta.api.exception.InvalidPluginException;
import me.xtrm.delta.api.plugin.manifest.PluginManifest;

import java.io.File;
import java.util.Collection;
import java.util.List;

public interface IPluginLoader {

    List<IPluginContainer> getLoadedPlugins();

    Collection<IPluginContainer> getPlugins();

    IPluginContainer loadPlugin(File pluginFolder) throws InvalidPluginException;

    PluginManifest loadManifest(File manifestFile) throws InvalidManifestException;

    API provideApi(IPlugin plugin);

}
