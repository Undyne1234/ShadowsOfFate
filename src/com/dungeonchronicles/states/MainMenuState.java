package com.dungeonchronicles.states;

public class MainMenuState implements GameState {
    @Override
    public void enterState() {
        System.out.println("Entering Main Menu...");
    }

    @Override
    public void execute() {
        System.out.println("1. Start Game\n2. Exit");
        // Add user input logic here to transition states
    }

    @Override
    public void exitState() {
        System.out.println("Exiting Main Menu...");
    }
}