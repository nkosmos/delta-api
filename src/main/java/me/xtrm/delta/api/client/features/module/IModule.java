package me.xtrm.delta.api.client.features.module;

import fr.nkosmos.starboard.api.IGroup;
import me.xtrm.delta.api.client.ui.animation.IAnimationContainer;

public interface IModule {

    String getId();

    String getName();

    String getDisplayName();

    String getDescription();

    int getKey();

    Category getCategory();

    boolean isEnabled();

    boolean isVisible();

    IGroup getRootGroup();

    void setDisplayName(String displayName);

    void setDescription(String description);

    void setKey(int key);

    void setEnabled(boolean state);

    void setVisible(boolean visible);

    // maybe this should be in the manager? nahhhhhhhhhh
    void toggle();

    //TODO: move this out god
    IAnimationContainer getDisplayAnimation();
}