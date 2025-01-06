package com.dungeonchronicles.states;

public class GameStateManager {
    private GameState currentState;

    public void changeState(GameState newState) {
        if (currentState != null) {
            currentState.exitState();
        }
        currentState = newState;
        currentState.enterState();
    }

    public void executeState() {
        if (currentState != null) {
            currentState.execute();
        }
    }
}