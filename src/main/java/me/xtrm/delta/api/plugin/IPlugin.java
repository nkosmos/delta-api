package me.xtrm.delta.api.plugin;

import java.io.File;

public interface IPlugin<T extends IPlugin<?>> {

    File getDataFolder();

    PluginManifest getManifest();

    IPluginLoader<T> getLoader();

}
