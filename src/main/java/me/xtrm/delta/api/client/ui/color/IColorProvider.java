package me.xtrm.delta.api.client.ui.color;

import java.awt.*;

@FunctionalInterface
public interface IColorProvider {
    Color getColor(ColorMode colorMode, Color fallbackColor);
}
