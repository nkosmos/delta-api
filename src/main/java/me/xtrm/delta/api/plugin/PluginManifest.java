package me.xtrm.delta.api.plugin;

import lombok.Data;

public @Data class PluginManifest {

    private final String name;
    private final String id;
    private final String version;
    private final String author;

    private final String sourceUrl;

    private final String iconFile;

    private final String pluginMainFile;
    private final Permission[] permissions;

}