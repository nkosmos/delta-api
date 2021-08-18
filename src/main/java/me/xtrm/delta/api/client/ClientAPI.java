package me.xtrm.delta.api.client;

import fr.shyrogan.post.EventBus;
import me.xtrm.delta.api.client.features.file.IFileManager;
import me.xtrm.delta.api.client.features.friend.IFriendManager;
import me.xtrm.delta.api.client.features.module.IModuleManager;
import me.xtrm.delta.api.client.features.setting.ISettingManager;
import me.xtrm.delta.api.client.ui.font.IFontRenderer;
import me.xtrm.delta.api.client.ui.notification.INotificationManager;

public interface ClientAPI {

    /**
     * @return an {@link EventBus} instance
     */
    EventBus getEventBus();

    IFileManager getFileManager();

    IModuleManager getModuleManager();

    ISettingManager getSettingManager();

    INotificationManager getNotificationManager();

    IFriendManager getFriendManager();

    IFontRenderer getFontRenderer(String fontId);

}
