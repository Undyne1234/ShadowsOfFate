package com.dungeonchronicles.characters;

public class Goblin extends Monster {
    public Goblin() {
        this.health = 30;
        this.attackPower = 5;
        this.defense = 2;
        this.name = "Goblin";
    }

    @Override
    public void attack(Character defender) {
        System.out.println(name + " attacks with a rusty dagger!");
        defender.setHealth(defender.getHealth() - attackPower);
    }

    @Override
    public void defend() {
        System.out.println(name + " hides behind a rock for defense.");
        defense += 2;
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " uses Stealth to evade an attack!");
        defense += 5;
    }
}
