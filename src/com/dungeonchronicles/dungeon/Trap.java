package com.dungeonchronicles.dungeon;

public class Trap extends DungeonComponent {
    private final String description;

    public Trap(String description) {
        this.description = description;
    }

    @Override
    public void display() {
        System.out.println("Trap: " + description);
    }
}