package com.dungeonchronicles.dungeon;

public class DungeonBuilder {
    public Dungeon buildSampleDungeon() {
        Dungeon dungeon = new Dungeon();
        Room room1 = new Room("Entrance Hall");
        Room room2 = new Room("Treasure Chamber");
        Trap trap = new Trap("Spiked Pitfall");
        dungeon.add(room1);
        dungeon.add(room2);
        dungeon.add(trap);
        return dungeon;
    }
}
