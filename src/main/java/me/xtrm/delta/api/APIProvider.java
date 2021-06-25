package me.xtrm.delta.api;

import me.xtrm.delta.api.exception.InvalidDelegationException;
import me.xtrm.delta.api.plugin.IPlugin;

@FunctionalInterface
public interface APIProvider {

    API provideApi(IPlugin<?> plugin) throws InvalidDelegationException;

}
