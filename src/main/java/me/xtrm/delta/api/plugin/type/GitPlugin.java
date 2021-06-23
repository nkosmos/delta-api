package me.xtrm.delta.api.plugin.type;

import me.xtrm.delta.api.plugin.Plugin;

public interface GitPlugin extends Plugin<GitPlugin> {

    String getCurrentRev();

    String getCurrentBranch();

    String getUpstreamRevision(String branchName);

}
