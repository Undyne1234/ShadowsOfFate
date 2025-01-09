package com.dungeonchronicles.states;

import com.dungeonchronicles.ui.UserInteraction;
import com.dungeonchronicles.game.Game;
import com.dungeonchronicles.characters.Character;
import com.dungeonchronicles.characters.Monster;  // Make sure you import the Monster class
import com.dungeonchronicles.characters.MonsterFactory;  // You will need a factory to create random monsters
import com.dungeonchronicles.inventory.Weapon;  // Import Weapon class if needed for combat

import java.util.Random;

public class ExplorationState implements GameState {
    private UserInteraction userInteraction = new UserInteraction();
    private Random random = new Random();
    private Character player;

    @Override
    public void enterState() {
        userInteraction.displayMessage("Entering Dungeon...");
        player = Game.getPlayer();  // Get the current player
    }

    @Override
    public void execute() {
        userInteraction.displayMessage("You are exploring the dungeon...");
        userInteraction.displayMessage("Current HP: " + player.getHealth());

        // Randomly determine whether the room contains a monster or not
        if (random.nextInt(5) < 3) {  // 60% chance to encounter a monster
            Monster monster = MonsterFactory.createRandomMonster();  // Factory creates a random monster
            userInteraction.displayMessage("A wild " + monster.getName() + " appears!");

            // Start combat with the monster
            CombatState combatState = new CombatState(player, monster);
            GameStateManager manager = new GameStateManager();
            manager.changeState(combatState);
            manager.executeState();
        } else {
            userInteraction.displayMessage("The room is empty. You continue exploring.");
        }

        // After some rooms, you may encounter a boss
        if (random.nextInt(10) < 1) {  // 10% chance to encounter a boss room
            userInteraction.displayMessage("You have found a Boss Room!");
            // Create and trigger a boss battle
            Monster boss = MonsterFactory.createRandomBoss();  // Factory creates a boss monster
            CombatState bossCombatState = new CombatState(player, boss);
            GameStateManager manager = new GameStateManager();
            manager.changeState(bossCombatState);
            manager.executeState();
        }

        // Optionally allow the player to move to the next room, or exit
        String choice = userInteraction.getInput("1. Move to next room\n2. Exit Dungeon");
        switch (choice) {
            case "1":
                execute();  // Continue exploring
                break;
            case "2":
                userInteraction.displayMessage("Exiting dungeon...");
                System.exit(0);  // End the game, or switch to a different state
                break;
            default:
                userInteraction.displayMessage("Invalid choice, try again.");
                execute();
                break;
        }
    }

    @Override
    public void exitState() {
        userInteraction.displayMessage("Exiting Dungeon...");
    }
}
