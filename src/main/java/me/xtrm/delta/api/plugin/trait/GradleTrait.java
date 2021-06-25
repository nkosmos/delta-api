package me.xtrm.delta.api.plugin.trait;

import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.model.GradleProject;
import org.gradle.util.GradleVersion;

public interface GradleTrait {

    GradleConnector getGradleConnector();

    GradleVersion getGradleVersion();

    GradleProject getGradleProject();

}
