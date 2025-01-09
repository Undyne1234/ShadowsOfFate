package com.dungeonchronicles.characters;

public class Demon extends Monster {
    public Demon() {
        this.health = 120;
        this.attackPower = 15;
        this.defense = 8;
        this.name = "Demon";
    }

    @Override
    public void attack(Character defender) {
        System.out.println(name + " attacks with dark magic!");
        defender.setHealth(defender.getHealth() - attackPower);
    }

    @Override
    public void defend() {
        System.out.println(name + " cloaks itself in dark energy.");
        defense += 6;
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " summons a Hellfire blast!");
        attackPower *= 1.8; // Temporarily boost attack power
    }
}
