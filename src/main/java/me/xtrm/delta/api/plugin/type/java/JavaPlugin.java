package me.xtrm.delta.api.plugin.type.java;

import lombok.AccessLevel;
import lombok.Getter;
import me.xtrm.delta.api.API;
import me.xtrm.delta.api.plugin.IPlugin;
import me.xtrm.delta.api.plugin.IPluginLoader;
import me.xtrm.delta.api.plugin.manifest.PluginManifest;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Getter
public abstract class JavaPlugin implements IPlugin {

    private IPluginLoader pluginLoader;

    @Getter(AccessLevel.PROTECTED) private Logger logger;
    private File dataFolder;
    private PluginManifest manifest;
    private PluginClassLoader delegateClassLoader;
    @Getter(AccessLevel.PROTECTED) private API api;

    public JavaPlugin() {
        ClassLoader classLoader = getClass().getClassLoader();
        if (!(classLoader instanceof PluginClassLoader)) {
            throw new UnsupportedOperationException("Can't initialize an externally loaded plugin!");
        }
        ((PluginClassLoader) classLoader).initialize(this);
    }

    final void init(IPluginLoader pluginLoader, Logger logger, PluginClassLoader classLoader) {
        this.pluginLoader = pluginLoader;
        this.logger = logger;
        this.delegateClassLoader = classLoader;
        this.api = pluginLoader.provideApi(this);
    }

    public abstract void onEnable();

    public abstract void onDisable();
}
