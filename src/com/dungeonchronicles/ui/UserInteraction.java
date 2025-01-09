package com.dungeonchronicles.ui;

import java.util.Scanner;

public class UserInteraction {
    private Scanner scanner = new Scanner(System.in);

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getInput(String prompt) {
        displayMessage(prompt);
        return scanner.nextLine();
    }
}
