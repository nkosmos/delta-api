package me.xtrm.delta.api.plugin;

import me.xtrm.delta.api.exception.InvalidManifestException;
import me.xtrm.delta.api.exception.InvalidPluginException;

import java.io.File;
import java.util.List;

public interface IPluginLoader<T extends IPlugin<?>> {

    List<T> getLoadedPlugins();

    T loadPlugin(File pluginFolder) throws InvalidPluginException;

    PluginManifest loadManifest(File manifestFile) throws InvalidManifestException;

}
