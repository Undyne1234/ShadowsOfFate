package com.dungeonchronicles.game;

import com.dungeonchronicles.states.GameState;
import com.dungeonchronicles.states.MainMenuState;
import com.dungeonchronicles.states.GameStateManager;
import com.dungeonchronicles.characters.Character;
public class Game {
    private static Character player;  // Static variable to hold the selected player

    public static void main(String[] args) {
        GameStateManager manager = new GameStateManager();
        GameState mainMenuState = new MainMenuState();

        // Change to main menu state and start the game
        manager.changeState(mainMenuState);
        manager.executeState();
    }

    // Method to start the game with the selected player
    public static void startGame(Character selectedPlayer) {
        player = selectedPlayer;
    }

    // Method to get the current player
    public static Character getPlayer() {
        return player;
    }

    // Method to set a new player (optional)
    public static void setPlayer(Character newPlayer) {
        player = newPlayer;
    }
}
