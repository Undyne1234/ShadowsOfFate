package com.dungeonchronicles.characters;

public class Wizard extends Character {
    public Wizard() {
        this.health = 80;
        this.attackPower = 20;
        this.defense = 5;
        this.name = "Mage";
    }

    @Override
    public void attack(Character defender) {
        System.out.println(name + " casts Fireball!");
        defender.setHealth(defender.getHealth() - attackPower);
    }

    @Override
    public void defend() {
        System.out.println(name + " casts a protective shield.");
        defense += 3; // Temporarily increase defense
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " uses Teleport!");
        // Teleport logic here
    }
}
