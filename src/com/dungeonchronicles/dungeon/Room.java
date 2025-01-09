package com.dungeonchronicles.dungeon;

import java.util.Random;

public class Room {
    private boolean isMonsterRoom;
    private boolean containsHealingFountain;
    private boolean isEmpty;

    public Room() {
        // Randomly determine what kind of room this is
        Random rand = new Random();

        // 30% chance to be a monster room
        this.isMonsterRoom = rand.nextInt(10) < 3;

        // 30% chance to contain a healing fountain (if not a monster room)
        this.containsHealingFountain = !isMonsterRoom && rand.nextInt(10) < 3;

        // If it isn't a monster room or a fountain, it is empty
        this.isEmpty = !isMonsterRoom && !containsHealingFountain;
    }

    public boolean isMonsterRoom() {
        return isMonsterRoom;
    }

    public boolean containsHealingFountain() {
        return containsHealingFountain;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
