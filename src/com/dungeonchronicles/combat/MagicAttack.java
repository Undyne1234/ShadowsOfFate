package com.dungeonchronicles.combat;

import com.dungeonchronicles.characters.Character;

public class MagicAttack implements CombatStrategy {
    @Override
    public void execute(Character attacker, Character defender) {
        System.out.println(attacker + " casts a magic attack!");
        defender.setHealth(defender.getHealth() - attacker.getAttackPower());
    }
}
