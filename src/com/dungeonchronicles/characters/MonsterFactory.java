package com.dungeonchronicles.characters;

import java.util.Random;

public class MonsterFactory {

    private static Random random = new Random();

    // Create a random monster
    public static Monster createRandomMonster() {
        int type = random.nextInt(3); // Randomly select monster type: 0 -> Goblin, 1 -> Orc, 2 -> Troll
        switch (type) {
            case 0:
                return new Goblin(); // Return a Goblin instance
            case 1:
                return new Orc(); // Return an Orc instance
            case 2:
                return new Troll(); // Return a Troll instance
            default:
                return new Goblin(); // Default to Goblin if something goes wrong
        }
    }

    // Create a random boss monster
    public static Monster createRandomBoss() {
        int type = random.nextInt(2); // Randomly select boss type: 0 -> Dragon, 1 -> Demon
        switch (type) {
            case 0:
                return new Dragon(); // Return a Dragon boss instance
            case 1:
                return new Demon(); // Return a Demon boss instance
            default:
                return new Dragon(); // Default to Dragon if something goes wrong
        }
    }
}