package me.xtrm.delta.api.client.module;

import me.xtrm.delta.api.client.file.ISavable;
import me.xtrm.delta.api.exception.InvalidModuleException;

import java.util.List;
import java.util.stream.Collectors;

public interface IModuleManager extends ISavable {

    void addModule(IModule module) throws InvalidModuleException;

    @SuppressWarnings("unchecked") default <T extends IModule> T getByName(String moduleName) {
        return (T) this.getModules().stream().filter(m -> m.getName().equalsIgnoreCase(moduleName)).findFirst().orElse(null);
    }

    @SuppressWarnings("unchecked") default <T extends IModule> T getByClass(Class<T> moduleClass) {
        return (T) this.getModules().stream().filter(m -> m.getClass() == moduleClass).findFirst().orElse(null);
    }

    default List<IModule> getInCategory(Category category) {
        return this.getModules().stream().filter(m -> m.getCategory() == category).collect(Collectors.toList());
    }

    List<IModule> getModules();

}
