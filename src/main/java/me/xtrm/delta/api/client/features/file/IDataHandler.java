package me.xtrm.delta.api.client.features.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;

public interface IDataHandler<T> {

    Gson GSON = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    String getFileName();

    T loadFrom(File file) throws IOException;

    void saveTo(T instance, File file) throws IOException;

}