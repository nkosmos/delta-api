package me.xtrm.delta.api.client.setting;

import fr.nkosmos.starboard.Setting;
import fr.nkosmos.starboard.SettingGroup;

import java.util.List;

public interface ISettingManager extends SettingGroup.RegistrationListener {

    List<SettingGroup> getGroups();

    List<Setting<?>> getSettings();

    List<Setting<?>> getSettingsForModule(String moduleName);

}
