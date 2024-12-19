package com.dungeonchronicles.game;

import com.dungeonchronicles.states.*;
import com.dungeonchronicles.dungeon.DungeonBuilder;
import com.dungeonchronicles.dungeon.Dungeon;
import com.dungeonchronicles.inventory.Inventory;

public class Game {
    public static void main(String[] args) {
        GameStateManager manager = new GameStateManager();
        DungeonBuilder builder = new DungeonBuilder();
        Inventory inventory = new Inventory();

        Dungeon dungeon = builder.buildSampleDungeon();
        manager.changeState(new MainMenuState());

        boolean isRunning = true;
        while (isRunning) {
            manager.executeState();

            // Example transitions (replace with real input logic):
            manager.changeState(new ExplorationState());
            dungeon.display();
            inventory.addItem("Golden Sword");
            manager.changeState(new CombatState());
            inventory.displayInventory();
            manager.changeState(new GameOverState());
            isRunning = false;
        }
    }
}
