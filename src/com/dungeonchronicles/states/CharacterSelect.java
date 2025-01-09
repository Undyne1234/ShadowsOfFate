package com.dungeonchronicles.states;

import com.dungeonchronicles.ui.UserInteraction;
import com.dungeonchronicles.characters.Character;
import com.dungeonchronicles.characters.Warrior;
import com.dungeonchronicles.characters.Archer;
import com.dungeonchronicles.characters.Wizard;

public class CharacterSelect {
    private UserInteraction userInteraction = new UserInteraction();

    public Character selectCharacter() {
        userInteraction.displayMessage("Character Selection:");
        userInteraction.displayMessage("1. Warrior - A brave melee fighter with high health.");
        userInteraction.displayMessage("2. Archer - A skilled ranged fighter with high precision.");
        userInteraction.displayMessage("3. Wizard - A master of elemental spells with powerful attacks.");

        String choice = userInteraction.getInput("Please select your character (1, 2, or 3):");

        switch (choice) {
            case "1":
                userInteraction.displayMessage("You have chosen Warrior!");
                return new Warrior();
            case "2":
                userInteraction.displayMessage("You have chosen Archer!");
                return new Archer();
            case "3":
                userInteraction.displayMessage("You have chosen Wizard!");
                return new Wizard();
            default:
                userInteraction.displayMessage("Invalid option. Please try again.");
                return selectCharacter(); // Re-run selection if the input is invalid
        }
    }
}