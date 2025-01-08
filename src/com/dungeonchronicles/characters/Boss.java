package com.dungeonchronicles.characters;

public class Boss extends Character {
    public Boss() {
        this.name = "Boss";
        this.health = 200;
        this.attack = 70;
        this.defense = 50;
    }

    @Override
    public void display() {
        System.out.println("ASCII Art of Boss");
    }
}
