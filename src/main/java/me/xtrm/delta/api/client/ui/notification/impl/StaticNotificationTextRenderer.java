package me.xtrm.delta.api.client.ui.notification.impl;

import lombok.RequiredArgsConstructor;
import me.xtrm.delta.api.client.ui.notification.INotificationTextRenderer;

@RequiredArgsConstructor
public class StaticNotificationTextRenderer implements INotificationTextRenderer {

    private final String title;
    private final String content;

    @Override
    public String getTitle(long renderTime) {
        return title;
    }

    @Override
    public String getContent(long renderedTime) {
        return content;
    }
}
