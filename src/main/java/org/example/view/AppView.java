package org.example.view;

import java.util.Scanner;

public class AppView {

  static Scanner scanner = new Scanner(System.in);

    public static String chooseOption() {
        getMenu();
        return scanner.nextLine();
    }

    private static void getMenu() {
        System.out.println("""
                ____ MENU _______________
                1 - Get all posts.
                2 - Get post by id.
                0 - Close the application.
                """);
    }

    public static void getOutput(String output, String choice) {
        System.out.println(output);
        if (choice.equals("0")) {
            scanner.close();
            System.exit(0);
        }
    }
}