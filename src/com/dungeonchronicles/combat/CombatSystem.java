package com.dungeonchronicles.combat;

public class CombatSystem {
    private ActionStrategy strategy;

    public void setStrategy(ActionStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Character player, Character enemy) {
        strategy.execute(player, enemy);
    }
}
