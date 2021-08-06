package me.xtrm.delta.api.client.file;

public interface ISavable {
    void save();

    boolean isSaveEnabled();

    void setSaving(boolean shouldSave);
}
