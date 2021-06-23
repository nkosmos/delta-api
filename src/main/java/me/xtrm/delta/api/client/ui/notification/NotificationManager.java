package me.xtrm.delta.api.client.ui.notification;

@FunctionalInterface
public interface NotificationManager {

    void queueNotification(NotificationType notificationType, String title, String contents, int time);

}
