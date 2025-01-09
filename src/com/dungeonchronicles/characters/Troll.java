package com.dungeonchronicles.characters;

public class Troll extends Monster {
    public Troll() {
        this.health = 80;
        this.attackPower = 10;
        this.defense = 6;
        this.name = "Troll";
    }

    @Override
    public void attack(Character defender) {
        System.out.println(name + " smashes with a club!");
        defender.setHealth(defender.getHealth() - attackPower);
    }

    @Override
    public void defend() {
        System.out.println(name + " curls up and uses regeneration.");
        defense += 5; // Increase defense slightly
        this.health += 10; // Regenerates health each turn
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(name + " roars, intimidating the enemy!");
        attackPower *= 1.3; // Temporarily increases attack power
    }
}
