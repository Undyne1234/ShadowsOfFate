package com.dungeonchronicles.combat;

import com.dungeonchronicles.characters.Character;

public class MeleeAttack implements CombatStrategy {
    @Override
    public void execute(Character attacker, Character defender) {
        System.out.println(attacker + " strikes with a melee attack!");
        defender.setHealth(defender.getHealth() - attacker.getAttackPower());
    }
}
