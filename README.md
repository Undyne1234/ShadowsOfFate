<p align="center">
  <img src="https://github.com/user-attachments/assets/02ce71eb-26ed-4031-ac72-bd04642094cf" alt="Game Banner">
</p>


## Introduction

**Dungeon Chronicles: Shadows of Fate** is a text-based role-playing game where players embark on an epic journey through dungeons, battling monsters, collecting treasures, and upgrading their characters. The game combines classic RPG elements with modern software design patterns for a seamless and engaging experience.

---

## Key Features

- **Choose from three unique character classes:** Warrior, Mage, and Archer.
- **Procedurally generated dungeons** with increasing difficulty.
- **Dynamic combat system** with flexible strategies and monster AI.
- **Upgradeable weapons and items** with special effects.

---

## 🎮 Gameplay Mechanics

### Character Creation

Players can select a character class, each with unique abilities and starting stats. Choose wisely to match your preferred playstyle:

- **Warrior:** High health and melee damage.
- **Mage:** Powerful spells but low physical defense.
- **Archer:** Balanced attack range and agility.

### Exploration

Navigate through interconnected dungeons filled with traps, treasures, and monsters. Each room offers choices that impact your journey, including hidden paths and puzzles.

### Combat System

Engage in turn-based combat using a variety of strategies:

- **Attack:** Direct damage to enemies.
- **Defend:** Reduce incoming damage.
- **Use Item:** Heal or gain buffs using inventory items.
- **Special Abilities:** Unique to your character class.

### Inventory Management

Collect treasures and items during your journey. The inventory system allows you to:

- Equip and upgrade weapons and armor.
- Use consumables for health and buffs.
- Manage limited space strategically.

---

## 🚀 Advanced Features

### Levels and Difficulty Scaling

Dungeons become progressively more challenging, introducing tougher monsters and complex layouts. Rewards also scale, ensuring a satisfying progression system.

### Dungeon System

Dungeons are built using the Builder and Composite design patterns, creating a structured yet randomized experience. Explore multi-room dungeons with varied layouts and hidden secrets.

### Special Weapon Enhancements

Use the Decorator pattern to upgrade weapons with effects like fire, ice, or poison. These enhancements provide strategic advantages in combat.

---

## 🧙‍♀️ Characters

### Available Character Classes

- **Warrior:** Starting Stats: High health, medium damage. Abilities: Shield Bash, Berserk Rage.
- **Mage:** Starting Stats: Low health, high damage. Abilities: Fireball, Teleport.
- **Archer:** Starting Stats: Balanced health and damage. Abilities: Precision Shot, Dodge.

---

# 📚 Design Patterns Used

## Creational Patterns

### 🏭 Abstract Factory Pattern

**Purpose:**
Creates families of related objects like different types of characters (Warrior, Mage, Archer) and their respective weapons or abilities.

**Implementation:**

**MonsterFactory Class:** Generates different types of monsters based on a random selection.

```java
package com.dungeonchronicles.characters;

import java.util.Random;

public class MonsterFactory {

    private static Random random = new Random();

    // Create a random monster
    public static Monster createRandomMonster() {
        int type = random.nextInt(3); // Randomly select monster type: 0 -> Goblin, 1 -> Orc, 2 -> Troll
        switch (type) {
            case 0:
                return new Goblin(); // Return a Goblin instance
            case 1:
                return new Orc(); // Return an Orc instance
            case 2:
                return new Troll(); // Return a Troll instance
            default:
                return new Goblin(); // Default to Goblin if something goes wrong
        }
    }

    // Create a random boss monster
    public static Monster createRandomBoss() {
        int type = random.nextInt(2); // Randomly select boss type: 0 -> Dragon, 1 -> Demon
        switch (type) {
            case 0:
                return new Dragon(); // Return a Dragon boss instance
            case 1:
                return a Demon(); // Return a Demon boss instance
            default:
                return new Dragon(); // Default to Dragon if something goes wrong
        }
    }
}
```


### 🛠️ Builder Pattern

**Purpose:**
Constructs complex objects like the dungeon layout or player inventory with various components (monsters, treasures, traps).

**Implementation:**

**DungeonBuilder Class:** Allows step-by-step creation of a dungeon with different elements.

```java
package com.dungeonchronicles.dungeon;

import java.util.Random;

public class DungeonBuilder {
    private final Dungeon dungeon = new Dungeon();
    private static final Random random = new Random();

    public DungeonBuilder addRoom(String name) {
        if (random.nextInt(10) > 7) {
            if (random.nextBoolean()) {
                dungeon.addRoom(new MonsterRoom(name));
            } else {
                dungeon.addRoom(new Treasure(name));
            }
        } else {
            dungeon.addRoom((DungeonComponent) new Room());
        }
        return this;
    }

    public Dungeon build() {
        return dungeon;
    }
}
```


## Structural Patterns

### 🌳 Composite Pattern

**Purpose:**
Represents the dungeon as a tree structure with rooms (nodes) and elements like traps, treasures, and monsters (leaves).

**Implementation:**

**Room Class:** Defines the basic structure of dungeon rooms.

```java
package com.dungeonchronicles.dungeon;

import java.util.Random;

public class Room {
    private boolean isMonsterRoom;
    private boolean containsHealingFountain;
    private boolean isEmpty;

    public Room() {
        Random rand = new Random();
        this.isMonsterRoom = rand.nextInt(10) < 3;
        this.containsHealingFountain = !isMonsterRoom && rand.nextInt(10) < 3;
        this.isEmpty = !isMonsterRoom && !containsHealingFountain;
    }

    public boolean isMonsterRoom() {
        return isMonsterRoom;
    }

    public boolean containsHealingFountain() {
        return containsHealingFountain;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
```


### 🎭 Decorator Pattern

**Purpose:**
Dynamically adds features to characters or items, such as enchanted weapons or increased armor.

**Implementation:**

**EnchantmentDecorator Abstract Class:** Serves as a base decorator for weapon enchantments.

```java
package com.dungeonchronicles.inventory;

public abstract class EnchantmentDecorator extends Weapon {
    public abstract String getDescription();
}
```

**FireEnchantment Class:** Adds fire damage to a weapon.

```java
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
```

## Behavioral Patterns

### 🔄 State Pattern

**Purpose:**
Manages the game states like MainMenu, Exploration, Combat, and GameOver.

**Implementation:**

**ExplorationState Class:** Defines exploration mechanics and transitions between states.

```java
package com.dungeonchronicles.states;

import com.dungeonchronicles.characters.MonsterFactory;
import com.dungeonchronicles.dungeon.Room;
import com.dungeonchronicles.ui.UserInteraction;
import com.dungeonchronicles.characters.Character;

public class ExplorationState implements GameState {
    private UserInteraction userInteraction = new UserInteraction();
    private Character player;
    private MonsterFactory monsterFactory = new MonsterFactory();

    public ExplorationState(Character player) {
        this.player = player;
    }

    @Override
    public void enterState() {
        userInteraction.displayMessage("Entering Exploration Mode...");
    }

    @Override
    public void execute() {
        Room currentRoom = new Room();
        if (currentRoom.isMonsterRoom()) {
            userInteraction.displayMessage("A monster appears! Get ready for combat!");
        } else {
            userInteraction.displayMessage("The room is empty. Continue exploring.");
        }
    }

    @Override
    public void exitState() {
        userInteraction.displayMessage("Exiting Exploration Mode...");
    }
}
```


### ⚔️ Strategy Pattern

**Purpose:**
Handles different combat strategies for player actions (e.g., Attack, Defend, Use Item) and monster behaviors (e.g., Aggressive, Defensive).

**Implementation:**

**CombatStrategy Interface:** Defines combat behaviors.

```java
package com.dungeonchronicles.combat;

import com.dungeonchronicles.characters.Character;

public interface CombatStrategy {
    void execute(Character attacker, Character defender);
}
```

**MagicAttack Class:** Implements a magic-based attack strategy.

```java
package com.dungeonchronicles.combat;

import com.dungeonchronicles.characters.Character;

public class MagicAttack implements CombatStrategy {
    @Override
    public void execute(Character attacker, Character defender) {
        System.out.println(attacker + " casts a magic attack!");
        defender.setHealth(defender.getHealth() - attacker.getAttackPower());
    }
}
```
---
- **Abstract Factory:** Creates families of related objects like characters and weapons.
- **Builder:** Constructs complex objects like dungeon layouts.
- **Composite:** Represents the dungeon structure for traversal.
- **Decorator:** Adds dynamic features to weapons and items.
- **State:** Manages game states like MainMenu, Exploration, and Combat.
- **Strategy:** Handles combat actions and monster AI.

---

## ❓ FAQ

### 1. Can I play the game on multiple devices?

Currently, save files are stored locally, but future updates **may** include cloud save functionality ☁️.

### 2. How do I upgrade my character?

Earn XP by defeating monsters and completing dungeons to unlock upgrades.

---

## 🛠️ Developer Notes

**Dungeon Chronicles: Shadows of Fate** was created to showcase modern software design patterns in an engaging RPG format. The game is designed to be scalable, making it an excellent foundation for future expansions and features. Enjoy your adventure! 

---
## 👩‍💻 Developers

This game is being developed by:

- **Fatimah Abbasi**  
  Email: [abba0005@hz.nl](mailto:abba0005@hz.nl)  
  
  ### Focus: Game Core and Infrastructure
  
  #### Key Responsibilities:
  - **Game State Management**  
    - Implement the State pattern for various game states (e.g., MainMenu, Exploration, Combat, GameOver).  
    - Manage transitions between states based on user input or game events.
  
  - **Dungeon Creation**  
    - Build the dungeon system using the Builder and Composite patterns.  
    - Represent dungeon structures with rooms, traps, treasures, and monsters using a tree-like model.
  
  - **Inventory System**  
    - Design and implement features for adding/removing items and displaying inventory contents.  
    
  - **Save/Load Functionality**  
    - Develop functionality to save and resume the game's state.
  
  - **Game Loop**  
    - Create a loop to manage transitions between states and call appropriate methods.

---

- **Wesley de Ruiter**  
  Email: [ruit0041@hz.nl](mailto:ruit0041@hz.nl)  
  
  ### Focus: Gameplay and User Interaction
  
  #### Key Responsibilities:
  - **Character Creation**  
    - Use the Abstract Factory pattern to generate character types (e.g., Warrior, Mage, Archer) with predefined stats and gear.  
    
  - **Combat System**  
    - Implement the Strategy pattern for various combat actions (Attack, Defend, Use Item).  
    - Design AI behaviors for monsters (e.g., Aggressive, Defensive).
  
  - **Enhancements and Effects**  
    - Add dynamic features to characters and weapons using the Decorator pattern (e.g., enchanted weapons).  
    
  - **User Interaction**  
    - Create a text-based UI for smooth character selection, exploration, and combat interactions.
  
  - **Level Progression**  
    - Scale monster difficulty and treasures as players advance.

---

## 🔗 Collaboration Points

- **Integration**:  
  Ensure Fatimah’s dungeon system seamlessly interacts with Wesley’s combat and exploration mechanics.

- **Testing**:  
  Collaborate on testing the overall game flow and resolving any issues.

- **Documentation**:  
  Maintain clear code documentation and use a shared repository for version control.

---

## ⚠️ Disclaimer

This game and all associated content are the intellectual property of the developers. Unauthorized distribution, reproduction, or modification is strictly prohibited. For inquiries, please contact the developers via their respective emails.
