package me.xtrm.delta.api.client.ui.hud;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.xtrm.delta.api.client.ui.context.Resolution;
import me.xtrm.delta.api.client.ui.context.RenderContext;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Alignment {
    TOP_RIGHT("Top Right", 1, 1),
    TOP_LEFT("Top Left", -1, 1),
    BOTTOM_RIGHT("Bottom Right", 1, -1),
    BOTTOM_LEFT("Bottom Left", -1, -1);

    private final String name;
    private final int xOffset;
    private final int yOffset;

    public static Alignment fromPosition(RenderContext context, int x, int y) {
        Resolution scaledResolution = context.getResolution();
        int width = scaledResolution.getWidth();
        int height = scaledResolution.getHeight();

        int xOffset = (x < (width / 2)) ? -1 : 1; // left / right
        int yOffset = (y > (height / 2)) ? -1 : 1; // bottom / top

        return Arrays.stream(values()).filter(a -> a.xOffset == xOffset && a.yOffset == yOffset).findFirst().orElse(TOP_LEFT);
    }
}
