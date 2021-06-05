package me.xtrm.delta.client.api.plugin;

import org.apache.logging.log4j.Logger;

import java.io.File;

public interface Plugin {

    File getDataFolder();

    PluginManifest getPluginManifest();

    PluginLoader getPluginLoader();

    boolean isEnabled();

    void onLoad();

    void onEnable();

    void onDisable();

    Logger getLogger();

}
