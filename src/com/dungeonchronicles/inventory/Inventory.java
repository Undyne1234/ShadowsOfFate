package com.dungeonchronicles.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
        System.out.println(item + " added to inventory.");
    }

    public void removeItem(String item) {
        if (items.remove(item)) {
            System.out.println(item + " removed from inventory.");
        } else {
            System.out.println(item + " not found.");
        }
    }

    public void displayInventory() {
        System.out.println("Inventory: " + items);
    }
}
