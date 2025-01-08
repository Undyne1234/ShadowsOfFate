package com.dungeonchronicles.ui;
import java.util.Scanner;

public class UserInteraction {
    private Scanner scanner = new Scanner(System.in);

    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void renderASCII(String art) {
        System.out.println(art);
    }
}
