package me.xtrm.delta.api.client.ui.color;

import fr.nkosmos.starboard.api.ISettingEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ColorMode implements ISettingEnum {
    CUSTOM("Custom", true),
    CATEGORY("Category", false),
    RAINBOW("Rainbow", false),
    RAINBOW_WAVE("RainbowWave", false),
    VIBRANT("Vibrant", true);

    private final String name;
    private final boolean customizable;
}
