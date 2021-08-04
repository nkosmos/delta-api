package me.xtrm.delta.api.client.module;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public @Data
class Category {

    private static List<Category> REGISTRY = new ArrayList<>();

    public static final Category COMBAT = new Category("Combat", '4');
    public static final Category MOVEMENT = new Category("Movement", 's');
    public static final Category PLAYER = new Category("Player", 'u');
    public static final Category RENDER = new Category("Render", 't');
    public static final Category WORLD = new Category("World", 'p');
    public static final Category MISC = new Category("Misc", 'i');
    public static final Category HIDDEN = new Category("Hidden", '?', false);

    private final String name;
    private final char iconChar;
    private boolean visible;

    public Category(String name, char iconChar, boolean visible) {
        this.name = name;
        this.iconChar = iconChar;
        this.visible = visible;

        if (REGISTRY.stream().anyMatch(c -> c.name.equalsIgnoreCase(name))) {
            throw new RuntimeException("Cannot add already existing Category named: " + name);
        }

        REGISTRY.add(this);
    }

    public Category(String name, char iconChar) {
        this(name, iconChar, true);
    }

    public static Category fromName(String name) {
        return REGISTRY.stream().filter(category -> category.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
