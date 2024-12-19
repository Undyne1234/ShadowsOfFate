package com.dungeonchronicles.states;

public interface GameState {
    void enterState();
    void execute();
    void exitState();
}