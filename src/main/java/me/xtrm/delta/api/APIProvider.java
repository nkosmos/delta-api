package me.xtrm.delta.api;

import me.xtrm.delta.api.exception.InvalidDelegationException;
import me.xtrm.delta.api.plugin.IPluginContainer;

@FunctionalInterface
public interface APIProvider {

    API provideApi(IPluginContainer plugin) throws InvalidDelegationException;

}
