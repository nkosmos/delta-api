package me.xtrm.delta.api.plugin;

public interface IPluginManager {

    void enable(IPluginContainer plugin);

    void disable(IPluginContainer plugin);

    boolean isEnabled(IPluginContainer plugin);

    boolean isLoaded(String name);

    IPluginContainer getByName(String name);

    IPluginContainer getById(String id);

}
