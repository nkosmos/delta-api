package me.xtrm.delta.client.api.plugin;

import me.xtrm.delta.client.api.plugin.exception.InvalidManifestException;
import me.xtrm.delta.client.api.plugin.exception.InvalidPluginException;

import java.io.File;

public interface PluginLoader {

    Plugin loadPlugin(File pluginFile) throws InvalidPluginException;

    PluginManifest getPluginManifest(File pluginFile) throws InvalidManifestException;

    void enablePlugin(Plugin plugin);

    void disablePlugin(Plugin plugin);

}
