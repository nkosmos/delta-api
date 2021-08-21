package me.xtrm.delta.api.client.ui.hud;

import me.xtrm.delta.api.client.ui.context.RenderContext;

public interface IElement {

    String getName();

    void render(RenderContext context);

    int getWidth();

    int getHeight();

}
