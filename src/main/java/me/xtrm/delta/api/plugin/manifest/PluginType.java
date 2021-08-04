package me.xtrm.delta.api.plugin.manifest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PluginType {
    NODE("Node", true),
    GRADLE("Gradle", true),
    MAVEN("Maven", true),

    JAR("JAR", false),
    ECMA("ECMA", false),
    ;

    private final String name;
    private final boolean compilable;

}
