package com.dungeonchronicles.dungeon;

import java.util.Random;

public class DungeonBuilder {
    private final Dungeon dungeon = new Dungeon();
    private static final Random random = new Random();

    public DungeonBuilder addRoom(String name) {
        if (random.nextInt(10) > 7) {
            // Chance to add a monster room or treasure
            if (random.nextBoolean()) {
                dungeon.addRoom(new MonsterRoom(name));
            } else {
                dungeon.addRoom(new Treasure(name));
            }
        } else {
            // Empty room or trap
            dungeon.addRoom((DungeonComponent) new Room());
        }
        return this;
    }

    public Dungeon build() {
        return dungeon;
    }
}
