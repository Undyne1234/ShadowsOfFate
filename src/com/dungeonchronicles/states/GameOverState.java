package com.dungeonchronicles.states;

public class GameOverState implements GameState {
    @Override
    public void enterState() {
        System.out.println("Game Over...");
    }

    @Override
    public void execute() {
        System.out.println("Would you like to try again?");
        System.out.println("Options: ");
        System.out.println("1. Restart Game");
        System.out.println("2. Exit");
        // Add user input logic here to restart or exit
    }

    @Override
    public void exitState() {
        System.out.println("Exiting Game Over Screen...");
    }
}
