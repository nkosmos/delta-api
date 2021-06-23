package me.xtrm.delta.api.plugin;

import java.io.File;

public interface Plugin<T extends Plugin<?>> {

    File getDataFolder();

    PluginManifest getManifest();

    PluginLoader<T> getLoader();

    boolean isEnabled();

    boolean setEnabled(boolean state);

}
