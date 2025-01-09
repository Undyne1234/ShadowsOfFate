package com.dungeonchronicles.characters;

public class Orc extends Monster {
    public Orc() {
        this.health = 50;
        this.attackPower = 8;
        this.defense = 4;
        this.name = "Orc";
    }

    @Override
    public void attack(Character defender) {
        System.out.println(name + " swings an axe!");
        defender.setHealth(defender.getHealth() - attackPower);
    }

    @Override
    public void defend() {
        System.out.println(name + " raises a shield for defense.");
        defense += 4;
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " enters a Frenzy and boosts attack!");
        attackPower *= 1.5;
    }
}
