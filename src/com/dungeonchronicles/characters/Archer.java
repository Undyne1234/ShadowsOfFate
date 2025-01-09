package com.dungeonchronicles.characters;

public class Archer extends Character {
    public Archer() {
        this.health = 100;
        this.attackPower = 12;
        this.defense = 8;
        this.name = "Archer";
    }

    @Override
    public void attack(Character defender) {
        System.out.println(name + " shoots an arrow!");
        defender.setHealth(defender.getHealth() - attackPower);
    }

    @Override
    public void defend() {
        System.out.println(name + " dodges the attack.");
        defense += 3; // Temporarily increase defense
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " uses Precision Shot!");
        attackPower *= 2; // Temporarily increase attack power
    }
}

