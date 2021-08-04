package me.xtrm.delta.api.client.file;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public interface IFileManager {

    <T> void registerHandler(Class<T> clazz, IDataHandler<T> dataHandler);

    <T> void save(T instance) throws IOException;

    <T> T load(Class<T> clazz) throws IOException;

    Set<Class<?>> getHandledTypes();

    Collection<IDataHandler<?>> getDataHandlers();

}
