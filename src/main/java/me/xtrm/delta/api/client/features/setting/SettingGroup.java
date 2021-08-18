package me.xtrm.delta.api.client.features.setting;

import fr.nkosmos.starboard.Group;
import fr.nkosmos.starboard.IGroupParent;
import me.xtrm.delta.api.client.features.module.IModule;
import me.xtrm.delta.api.client.features.module.IModuleManager;
import me.xtrm.delta.api.plugin.IPluginContainer;

import java.util.Map;

public class SettingGroup extends Group {

    public SettingGroup(String name, IGroupParent parent) {
        this(name, parent, false);
    }

    public SettingGroup(String name, IGroupParent parent, boolean root) {
        super(name, parent, root);

        if (parent instanceof IModule) {
            Map<IPluginContainer, Map<String, IModule>> regMap = IModuleManager.MODULE_REGISTRY.getRegistryMap();
            IPluginContainer pluginContainer = regMap.keySet().stream().filter(k -> {
                Map<String, IModule> moduleMap = regMap.get(k);
                return moduleMap.containsValue(parent);
            }).findFirst().orElse(null);

            ISettingManager.SETTING_GROUP_REGISTRY.put(pluginContainer, getUniqueName(), this);
        }
    }

    private String getUniqueName() {
        StringBuilder name = new StringBuilder(this.getName());
        IGroupParent groupParent = this.getParent();
        while (groupParent.getParent() != null) {
            name.insert(0, groupParent.getName() + "/");
            groupParent = groupParent.getParent();
        }
        return name.toString();
    }
}
