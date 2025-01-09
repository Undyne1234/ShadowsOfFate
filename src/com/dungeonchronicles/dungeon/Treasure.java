package com.dungeonchronicles.dungeon;

public class Treasure implements DungeonComponent {
    private final String name;

    public Treasure(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Treasure: " + name);
    }
}
