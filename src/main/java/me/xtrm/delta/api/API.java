package me.xtrm.delta.api;

import me.xtrm.delta.api.client.ClientAPI;
import me.xtrm.delta.api.launch.LaunchAPI;
import me.xtrm.delta.api.plugin.Plugin;
import me.xtrm.delta.api.plugin.PluginManager;
import me.xtrm.delta.api.script.ScriptAPI;

public interface API {

    Plugin<?> getBearerPlugin();

    PluginManager getPluginManager();

    ClientAPI getClientAPI();

    LaunchAPI getLaunchAPI();

    ScriptAPI getScriptAPI();

}
