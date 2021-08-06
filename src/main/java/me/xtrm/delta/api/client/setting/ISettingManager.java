package me.xtrm.delta.api.client.setting;

import fr.nkosmos.starboard.Group;
import fr.nkosmos.starboard.Setting;
import me.xtrm.delta.api.client.file.ISavable;
import me.xtrm.delta.api.client.module.IModule;

import java.util.List;

public interface ISettingManager extends ISavable {

    List<Group> getGroups();

    List<Setting<?>> getForModule(String moduleName);

    List<Setting<?>> getForModule(Class<? extends IModule> moduleClass);

    List<Setting<?>> getForGroup(Group group, boolean subgroups);

    default List<Setting<?>> getForGroup(Group group) {
        return getForGroup(group, true);
    }

    List<Setting<?>> getSettings();

}
