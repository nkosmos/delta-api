package me.xtrm.delta.api.client.registry;

import me.xtrm.delta.api.plugin.IPluginContainer;
import org.gradle.internal.impldep.com.google.common.collect.ImmutableMap;
import org.gradle.internal.impldep.com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * {@link IRegistry} implementation based on {@link IPluginContainer}s
 *
 * @param <T> the registry item
 */
public class PluginBasedRegistry<T> implements IRegistry<IPluginContainer, String, T> {

    protected final Map<IPluginContainer, Map<String, T>> registryMap = Maps.newHashMap();

    @Override
    public void put(IPluginContainer plugin, String name, T value) {
        Map<String, T> registryMapping = registryMap.computeIfAbsent(plugin, p -> Maps.newHashMap());

        if (registryMapping.containsKey(name)) {
            throw new IllegalArgumentException(String.format("Key %s already exists in registry!", name));
        }

        registryMapping.put(name, value);
    }

    @Override
    public <V extends T> V getByClass(Class<? extends V> clazz) {
        return clazz == null ? null : (V) this.registryMap.values()
                .stream()
                .flatMap(m -> m.values().stream())
                .filter(v -> v.getClass() == clazz)
                .findFirst()
                .orElse(null);
    }

    @Override
    public <V extends T> V getByName(String name) {
        return name == null ? null : (V) this.registryMap.values()
                .stream()
                .flatMap(m -> m.values().stream())
                .filter(v -> v.getClass().getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<T> getAll() {
        return this.registryMap.values()
                .stream()
                .flatMap(m -> m.values().stream())
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, T> getAllFor(IPluginContainer plugin) {
        return this.registryMap.computeIfAbsent(plugin, p -> Maps.newHashMap());
    }

    @Override
    public Map<IPluginContainer, Map<String, T>> getRegistryMap() {
        return ImmutableMap.copyOf(this.registryMap);
    }

}
