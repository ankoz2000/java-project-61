package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String userName;

    public static void greet() {
        Scanner userInteraction = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");

        userName = userInteraction.next();

        System.out.println("Hello, " + userName + "!");

        userInteraction.close();
    }

    public static String getUserName() {
        return userName;
    }
}
