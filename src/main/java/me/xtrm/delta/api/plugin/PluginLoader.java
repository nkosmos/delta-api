package me.xtrm.delta.api.plugin;

import me.xtrm.delta.api.exception.InvalidManifestException;
import me.xtrm.delta.api.exception.InvalidPluginException;

import java.io.File;
import java.util.List;

public interface PluginLoader<T extends Plugin<?>> {

    List<T> getLoadedPlugins();

    T loadPlugin(File pluginFolder) throws InvalidPluginException;

    PluginManifest loadPluginManifest(File manifestFile) throws InvalidManifestException;

}
