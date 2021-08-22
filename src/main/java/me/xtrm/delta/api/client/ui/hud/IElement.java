package me.xtrm.delta.api.client.ui.hud;

import fr.nkosmos.starboard.Group;
import me.xtrm.delta.api.client.registry.NamedPluginBasedRegistry;
import me.xtrm.delta.api.client.ui.context.RenderContext;

public interface IElement {

    NamedPluginBasedRegistry<Class<? extends IElement>> ELEMENT_TYPES_REGISTRY = new NamedPluginBasedRegistry<>();

    String getName();

    void render(RenderContext context);

    default void renderDummy(RenderContext context) {
        render(context);
    }

    int getWidth();

    int getHeight();

    Group getRootGroup();

}
