package me.xtrm.delta.api.client.registry;

import java.util.List;
import java.util.Map;

public interface IRegistry<O, K, V> {

    void put(O owner, K key, V value);

    <T extends V> T getByClass(Class<? extends T> clazz);

    <T extends V> T getByName(String name);

    Map<K, V> getAllFor(O owner);

    List<V> getAll();

    Map<O, Map<K, V>> getRegistryMap();

}
