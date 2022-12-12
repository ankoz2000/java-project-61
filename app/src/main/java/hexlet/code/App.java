package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calculator;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    private static final int ROUNDS = 3;

    private static final int GCD_ID = 4;
    private static final int EVEN_ID = 2;
    private static final int CALC_ID = 3;
    private static final int GREET_ID = 1;
    private static final int PRIME_ID = 6;
    private static final int PROGRESSION_ID = 5;

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

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        switch (choice) {
            case GREET_ID -> {
                Cli.greet();
            }
            case EVEN_ID -> {
                Even.runGame(ROUNDS);
            }
            case CALC_ID -> {
                Calculator.runGame(ROUNDS);
            }
            case GCD_ID -> {
                GCD.runGame(ROUNDS);
            }
            case PROGRESSION_ID -> {
                Progression.runGame(ROUNDS);
            }
            case PRIME_ID -> {
                Prime.runGame(ROUNDS);
            }
            default -> {
                System.out.println("Invalid number entered. Restart the game.");
            }
        }
    }
}
