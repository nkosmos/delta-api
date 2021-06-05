package me.xtrm.delta.client.api.plugin;

import java.util.UUID;

public interface PluginManager {

    Plugin getPlugin(String name);

    Plugin getPlugin(UUID uuid);

    Plugin[] getPlugins();

}
