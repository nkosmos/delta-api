package me.xtrm.delta.api;

import me.xtrm.delta.api.client.ClientAPI;
import me.xtrm.delta.api.launch.LauncherAPI;
import me.xtrm.delta.api.plugin.IPluginContainer;
import me.xtrm.delta.api.plugin.IPluginManager;

public interface API {

    IPluginContainer getBearerContainer();

    IPluginManager getPluginManager();

    ClientAPI getClient();

    LauncherAPI getLauncher();

}
