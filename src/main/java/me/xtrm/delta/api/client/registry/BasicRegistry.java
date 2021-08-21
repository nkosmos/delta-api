package me.xtrm.delta.api.client.registry;

import me.xtrm.delta.api.plugin.IPluginContainer;
import org.gradle.internal.impldep.com.google.common.collect.ImmutableMap;
import org.gradle.internal.impldep.com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * {@link IRegistry} implementation based on {@link IPluginContainer}s.
 *
 * @param <O> the registry owner key
 * @param <K> the registry key
 * @param <V> the registry item
 */
public class BasicRegistry<O, K, V> implements IRegistry<O, K, V> {
    protected final Map<O, Map<K, V>> registryMap = Maps.newHashMap();

    @Override
    public void put(O plugin, K key, V value) {
        Map<K, V> registryMapping = registryMap.computeIfAbsent(plugin, p -> Maps.newHashMap());

        if (registryMapping.containsKey(key)) {
            throw new IllegalArgumentException(String.format("Key %s already exists in registry!", key));
        }

        registryMapping.put(key, value);
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
    public Map<K, V> getAllFor(O plugin) {
        return this.registryMap.computeIfAbsent(plugin, p -> Maps.newHashMap());
    }

    @Override
    public Map<O, Map<K, V>> getRegistryMap() {
        return ImmutableMap.copyOf(this.registryMap);
    }
}
