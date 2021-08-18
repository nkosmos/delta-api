package me.xtrm.delta.api.client.features.module;

import fr.nkosmos.starboard.Group;
import fr.nkosmos.starboard.IGroupParent;
import me.xtrm.delta.api.client.ui.IAnimationProvider;

import java.util.Collections;
import java.util.List;

public interface IModule extends IGroupParent {

    String getId();

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

    // maybe this should be in the manager? nahhhhhhhhhh
    void toggle();

    //TODO: move this out god
    IAnimationProvider getDisplayAnimation();

    default IGroupParent getGroupParent() {
        return null;
    }

    @Override
    default List<Group> getSubgroups() {
        return Collections.singletonList(getRootGroup());
    }
}