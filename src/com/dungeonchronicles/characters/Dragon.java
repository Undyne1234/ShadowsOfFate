package com.dungeonchronicles.characters;

public class Dragon extends Monster {
    public Dragon() {
        this.health = 150;
        this.attackPower = 20;
        this.defense = 10;
        this.name = "Dragon";
    }

    @Override
    public void attack(Character defender) {
        System.out.println(name + " breathes fire!");
        defender.setHealth(defender.getHealth() - attackPower);
    }

    @Override
    public void defend() {
        System.out.println(name + " shields itself with dragon scales.");
        defense += 8; // Significantly boost defense
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " uses a devastating Firestorm!");
        attackPower *= 2; // Double attack power for a turn
    }
}
