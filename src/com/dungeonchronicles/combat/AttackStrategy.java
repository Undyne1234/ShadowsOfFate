package com.dungeonchronicles.combat;


public class AttackStrategy implements ActionStrategy {
    @Override
    public void execute(Character player, Character enemy) {
        int damage = player.attack - enemy.defense;
        if (damage > 0) {
            enemy.takeDamage(damage);
            System.out.println(player.name + " attacks for " + damage + " damage!");
        } else {
            System.out.println(player.name + "'s attack was ineffective.");
        }
    }
}
