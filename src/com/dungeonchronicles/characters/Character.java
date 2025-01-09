package com.dungeonchronicles.characters;

public abstract class Character {
    protected int health;
    protected int attackPower;
    protected int defense;
    protected String name;

    public abstract void attack(Character defender);
    public abstract void defend();
    public abstract void useSpecialAbility();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return name + " (HP: " + health + ")";
    }
}
