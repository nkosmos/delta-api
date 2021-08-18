package me.xtrm.delta.api.client.features.setting;

import fr.nkosmos.starboard.Group;
import fr.nkosmos.starboard.ISetting;
import me.xtrm.delta.api.client.features.file.ISavable;
import me.xtrm.delta.api.client.features.module.IModule;
import me.xtrm.delta.api.client.registry.PluginBasedRegistry;

import java.util.List;

public interface ISettingManager extends ISavable {

    PluginBasedRegistry<Group> SETTING_GROUP_REGISTRY = new PluginBasedRegistry<>();

    List<ISetting<?>> getForGroup(Group group, boolean subgroups);

    default List<ISetting<?>> getForGroup(Group group) {
        return getForGroup(group, true);
    }

    default List<ISetting<?>> getForModule(IModule module) {
        return getForGroup(module.getRootGroup(), true);
    }

    List<ISetting<?>> getSettings();

}
