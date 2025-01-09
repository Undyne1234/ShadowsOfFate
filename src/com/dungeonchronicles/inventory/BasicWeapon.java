package com.dungeonchronicles.inventory;

public class BasicWeapon extends Weapon {
    public BasicWeapon() {
        description = "Basic Weapon";
    }

    @Override
    public int getDamage() {
        return 10;
    }
}
