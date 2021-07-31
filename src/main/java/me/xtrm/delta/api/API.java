package me.xtrm.delta.api;

import me.xtrm.delta.api.client.ClientAPI;
import me.xtrm.delta.api.launch.LauncherAPI;
import me.xtrm.delta.api.plugin.IPlugin;
import me.xtrm.delta.api.plugin.IPluginManager;
import me.xtrm.delta.api.script.ScriptAPI;

public interface API {

    IPlugin<?> getBearerPlugin();

    IPluginManager getPluginManager();

    ClientAPI getClient();

    LauncherAPI getLauncher();

    ScriptAPI getScriptAPI();

}
