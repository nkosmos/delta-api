package me.xtrm.delta.api.client.setting;

import fr.nkosmos.starboard.SettingGroup;

import java.util.List;

public interface ISettingManager extends SettingGroup.RegistrationListener {

    List<SettingGroup> getGroups();

}
