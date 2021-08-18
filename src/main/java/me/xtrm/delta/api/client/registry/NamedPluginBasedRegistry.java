package me.xtrm.delta.api.client.registry;

import me.xtrm.delta.api.plugin.IPluginContainer;
import org.gradle.internal.impldep.com.google.common.collect.ImmutableMap;
import org.gradle.internal.impldep.com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * {@link IRegistry} implementation based on {@link IPluginContainer}s,
 * using a {@code String} as the key.
 *
 * @param <V> the registry item
 */
public class NamedPluginBasedRegistry<V> implements IRegistry<IPluginContainer, String, V> {
    protected final Map<IPluginContainer, Map<String, V>> registryMap = Maps.newHashMap();

    @Override
    public void put(IPluginContainer plugin, String name, V value) {
        Map<String, V> registryMapping = registryMap.computeIfAbsent(plugin, p -> Maps.newHashMap());

        if (registryMapping.containsKey(name)) {
            throw new IllegalArgumentException(String.format("Key %s already exists in registry!", name));
        }

        registryMapping.put(name, value);
    }

    @Override
    public <U extends V> U getByClass(Class<? extends U> clazz) {
        return clazz == null ? null : (U) this.registryMap.values()
                .stream()
                .flatMap(m -> m.values().stream())
                .filter(v -> v.getClass() == clazz)
                .findFirst()
                .orElse(null);
    }

    @Override
    public <T extends V> T getByName(String name) {
        return name == null ? null : (T) this.registryMap.values()
                .stream()
                .flatMap(m -> m.values().stream())
                .filter(v -> v.getClass().getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<V> getAll() {
        return this.registryMap.values()
                .stream()
                .flatMap(m -> m.values().stream())
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, V> getAllFor(IPluginContainer plugin) {
        return this.registryMap.computeIfAbsent(plugin, p -> Maps.newHashMap());
    }

    @Override
    public Map<IPluginContainer, Map<String, V>> getRegistryMap() {
        return ImmutableMap.copyOf(this.registryMap);
    }

}
