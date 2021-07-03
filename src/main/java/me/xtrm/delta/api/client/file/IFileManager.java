package me.xtrm.delta.api.client.file;

import java.io.IOException;
import java.util.List;

public interface IFileManager {

    List<DataFile> getDataFiles();

    void registerDataFile(DataFile dataFile);

    void saveFiles() throws IOException;

    void loadFiles() throws IOException;

}
