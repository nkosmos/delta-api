package me.xtrm.delta.client.api.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for the module categories
 * @author xTrM_
 */
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public enum Category { 
	
	COMBAT("Combat", '4'),
	MOVEMENT("Movement", 's'),
	PLAYER("Player", 'u'),
	RENDER("Render", 't'),
	WORLD("World", 'p'),
	MISC("Misc", 'i'),
	HIDDEN("Hidden", '?', false);
	
	/** The name */
	private final String name;
	/** The character representing the category's icon with the icon font type (Undefeated) */
	private final char iconChar;
	/** Is this category visible in the ClickGUI */
	private boolean visible = true;
	
}