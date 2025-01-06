package com.dungeonchronicles.states;

public class CombatState implements GameState {
    @Override
    public void enterState() {
        System.out.println("Entering Combat...");
    }

    @Override
    public void execute() {
        System.out.println("You are in a battle!");
        System.out.println("Options: ");
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. Use Item");
        System.out.println("4. Flee");
        // Add user input logic here to simulate combat mechanics
    }

    @Override
    public void exitState() {
        System.out.println("Exiting Combat...");
    }
}
