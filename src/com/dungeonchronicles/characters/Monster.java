package com.dungeonchronicles.characters;

public class Monster extends  Character {
    public Monster() {
        this.name = "Monster";
        this.health = 150;
        this.attack = 50;
        this.defense = 20;
    }

    @Override
    public void display() {
        System.out.println("ASCII Art of Monster");
    }

}
