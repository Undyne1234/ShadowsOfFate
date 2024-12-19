package com.dungeonchronicles.states;

public class ExplorationState implements GameState {
    @Override
    public void enterState() {
        System.out.println("Entering Exploration Mode...");
    }

    @Override
    public void execute() {
        System.out.println("You are exploring the dungeon.");
        System.out.println("Options: ");
        System.out.println("1. Move to the next room");
        System.out.println("2. Check Inventory");
        System.out.println("3. Exit Exploration");
        // Add user input logic here to perform actions
    }

    @Override
    public void exitState() {
        System.out.println("Exiting Exploration Mode...");
    }
}
