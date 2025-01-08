package com.dungeonchronicles.combat;

public class DefendStrategy implements ActionStrategy {
    @Override
    public void execute(Character player, Character enemy) {
        System.out.println(player.name + " defends, reducing incoming damage.");
        // Implement defense logic
    }
}
