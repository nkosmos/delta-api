package me.xtrm.delta.api.plugin;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Permission {

    TWEAKING("Tweaking"),

    FILESYSTEM("Filesystem"),
    NETWORKING("Networking"),
    REFLECTION("Reflection"),

    NSFW("NSFW");

    private final String permissionName;

}
