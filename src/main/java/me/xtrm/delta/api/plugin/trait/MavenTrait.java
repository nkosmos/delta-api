package me.xtrm.delta.api.plugin.trait;

import me.xtrm.delta.api.plugin.IPlugin;
import org.apache.maven.shared.invoker.Invoker;

public interface MavenTrait extends IPlugin<MavenTrait> {

    Invoker getInvoker();

}
