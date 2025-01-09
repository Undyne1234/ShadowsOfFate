package com.dungeonchronicles.states;

import com.dungeonchronicles.ui.UserInteraction;

public class GameOverState implements GameState {
    private UserInteraction userInteraction = new UserInteraction();

    @Override
    public void enterState() {
        userInteraction.displayMessage("Game Over! You have been defeated.");
    }

    @Override
    public void execute() {
        userInteraction.displayMessage("Would you like to try again?");
        userInteraction.displayMessage("1. Restart Game");
        userInteraction.displayMessage("2. Exit");
        String choice = userInteraction.getInput("Please choose an option (1 or 2):");

        switch (choice) {
            case "1":
                // Restart the game from the main menu
                GameStateManager manager = new GameStateManager();
                GameState mainMenuState = new MainMenuState(); // Assuming MainMenuState exists
                manager.changeState(mainMenuState);
                manager.executeState();
                break;
            case "2":
                // Exit the game
                System.exit(0);
                break;
            default:
                userInteraction.displayMessage("Invalid option. Please choose 1 or 2.");
                execute(); // Re-run the menu if the input is invalid
                break;
        }
    }

    @Override
    public void exitState() {
        userInteraction.displayMessage("Exiting Game Over Screen...");
    }
}
