package me.xtrm.delta.api.client.features.setting;

import fr.nkosmos.starboard.api.IGroup;
import fr.nkosmos.starboard.api.ISetting;
import lombok.Data;
import me.xtrm.delta.api.client.features.file.ISavable;
import me.xtrm.delta.api.client.features.module.IModule;
import me.xtrm.delta.api.client.registry.PluginBasedRegistry;

import java.util.List;
import java.util.stream.Collectors;

public interface ISettingManager extends ISavable {

    PluginBasedRegistry<IModule, IGroup> ROOT_GROUPS_REGISTRY = new PluginBasedRegistry<>();

    List<ISetting<?>> getForGroup(IGroup group, boolean subgroups);

    default List<ISetting<?>> getForGroup(IGroup group) {
        return getForGroup(group, true);
    }

    default List<ISetting<?>> getForModule(IModule module) {
        return getForGroup(module.getRootGroup(), true);
    }

    List<ISetting<?>> getSettings();

    @Data
    class GroupGlobalData {
        private final List<ISettingManager.GroupGlobalData.GroupData> moduleDataList;

        @Data
        static class GroupData {
            static ISettingManager.GroupGlobalData.GroupData fromModule(ISetting setting) {
                return new ISettingManager.GroupGlobalData.GroupData();
            }
        }

        public static ISettingManager.GroupGlobalData generate(ISettingManager moduleManager) {
            return new ISettingManager.GroupGlobalData(
                    moduleManager.getSettings()
                            .stream()
                            .map(ISettingManager.GroupGlobalData.GroupData::fromModule)
                            .collect(Collectors.toList())
            );
        }
    }

}
