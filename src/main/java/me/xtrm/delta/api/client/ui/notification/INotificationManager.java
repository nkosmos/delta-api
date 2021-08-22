package me.xtrm.delta.api.client.ui.notification;

import me.xtrm.delta.api.client.ui.notification.defaults.StaticNotificationTextRenderer;

@FunctionalInterface
public interface INotificationManager {

    /**
     * Queues a notification to be displayed.
     *
     * @param notificationType the {@link NotificationType}
     * @param title            the notification's title
     * @param contents         the displayed content
     * @param time             the time that this notification will be shown
     */
    default void queueNotification(NotificationType notificationType, String title, String contents, int time) {
        queueNotification(notificationType, new StaticNotificationTextRenderer(title, contents), time);
    }

    void queueNotification(NotificationType notificationType, INotificationTextRenderer notificationTextRenderer, int time);


}
