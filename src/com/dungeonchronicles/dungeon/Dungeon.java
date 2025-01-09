package com.dungeonchronicles.dungeon;
import com.dungeonchronicles.characters.Character;
import com.dungeonchronicles.states.CombatState;
import com.dungeonchronicles.states.GameStateManager;
import com.dungeonchronicles.ui.UserInteraction;
import com.dungeonchronicles.characters.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.dungeonchronicles.game.Game.getPlayer;

public class Dungeon {
    private final List<DungeonComponent> rooms = new ArrayList<>();
    private int currentRoomIndex = 0;
    private boolean isBossRoomGenerated = false;
    private UserInteraction userInteraction = new UserInteraction();

    public void addRoom(DungeonComponent room) {
        rooms.add(room);
    }

    public void explore() {
        Random rand = new Random();
        while (currentRoomIndex < rooms.size()) {
            DungeonComponent currentRoom = rooms.get(currentRoomIndex);
            currentRoom.display();

            // Random chance of a boss room
            if (!isBossRoomGenerated && rand.nextInt(10) > 7) {
                rooms.add(new BossRoom("The Boss Room"));
                isBossRoomGenerated = true;
                userInteraction.displayMessage("A Boss Room has appeared!");
            }

            // Random chance of combat or empty room
            if (rand.nextInt(2) == 1) {
                // Empty room or trap
                userInteraction.displayMessage("You find an empty room or trap.");
            } else {
                // Combat
                userInteraction.displayMessage("A monster appears!");
                CombatState combatState = new CombatState(getPlayer(), rand.nextBoolean() ? new Monster() : new Boss());
                GameStateManager manager = new GameStateManager();
                manager.changeState(combatState);
                manager.executeState();
            }
            currentRoomIndex++;
        }
    }
}