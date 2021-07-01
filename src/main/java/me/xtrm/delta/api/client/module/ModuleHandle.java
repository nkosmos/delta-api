package me.xtrm.delta.api.client.module;

import java.util.function.Consumer;

public interface ModuleHandle {

    String getName();

    String getDisplayName();

    void setDisplayName(String displayName);

    String getDescription();

    void setDescription(String description);

    int getKeybind();

    void setKeybind(int keybind);

    String getCategory();

    boolean isEnabled();

    void setEnabled(boolean enabled);

    boolean isVisible();

    void setVisible(boolean visible);

    void toggle();

    void onEnable(Consumer<ModuleHandle> callback);

    void onToggle(Consumer<ModuleHandle> callback);

    void onDisable(Consumer<ModuleHandle> callback);

}
