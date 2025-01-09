package com.dungeonchronicles.states;

import com.dungeonchronicles.characters.Character;
import com.dungeonchronicles.ui.UserInteraction;
import com.dungeonchronicles.game.Game;

public class MainMenuState implements GameState {
    private UserInteraction userInteraction = new UserInteraction();
    private CharacterSelect characterSelect = new CharacterSelect();

    @Override
    public void enterState() {
        userInteraction.displayMessage("Entering Main Menu...");
    }

    @Override
    public void execute() {
        userInteraction.displayMessage("1. Start Game\n2. Exit");
        String choice = userInteraction.getInput("Please choose an option (1 or 2):");

        switch (choice) {
            case "1":
                userInteraction.displayMessage("Starting the game...");
                Character playerCharacter = characterSelect.selectCharacter();  // Let the player select a character
                Game.startGame(playerCharacter);  // Store the selected player in the Game class
                userInteraction.displayMessage("You will play as: \n" + playerCharacter);

                // After character selection, transition to the ExplorationState (dungeon)
                GameState explorationState = new ExplorationState();
                GameStateManager manager = new GameStateManager();
                manager.changeState(explorationState);
                manager.executeState();
                break;
            case "2":
                userInteraction.displayMessage("Exiting the game...");
                System.exit(0);  // Exit the game
                break;
            default:
                userInteraction.displayMessage("Invalid option. Please choose 1 or 2.");
                execute();  // Re-run the menu if the input is invalid
                break;
        }
    }

    @Override
    public void exitState() {
        userInteraction.displayMessage("Exiting Main Menu...");
    }
}
