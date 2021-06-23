package me.xtrm.delta.api.plugin.type.java;

import me.xtrm.delta.api.plugin.Plugin;
import me.xtrm.delta.api.plugin.PluginLoader;
import me.xtrm.delta.api.plugin.PluginManifest;
import org.apache.logging.log4j.Logger;

import java.io.File;

public abstract class JavaPlugin implements Plugin<JavaPlugin> {

    private PluginLoader<JavaPlugin> pluginLoader;
    private Logger logger;
    private File dataFolder;
    private PluginManifest manifest;
    private PluginClassLoader delegateClassLoader;

    public JavaPlugin() {
        ClassLoader classLoader = getClass().getClassLoader();
        if (!(classLoader instanceof PluginClassLoader)) {
            throw new UnsupportedOperationException("Can't initialize an externally loaded plugin!");
        }
        ((PluginClassLoader) classLoader).initialize(this);
    }

    private void init(PluginLoader<JavaPlugin> pluginLoader, Logger logger, PluginClassLoader classLoader) {
        this.pluginLoader = pluginLoader;
        this.logger = logger;
        this.delegateClassLoader = classLoader; // bute ma sice
    }

    public void onLoad() {
    }

    void onEnable() {
    }

    void onDisable() {
    }

    @Override
    public PluginLoader<JavaPlugin> getLoader() {
        return this.pluginLoader;
    }

    protected Logger getLogger() {
        return this.logger;
    }

    @Override
    public File getDataFolder() {
        return dataFolder;
    }

    @Override
    public PluginManifest getManifest() {
        return manifest;
    }

    public PluginClassLoader getDelegateClassLoader() {
        return delegateClassLoader;
    }
}
