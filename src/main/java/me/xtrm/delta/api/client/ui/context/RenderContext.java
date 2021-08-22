package me.xtrm.delta.api.client.ui.context;

import me.xtrm.delta.api.client.ui.color.IColorProvider;
import me.xtrm.delta.api.client.ui.draw.DrawingBoard;
import me.xtrm.delta.api.client.ui.font.IFontProvider;
import meteordevelopment.starscript.Starscript;

public interface RenderContext {

    Resolution getResolution();

    int getMouseX();

    int getMouseY();

    float getPartialTicks();

    DrawingBoard getDrawingBoard();

    IFontProvider getFontProvider();

    IColorProvider getColorProvider();

    Starscript getRenderStarscript();

    RenderContext translateMouse(int x, int y);

    default boolean hasMousePosition() {
        return true;
    }

}
