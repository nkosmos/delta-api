package me.xtrm.delta.api.client;

import fr.shyrogan.post.EventBus;
import me.xtrm.delta.api.client.command.CommandManager;
import me.xtrm.delta.api.client.module.ModuleManager;
import me.xtrm.delta.api.client.setting.SettingManager;
import me.xtrm.delta.api.client.ui.font.IFontRenderer;
import me.xtrm.delta.api.client.ui.notification.NotificationManager;
import me.xtrm.delta.api.launch.transform.TransformerManager;

public interface ClientAPI {

    EventBus getEventBus();

    TransformerManager getTweakManager();

    ModuleManager getModuleManager();

    SettingManager getSettingManager();

    CommandManager getCommandManager();

    NotificationManager getNotificationManager();

    IFontRenderer getFontRenderer(String fontId);

}
