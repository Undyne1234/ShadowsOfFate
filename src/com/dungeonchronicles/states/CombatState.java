package com.dungeonchronicles.states;

import com.dungeonchronicles.ui.UserInteraction;
import com.dungeonchronicles.characters.Character;
import com.dungeonchronicles.combat.CombatStrategy;

import java.util.Random;

public class CombatState implements GameState {
    private UserInteraction userInteraction = new UserInteraction();
    private CombatStrategy combatStrategy;
    private Character player;
    private Character monster;

    public CombatState(Character player, Character monster) {
        this.player = player;
        this.monster = monster;
    }

    @Override
    public void enterState() {
        System.out.println("Entering combat...");
    }

    @Override
    public void execute() {
        // Display initial HP
        System.out.println("Your HP: " + player.getHealth());
        System.out.println("Monster HP: " + monster.getHealth());

        // Combat loop while both player and monster are alive
        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            // Display current HP for both player and monster
            System.out.println("\nYour HP: " + player.getHealth() + " | Monster HP: " + monster.getHealth());

            // Player's turn
            System.out.println("Options: ");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Special Attack");

            String action = userInteraction.getInput("What will you do?");

            switch (action) {
                case "1":
                    player.attack(monster);
                    System.out.println("You attack the monster!");
                    break;
                case "2":
                    player.defend();
                    System.out.println("You defend!");
                    break;
                case "3":
                    player.useSpecialAbility();
                    System.out.println("You use your special ability!");
                    break;
                default:
                    System.out.println("Invalid action. Try again.");
                    continue; // Re-run the player's turn if invalid input
            }

            // Monster's turn (random attack/block/special move)
            Random rand = new Random();
            int monsterAction = rand.nextInt(10);
            if (monsterAction < 4) {
                // Monster attacks
                monster.attack(player);
                System.out.println("Monster attacks! You take " + monster.getAttackPower() + " damage.");
            } else if (monsterAction < 7) {
                // Monster blocks
                System.out.println("Monster blocks your attack!");
            } else {
                // Monster uses special move
                monster.useSpecialAbility();
                System.out.println("Monster uses a special move!");
            }

            // Check for win/lose conditions
            if (player.getHealth() <= 0) {
                System.out.println("You have been defeated!");
                // Transition to GameOverState (or another relevant state)
                GameStateManager manager = new GameStateManager();
                manager.changeState(new GameOverState());
                break;
            } else if (monster.getHealth() <= 0) {
                System.out.println("You defeated the monster!");
                // Transition to the next room or end combat
                GameStateManager manager = new GameStateManager();
                manager.changeState(new ExplorationState());
                break;
            }

            // Wait for the next round
            userInteraction.getInput("\nPress Enter to continue...");
        }
    }

    @Override
    public void exitState() {
        System.out.println("Exiting combat...");
    }
}
