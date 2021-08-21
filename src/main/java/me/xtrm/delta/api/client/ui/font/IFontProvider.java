package me.xtrm.delta.api.client.ui.font;

@FunctionalInterface
public interface IFontProvider {
    IFontRenderer getFontRenderer(EnumFont font);
}
