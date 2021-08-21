package me.xtrm.delta.api.client.ui.context;

public interface RenderContext {

    Resolution getResolution();

    int getMouseX();

    int getMouseY();

    float getPartialTicks();

    default boolean hasMousePosition() {
        return true;
    }

    RenderContext translateMouse(int x, int y);

}
