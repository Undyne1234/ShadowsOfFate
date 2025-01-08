package com.dungeonchronicles.characters;

public class Warrior extends Character {
    public Warrior() {
        this.name = "Warrior";
        this.health = 120;
        this.attack = 30;
        this.defense = 50;
    }

    @Override
    public void display() {
        System.out.println("ASCII Art of Warrior");
    }
}