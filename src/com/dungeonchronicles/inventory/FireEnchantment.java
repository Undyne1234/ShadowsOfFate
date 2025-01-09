package com.dungeonchronicles.inventory;

public class FireEnchantment extends EnchantmentDecorator {
    Weapon weapon;

    public FireEnchantment(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String getDescription() {
        return weapon.getDescription() + ", Fire Enchantment";
    }

    @Override
    public int getDamage() {
        return weapon.getDamage() + 5;
    }
}
