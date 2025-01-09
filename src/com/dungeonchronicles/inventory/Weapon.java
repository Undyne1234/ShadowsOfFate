package com.dungeonchronicles.inventory;

public abstract class Weapon {
    protected String description = "Unknown Weapon";

    public String getDescription() {
        return description;
    }

    public abstract int getDamage();
}
