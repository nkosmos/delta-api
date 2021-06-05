package me.xtrm.delta.client.api.module;

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
	 * @return the module's display name
	 */
	String displayName() default "";
	
	/**
	 * @return the module's description
	 */
	String description();
	
	/**
	 * @return the module's default keybind
	 */
	int keybind() default 0;
	
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

}
