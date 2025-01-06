package com.dungeonchronicles.dungeon;

public class Treasure extends DungeonComponent {
    private final String name;

    public Treasure(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Treasure: " + name);
    }
}
