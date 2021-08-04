package me.xtrm.delta.api.client.module;

import me.xtrm.delta.api.exception.InvalidModuleException;

import java.util.List;

public interface IModuleManager {

    void addModule(IModule module) throws InvalidModuleException;

    List<IModule> getModules();

}
