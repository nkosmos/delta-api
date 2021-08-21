package me.xtrm.delta.api.client.ui.hud.impl;

import lombok.Getter;
import lombok.Setter;
import me.xtrm.delta.api.client.ui.context.RenderContext;
import me.xtrm.delta.api.client.ui.font.IFontRenderer;
import me.xtrm.delta.api.client.ui.hud.IMovableElement;

import java.awt.*;

@Getter
@Setter
public class TextElement implements IMovableElement {

    private String text;
    private int x;
    private int y;
    private IFontRenderer fontRenderer;
    private boolean shadow;
    private Color color;

    @Override
    public String getName() {
        return "Text Element" + (text != null ? " (" + text + ")" : "");
    }

    @Override
    public void render(RenderContext context) {
        fontRenderer.drawString(text, x, y, color.getRGB(), shadow);
    }

    @Override
    public int getWidth() {
        return fontRenderer.getStringWidth(text);
    }

    @Override
    public int getHeight() {
        return fontRenderer.getFontHeight();
    }
}