package me.xtrm.delta.api;

import me.xtrm.delta.api.exception.InvalidDelegationException;
import me.xtrm.delta.api.plugin.IPluginContainer;

import java.util.ServiceLoader;

public enum APIFacade {
    INSTANCE;

    private final ServiceLoader<APIProvider> providerLoader;
    private APIProvider apiProvider;

    APIFacade() {
        this.providerLoader = ServiceLoader.load(APIProvider.class);
    }

    public API provideApi(IPluginContainer plugin) throws InvalidDelegationException {
        if (this.apiProvider == null) {
            this.apiProvider = providerLoader.iterator().next();
        }

        return this.apiProvider.provideApi(plugin);
    }

}
