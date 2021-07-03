package me.xtrm.delta.api.client.ui.notification;

@FunctionalInterface
public interface INotificationManager {

    void queueNotification(NotificationType notificationType, String title, String contents, int time);

}
