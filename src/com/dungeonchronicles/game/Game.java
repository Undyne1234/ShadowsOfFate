package com.dungeonchronicles.game;

import com.dungeonchronicles.ui.UserInteraction;
import com.dungeonchronicles.states.*;
import com.dungeonchronicles.dungeon.DungeonBuilder;
import com.dungeonchronicles.dungeon.Dungeon;
import com.dungeonchronicles.inventory.Inventory;

public class Game {
    public static void main(String[] args) {
        GameStateManager manager = new GameStateManager();
        DungeonBuilder builder = new DungeonBuilder();
        Inventory inventory = new Inventory();
        UserInteraction userInteraction = new UserInteraction();

        Dungeon dungeon = builder.buildSampleDungeon();
        manager.changeState(new MainMenuState());

        boolean isRunning = true;
        while (isRunning) {
            manager.executeState();
            userInteraction.displayMessage("What would you like to do next?");

            // Example of user input handling:
            String action = userInteraction.getInput("Choose an action: Explore (E), Fight (F), Quit (Q)");

            switch (action.toUpperCase()) {
                case "E":
                    manager.changeState(new ExplorationState());
                    dungeon.display();
                    break;
                case "F":
                    manager.changeState(new CombatState());
                    inventory.addItem("Golden Sword");
                    inventory.displayInventory();
                    break;
                case "Q":
                    manager.changeState(new GameOverState());
                    isRunning = false;
                    break;
                default:
                    userInteraction.displayMessage("Invalid choice, try again.");
            }
        }
    }
}