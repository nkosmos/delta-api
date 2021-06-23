package me.xtrm.delta.api.client.ui.font;

public interface IFontRenderer {

    String getRendererName();

    int getFontHeight();

    int getStringWidth(String text);

    void drawString(String text, int x, int y, int color);

    void drawStringWithShadow(String text, int x, int y, int color);

}
