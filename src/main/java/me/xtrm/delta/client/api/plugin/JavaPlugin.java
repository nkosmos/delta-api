package me.xtrm.delta.client.api.plugin;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract @Data class JavaPlugin {

    private final PluginManifest manifest;
    private final Logger logger = LogManager.getLogger("");

    public abstract void onEnable();

    public abstract void onDisable();

}
