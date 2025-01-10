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

## 📚 Design Patterns Used

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
