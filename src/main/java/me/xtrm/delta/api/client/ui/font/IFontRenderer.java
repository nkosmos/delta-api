package me.xtrm.delta.api.client.ui.font;

public interface IFontRenderer {

    default String getRendererName() {
        return "Vanilla";
    }

    int getFontHeight();

    int getStringWidth(String text);

    void drawString(String text, double x, double y, int color);

    void drawStringWithShadow(String text, double x, double y, int color);

}
