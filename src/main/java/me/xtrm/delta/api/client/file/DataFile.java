package me.xtrm.delta.api.client.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;

public interface DataFile {

    Gson GSON = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    String getFileName();

    void load(File file) throws IOException;

    void save(File file) throws IOException;

}