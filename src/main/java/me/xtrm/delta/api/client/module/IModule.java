package me.xtrm.delta.api.client.module;

import fr.nkosmos.starboard.Group;

public interface IModule {

    String getName();

    String getDisplayName();

    String getDescription();

    int getKey();

    Category getCategory();

    boolean isEnabled();

    boolean isVisible();

    Group getRootGroup();

    void setDisplayName(String displayName);

    void setDescription(String description);

    void setKey(int key);

    void setEnabled(boolean state);

    void setVisible(boolean visible);

    void toggle();
}