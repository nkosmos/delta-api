package me.xtrm.delta.api.plugin.manifest;

import com.google.gson.Gson;
import lombok.Data;
import lombok.SneakyThrows;
import me.xtrm.delta.api.plugin.Permission;

import java.io.File;
import java.io.FileReader;

public @Data
class PluginManifest {

    public static final transient String MANIFEST_FILENAME = ".kosmos.json";
    public static final transient int MANIFEST_VERSION = 1;

    private final int manifestVersion;

    private final String name;
    private final String id;
    private final String version;
    private final String author;

    private final String repo;
    private final String license;

    private final String iconFile;

    private final Permission[] permissions;

    private final PluginType type;
    private final String main;

    @SneakyThrows
    public static PluginManifest parseFrom(File file) {
        return new Gson().fromJson(new FileReader(file), PluginManifest.class);
    }

}