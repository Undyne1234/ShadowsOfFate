package com.dungeonchronicles.characters;

public class Wizard extends Character {
    public Wizard() {
        this.name = "Wizard";
        this.health = 80;
        this.attack = 50;
        this.defense = 20;
    }

    @Override
    public void display() {
        System.out.println("ASCII Art of Wizard");
    }
}
