package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import hexlet.code.games.GCD;

import java.util.Scanner;

public class App {
    private static final int ROUNDS = 3;

    private static Scanner userInteraction = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        System.out.println("Please enter the game number and press Enter.");
        System.out.print("Your choice: ");

        int choice = userInteraction.nextInt();
        switch (choice) {
            case 1 -> {
                Cli.greet();
            }
            case 2 -> {
                Cli.greet();
                Even.runGame(ROUNDS);
            }
            case 3 -> {
                Cli.greet();
                Calculator.runGame(ROUNDS);
            }
            case 4 -> {
                Cli.greet();
                GCD.runGame(ROUNDS);
            }
            case 5 -> {
                Cli.greet();
                Progression.runGame(ROUNDS);
            }
            case 6 -> {
                Cli.greet();
                Prime.runGame(ROUNDS);
            }
            default -> {

            }
        }
    }
}
