package com.dungeonchronicles.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Dungeon extends DungeonComponent {
    private final List<DungeonComponent> components = new ArrayList<>();

    @Override
    public void add(DungeonComponent component) {
        components.add(component);
    }

    @Override
    public void remove(DungeonComponent component) {
        components.remove(component);
    }

    @Override
    public void display() {
        for (DungeonComponent component : components) {
            component.display();
        }
    }
}