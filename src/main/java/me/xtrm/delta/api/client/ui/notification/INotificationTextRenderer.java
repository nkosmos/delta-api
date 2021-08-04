package me.xtrm.delta.api.client.ui.notification;

public interface INotificationTextRenderer {

    String getTitle(long renderTime);

    String getContent(long renderedTime);

}
