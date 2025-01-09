package com.dungeonchronicles.combat;

import com.dungeonchronicles.characters.Character;

public interface CombatStrategy {
    void execute(Character attacker, Character defender);
}
