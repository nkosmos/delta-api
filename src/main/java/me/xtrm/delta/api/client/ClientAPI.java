package me.xtrm.delta.api.client;

import fr.shyrogan.post.EventBus;
import me.xtrm.delta.api.client.command.CommandManager;
import me.xtrm.delta.api.client.file.IFileManager;
import me.xtrm.delta.api.client.friend.IFriendManager;
import me.xtrm.delta.api.client.module.IModuleManager;
import me.xtrm.delta.api.client.setting.ISettingManager;
import me.xtrm.delta.api.client.ui.font.IFontRenderer;
import me.xtrm.delta.api.client.ui.notification.INotificationManager;

public interface ClientAPI {

    EventBus getEventBus();

    IFileManager getFileManager();

    IModuleManager getModuleManager();

    ISettingManager getSettingManager();

    CommandManager getCommandManager();

    INotificationManager getNotificationManager();

    IFriendManager getFriendManager();

    IFontRenderer getFontRenderer(String fontId);

}
