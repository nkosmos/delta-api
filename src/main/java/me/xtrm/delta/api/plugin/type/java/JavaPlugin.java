package me.xtrm.delta.api.plugin.type.java;

import me.xtrm.delta.api.API;
import me.xtrm.delta.api.APIFacade;
import me.xtrm.delta.api.plugin.IPlugin;
import me.xtrm.delta.api.plugin.IPluginLoader;
import me.xtrm.delta.api.plugin.PluginManifest;
import org.apache.logging.log4j.Logger;

import java.io.File;

public abstract class JavaPlugin implements IPlugin<JavaPlugin> {

    private IPluginLoader<JavaPlugin> pluginLoader;
    private Logger logger;
    private File dataFolder;
    private PluginManifest manifest;
    private PluginClassLoader delegateClassLoader;
    private API api;

    public JavaPlugin() {
        ClassLoader classLoader = getClass().getClassLoader();
        if (!(classLoader instanceof PluginClassLoader)) {
            throw new UnsupportedOperationException("Can't initialize an externally loaded plugin!");
        }
        ((PluginClassLoader) classLoader).initialize(this);
    }

    final void init(IPluginLoader<JavaPlugin> pluginLoader, Logger logger, PluginClassLoader classLoader) {
        this.pluginLoader = pluginLoader;
        this.logger = logger;
        this.delegateClassLoader = classLoader;

        this.api = APIFacade.INSTANCE.provideApi(this);
    }

    public abstract void onEnable();

    public abstract void onDisable();

    protected final API getApi() {
        return this.api;
    }

    @Override
    public final IPluginLoader<JavaPlugin> getLoader() {
        return this.pluginLoader;
    }

    protected final Logger getLogger() {
        return this.logger;
    }

    @Override
    public final File getDataFolder() {
        return dataFolder;
    }

    @Override
    public final PluginManifest getManifest() {
        return manifest;
    }

    public final PluginClassLoader getDelegateClassLoader() {
        return delegateClassLoader;
    }
}
