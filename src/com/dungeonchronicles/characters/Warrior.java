package com.dungeonchronicles.characters;

public class Warrior extends Character {
    public Warrior() {
        this.health = 120;
        this.attackPower = 15;
        this.defense = 10;
        this.name = "Warrior";
    }

    @Override
    public void attack(Character defender) {
        System.out.println(name + " attacks with a sword!");
        defender.setHealth(defender.getHealth() - attackPower);
    }

    @Override
    public void defend() {
        System.out.println(name + " defends with a shield.");
        defense += 5; // Temporarily increase defense
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " uses Berserk Rage!");
        attackPower *= 1.5; // Increase attack power temporarily
    }
}
