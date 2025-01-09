package com.dungeonchronicles.dungeon;

import com.dungeonchronicles.characters.Character;
import com.dungeonchronicles.characters.Monster;
import com.dungeonchronicles.states.CombatState;
import com.dungeonchronicles.states.GameStateManager;
import com.dungeonchronicles.ui.UserInteraction;

import static com.dungeonchronicles.game.Game.getPlayer;

public class MonsterRoom implements DungeonComponent {
    private String roomName;
    private UserInteraction userInteraction = new UserInteraction();

    public MonsterRoom(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public void display() {
        userInteraction.displayMessage("You've entered the " + roomName + "!");
        userInteraction.displayMessage("A monster appears!");

        // Start combat with the regular monster
        Character player = getPlayer(); // Assuming you have a method to get the player
        Monster monster = new Monster();

        // Initiating Combat
        CombatState combatState = new CombatState(player, monster);
        GameStateManager manager = new GameStateManager();
        manager.changeState(combatState);
        manager.executeState();
    }
}
