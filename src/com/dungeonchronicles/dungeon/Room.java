package com.dungeonchronicles.dungeon;

public class Room implements DungeonComponent {
    private final String name;

    public Room(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Room: " + name);
    }
}
