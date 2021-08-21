package me.xtrm.delta.api.client.ui.hud;

import fr.nkosmos.starboard.Group;
import me.xtrm.delta.api.client.registry.BasicRegistry;
import me.xtrm.delta.api.client.registry.IRegistry;
import me.xtrm.delta.api.client.ui.context.RenderContext;
import me.xtrm.delta.api.plugin.IPlugin;

public interface IElement {

    IRegistry<IPlugin, String, Class<? extends IElement>> ELEMENT_TYPES_REGISTRY = new BasicRegistry<>();
    IRegistry<IPlugin, String, IElement> ELEMENT_REGISTRY = new BasicRegistry<>();

    String getName();

    void render(RenderContext context);

    int getWidth();

    int getHeight();

    Group getRootGroup();

}
