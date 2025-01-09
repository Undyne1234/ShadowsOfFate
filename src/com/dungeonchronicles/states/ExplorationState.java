package com.dungeonchronicles.states;

import com.dungeonchronicles.characters.MonsterFactory;
import com.dungeonchronicles.dungeon.Room;
import com.dungeonchronicles.ui.UserInteraction;
import com.dungeonchronicles.characters.Character;

import java.util.Random;

public class ExplorationState implements GameState {
    private UserInteraction userInteraction = new UserInteraction();
    private Character player;
    private MonsterFactory monsterFactory = new MonsterFactory();
    private int roomsExplored = 0;
    private Room currentRoom;

    public ExplorationState(Character player) {
        this.player = player;
    }

    @Override
    public void enterState() {
        userInteraction.displayMessage("Entering Exploration Mode...");
    }

    @Override
    public void execute() {
        boolean isBossRoomEncountered = false; // Track if the player encountered the boss room.

        while (!isBossRoomEncountered && player.getHealth() > 0) {
            // Generate a random room each time
            Room currentRoom = new Room();

            // Display room type
            if (currentRoom.isMonsterRoom()) {
                userInteraction.displayMessage("A monster appears! Get ready for combat!");
                // Start Combat
                GameState combatState = new CombatState(player, monsterFactory.createRandomMonster()); // Replace with actual Monster class
                GameStateManager manager = new GameStateManager();
                manager.changeState(combatState);
                manager.executeState();
            } else if (currentRoom.containsHealingFountain()) {
                userInteraction.displayMessage("You found a healing fountain! Your health is restored.");
                player.setHealth(player.getHealth() + 50);  // Healing amount, can be customized.
                // Continue exploring
                nextRoom();
            } else if (currentRoom.isEmpty()) {
                userInteraction.displayMessage("This room is empty. Continue exploring.");
                nextRoom();
            }

            // Check if the boss room is reached (you can modify this as per your game logic)
            if (isBossRoom()) {
                isBossRoomEncountered = true;
                userInteraction.displayMessage("You have reached the Boss Room! Get ready for the final battle.");
                // Start combat with Boss
                GameState bossCombatState = new CombatState(player, monsterFactory.createRandomBoss()); // Replace with your Boss class
                GameStateManager manager = new GameStateManager();
                manager.changeState(bossCombatState);
                manager.executeState();
            }
        }

        // After boss is defeated or player is defeated, transition out of ExplorationState
        if (player.getHealth() <= 0) {
            GameStateManager manager = new GameStateManager();
            manager.changeState(new GameOverState());
            manager.executeState();
        } else {
            // Player defeated the boss
            userInteraction.displayMessage("Congratulations, you've defeated the boss and won the game!");
            // Transition to GameOverState or another victory state.
            GameStateManager manager = new GameStateManager();
            manager.changeState(new GameOverState());
            manager.executeState();
        }
    }

    private void nextRoom() {
        roomsExplored++;
        // Logic to proceed to the next room (could be random or structured)
        userInteraction.displayMessage("Proceeding to the next room...");
        userInteraction.getInput("Press Enter to continue...");
    }

    private boolean isBossRoom() {
        // Increase the likelihood of the Boss Room appearing after a few rooms
        if (roomsExplored <= 5) {
            return false;
        } else if (roomsExplored <= 10) {
            return new Random().nextInt(5) == 0;
        } else if (roomsExplored <= 15) {
            return new Random().nextInt(3) == 0;
        } else if (roomsExplored <= 20) {
            return new Random().nextInt(2) == 0;
        } else {
            return new Random().nextInt(2) == 0;
        }
    }

    private Room generateRandomRoom() {
        // Here, you can implement your logic to create random rooms
        // For simplicity, we will return a new random Room each time
        return new Room();
    }

    @Override
    public void exitState() {
        userInteraction.displayMessage("Exiting Exploration Mode...");
    }
}
