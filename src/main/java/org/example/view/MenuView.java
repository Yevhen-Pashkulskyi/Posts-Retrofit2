package org.example.view;

import java.util.Scanner;

public class MenuView {

    private final Scanner scanner = new Scanner(System.in);

    public int displayMenuAndGetChoice() {
        System.out.println("\n____ MENU ____");
        System.out.println("1 - Get all posts");
        System.out.println("2 - Get post by ID");
        System.out.println("0 - Exit");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine());//getPostId
    }

    public int getPostId() {
        System.out.print("Enter post ID: ");
        return Integer.parseInt(scanner.nextLine());
    }
}