package me.xtrm.delta.api.client.features.file;

import java.io.IOException;

@FunctionalInterface
public interface ISavable {
    void save() throws IOException;
}
