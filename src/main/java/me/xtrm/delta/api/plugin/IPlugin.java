package me.xtrm.delta.api.plugin;

import me.xtrm.delta.api.plugin.manifest.PluginManifest;

import java.io.File;

public interface IPlugin<T extends IPlugin<?>> {

    File getPluginFolder();

    File getDataFolder();

    PluginManifest getManifest();

    IPluginLoader<T> getLoader();

}
