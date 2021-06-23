package me.xtrm.delta.api.plugin.type;

import me.xtrm.delta.api.plugin.IPlugin;

public interface GitPlugin extends IPlugin<GitPlugin> {

    String getCurrentRev();

    String getCurrentBranch();

    String getUpstreamRevision(String branchName);

}
