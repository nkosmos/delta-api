package me.xtrm.delta.api;

import me.xtrm.delta.api.plugin.Plugin;
import me.xtrm.delta.api.exception.InvalidDelegationException;

@FunctionalInterface
public interface APIProvider {

    API provideApi(Plugin<?> plugin) throws InvalidDelegationException;

}
