package me.xtrm.delta.api;

import me.xtrm.delta.api.plugin.IPlugin;
import me.xtrm.delta.api.exception.InvalidDelegationException;

@FunctionalInterface
public interface APIProvider {

    API provideApi(IPlugin<?> plugin) throws InvalidDelegationException;

}
