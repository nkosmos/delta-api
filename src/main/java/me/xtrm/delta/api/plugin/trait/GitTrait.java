package me.xtrm.delta.api.plugin.trait;

public interface GitTrait {

    String getCurrentRev();

    String getCurrentBranch();

    String getUpstreamRevision(String branchName);

}
