package me.xtrm.delta.api.client.ui.font;

import fr.nkosmos.starboard.api.ISettingEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnumFont implements ISettingEnum {
    MINECRAFT("Minecraft", "minecraft"),
    NORMAL("Normal", "default"),
    SMALL("Small", "smol"),
    BIG("Big", "bigger"),
    WATERMARK("Watermark", "watermark"),
    ICON("Icon", "icon")
    //OOBE("OOBE", "oobe")
    ;

    private final String name;
    private final String id;
}
