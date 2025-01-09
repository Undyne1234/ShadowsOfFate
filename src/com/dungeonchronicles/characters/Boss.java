package com.dungeonchronicles.characters;

public class Boss extends Character {
    public Boss() {
        this.name = "Boss";
        this.health = 200;
        this.attackPower = 70;
        this.defense = 50;
    }

    public void display() {
        System.out.println("ASCII Art of Boss");
    }

    @Override
    public void attack(Character defender) {
        System.out.println(name + " attacks " + defender);
        defender.setHealth(defender.getHealth() - attackPower);
    }

    @Override
    public void defend() {
        System.out.println(name + " defends!");
        defense += 10;
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " uses special ability!");
        attackPower += 20;
    }
}
