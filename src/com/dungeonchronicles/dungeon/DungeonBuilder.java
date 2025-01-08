package com.dungeonchronicles.dungeon;

public class DungeonBuilder {
    private Dungeon dungeon;

    public DungeonBuilder() {
        this.dungeon = new Dungeon();
    }

    public DungeonBuilder addRoom(String roomName) {
        Room room = new Room(roomName);
        dungeon.add(room);
        return this;
    }

    public DungeonBuilder addTrap(String trapName) {
        Trap trap = new Trap(trapName);
        dungeon.add(trap);
        return this;
    }

    public DungeonBuilder addTreasure(String treasureName) {
        Treasure treasure = new Treasure(treasureName);
        dungeon.add(treasure);
        return this;
    }

    public Dungeon build() {
        return this.dungeon;
    }

    public Dungeon buildSampleDungeon() {
        Room entrance = new Room("Entrance Hall");
        Room treasureChamber = new Room("Treasure Chamber");
        Room bossRoom = new Room("Boss Lair");
        Trap spikedPitfall = new Trap("Spiked Pitfall");
        Treasure goldenChest = new Treasure("Golden Chest");

        dungeon.add(entrance);
        dungeon.add(treasureChamber);
        dungeon.add(bossRoom);
        dungeon.add(spikedPitfall);
        dungeon.add(goldenChest);

        return dungeon;
    }
}

