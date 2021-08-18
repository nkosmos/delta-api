package me.xtrm.delta.api.plugin;

import fr.nkosmos.starboard.special.Range;
import me.xtrm.delta.api.plugin.manifest.PluginManifest;
import me.xtrm.mcversioning.SementicVersion;

import java.io.File;

public interface IPluginContainer {

    String getId();

    String getName();

    String getVersion();

    File getSource();

    PluginManifest getManifest();

    void setEnabled(boolean state);

    boolean isEnabled();

    IPlugin getPlugin();

    IPluginLoader getLoader();

    // TODO: better range support + toolchain + platform
    Range<SementicVersion> getSupportRange();

}
