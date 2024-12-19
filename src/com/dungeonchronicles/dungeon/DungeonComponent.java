package com.dungeonchronicles.dungeon;

public abstract class DungeonComponent {
    public void add(DungeonComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(DungeonComponent component) {
        throw new UnsupportedOperationException();
    }

    public abstract void display();
}