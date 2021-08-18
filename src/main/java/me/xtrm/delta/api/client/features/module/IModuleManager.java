package me.xtrm.delta.api.client.features.module;

import me.xtrm.delta.api.client.features.file.ISavable;
import me.xtrm.delta.api.client.registry.PluginBasedRegistry;

import java.util.List;
import java.util.stream.Collectors;

public interface IModuleManager extends ISavable {

    PluginBasedRegistry<IModule> MODULE_REGISTRY = new PluginBasedRegistry<IModule>() {
        @Override
        public <V extends IModule> V getByName(String name) {
            return name == null ? null : (V) this.registryMap.values()
                    .stream()
                    .flatMap(m -> m.values().stream())
                    .filter(v -> v.getId().equalsIgnoreCase(name)) // compare via id
                    .findFirst()
                    .orElse(null);
        }
    };

    void add(IModule module);

    default <V extends IModule> V getByClass(Class<V> moduleClass) {
        return (V) this.getAsList().stream().filter(m -> m.getClass() == moduleClass).findFirst().orElse(null);
    }

    default <V extends IModule> V getById(String id) {
        return (V) this.getAsList().stream().filter(m -> m.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    default List<IModule> getInCategory(Category category) {
        return this.getAsList().stream().filter(m -> m.getCategory() == category).collect(Collectors.toList());
    }

    List<? extends IModule> getAsList();

}
