package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String userName;

    private static final Scanner userInteraction = new Scanner(System.in);

    public static void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");

        userName = userInteraction.next();

        System.out.println("Hello, " + userName + "!");
    }

    public static String getUserName() {
        return userName;
    }

    public static Scanner getUserInteraction() {
        return userInteraction;
    }
}
