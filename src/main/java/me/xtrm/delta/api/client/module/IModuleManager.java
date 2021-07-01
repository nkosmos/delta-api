package me.xtrm.delta.api.client.module;

import me.xtrm.delta.api.exception.InvalidModuleException;

import java.util.List;

public interface IModuleManager {

    List<ModuleHandle> getModules();

    void addModule(Object moduleObject) throws InvalidModuleException;

}
