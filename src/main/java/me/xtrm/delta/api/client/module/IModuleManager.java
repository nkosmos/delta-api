package me.xtrm.delta.api.client.module;

import me.xtrm.delta.api.exception.InvalidModuleException;

import java.util.List;
import java.util.stream.Collectors;

public interface IModuleManager {

    void addModule(IModule module) throws InvalidModuleException;

    default IModule getByName(String moduleName) {
        return this.getModules().stream().filter(m -> m.getName().equalsIgnoreCase(moduleName)).findFirst().orElse(null);
    }

    default IModule getByClass(Class<? extends IModule> moduleClass) {
        return this.getModules().stream().filter(m -> m.getClass() == moduleClass).findFirst().orElse(null);
    }

    default List<IModule> getInCategory(Category category) {
        return this.getModules().stream().filter(m -> m.getCategory() == category).collect(Collectors.toList());
    }

    List<? extends IModule> getModules();

}
