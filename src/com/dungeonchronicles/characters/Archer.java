package com.dungeonchronicles.characters;

public class Archer extends Character {
    public Archer() {
        this.name = "Archer";
        this.health = 100;
        this.attack = 40;
        this.defense = 30;
    }

    @Override
    public void display() {
        System.out.println("ASCII Art of Archer");
    }
}
