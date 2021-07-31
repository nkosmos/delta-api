package me.xtrm.delta.api.client.setting;

import fr.nkosmos.starboard.Group;
import fr.nkosmos.starboard.Setting;

import java.util.List;

public interface ISettingManager {

    List<Group> getGroups();

    List<Setting<?>> getSettings();

    List<Setting<?>> getSettingsForModule(String moduleName);

}
