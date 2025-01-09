package com.dungeonchronicles.dungeon;

import com.dungeonchronicles.characters.Boss;
import com.dungeonchronicles.characters.Character;
import com.dungeonchronicles.characters.Monster;
import com.dungeonchronicles.characters.MonsterFactory;
import com.dungeonchronicles.states.CombatState;
import com.dungeonchronicles.states.GameStateManager;
import com.dungeonchronicles.ui.UserInteraction;

import static com.dungeonchronicles.game.Game.getPlayer;

public class BossRoom implements DungeonComponent {
    private String roomName;
    private UserInteraction userInteraction = new UserInteraction();

    public BossRoom(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public void display() {
        userInteraction.displayMessage("You've entered the " + roomName + "!");
        userInteraction.displayMessage("A boss monster is here!");

        // Start combat with the boss
        Character player = getPlayer(); // Assuming you have a method to get the player
        Monster boss = MonsterFactory.createRandomBoss();

        // Initiating Combat
        CombatState combatState = new CombatState(player, boss);
        GameStateManager manager = new GameStateManager();
        manager.changeState(combatState);
        manager.executeState();
    }
}
