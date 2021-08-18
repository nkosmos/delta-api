package me.xtrm.delta.api.client.features.module;

import lombok.Data;
import me.xtrm.delta.api.client.features.file.ISavable;
import me.xtrm.delta.api.client.registry.NamedPluginBasedRegistry;

import java.util.List;
import java.util.stream.Collectors;

public interface IModuleManager extends ISavable {

    NamedPluginBasedRegistry<IModule> MODULE_REGISTRY = new NamedPluginBasedRegistry<IModule>() {
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

    List<IModule> getAsList();

    @Data
    class ModuleGlobalData {
        private final List<ModuleData> moduleDataList;

        @Data
        static class ModuleData {
            private final String moduleId;
            private final int keybind;
            private final boolean state;

            static ModuleData fromModule(IModule module) {
                return new ModuleData(module.getId(), module.getKey(), module.isEnabled());
            }
        }

        public static ModuleGlobalData generate(IModuleManager moduleManager) {
            return new ModuleGlobalData(
                    moduleManager.getAsList()
                            .stream()
                            .map(ModuleData::fromModule)
                            .collect(Collectors.toList())
            );
        }
    }

}
