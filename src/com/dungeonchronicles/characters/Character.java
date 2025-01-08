package com.dungeonchronicles.characters;

public abstract class Character {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;

    public abstract void display();

    // Common methods
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }
    public boolean isAlive() {
        return this.health > 0;
    }
}
