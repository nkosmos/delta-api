package me.xtrm.delta.api.client.module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declarative interface referencing different module informations
 *
 * @author xTrM_
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Module {

    /**
     * @return the module's name
     */
    String name();

    /**
     * @return the module's description
     */
    String description();

    /**
     * @return the module's default keybind
     */
    int keyCode() default 0;

    /**
     * @return the module's category
     */
    String category();

    /**
     * @return the module's default enabled state
     */
    boolean defaultState() default false;

    /**
     * @return the module's visibility state
     */
    boolean visible() default true;

    /**
     * Annotation declaring the handle
     * reference for that module.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Handle {
        String moduleName() default "__self";
    }

    /**
     * Annotation declaring the callback method to be run
     * after the module has been enabled
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface OnEnable {

    }

    /**
     * Annotation declaring the callback method to be run
     * after the module has been disabled
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface OnDisable {

    }

    /**
     * Annotation declaring the callback method to be run
     * after the module has been toggled
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface OnToggle {

    }
}
