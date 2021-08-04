package me.xtrm.delta.api.client.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public @Data class Category {
    public static final Category COMBAT = new Category("Combat", '4');
    public static final Category MOVEMENT = new Category("Movement", 's');
    public static final Category PLAYER = new Category("Player", 'u');
    public static final Category RENDER = new Category("Render", 't');
    public static final Category WORLD = new Category("World", 'p');
    public static final Category MISC = new Category("Misc", 'i');
    public static final Category HIDDEN = new Category("Hidden", '?', false);

    private final String name;
    private final char iconChar;
    private boolean visible = true;
}
