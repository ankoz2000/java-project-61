package hexlet.code;

import java.util.Scanner;

public final class Engine {
    private static final int ROUNDS = 3;

    private static String userName;

    public static void start(String[][] roundsData, String description) {
        greet();

        System.out.println(description);

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < ROUNDS; i++) {
            String question = roundsData[i][0];
            String rightAnswer = roundsData[i][1];
            System.out.println("Question: " + question);

            String answer = scanner.next();

            if (answer.equals(roundsData[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "'"
                        + " is wrong answer ;(. Correct answer was '" + rightAnswer + "'.\n"
                        + "Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }

    private static void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");

        Scanner scanner = new Scanner(System.in);
        userName = scanner.next();

        System.out.println("Hello, " + userName + "!");
    }

    public static Integer getMaxRoundsCount() {
        return ROUNDS;
    }
}
