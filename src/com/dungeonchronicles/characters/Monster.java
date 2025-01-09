package com.dungeonchronicles.characters;

public class Monster extends Character {
    public Monster() {
        this.health = 50;
        this.attackPower = 10;
        this.defense = 5;
        this.name = "Monster";
    }



    @Override
    public void attack(Character defender) {
        System.out.println(name + " attacks with claws!");
        defender.setHealth(defender.getHealth() - attackPower);
    }

    @Override
    public void defend() {
        System.out.println(name + " defends with its scales.");
        defense += 3; // Temporarily increase defense
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " uses Poison Breath!");
        attackPower *= 1.2; // Increase attack power temporarily
    }

    public String getName() {
        return name;
    }
}
