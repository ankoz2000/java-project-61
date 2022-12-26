package hexlet.code;

import java.util.Scanner;

public final class Engine {
    private static final int ROUNDS = 3;

    public static void start(String[][] roundsData, String description) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");

        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();

        System.out.println("Hello, " + userName + "!");
        System.out.println(description);

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

    public static Integer getMaxRoundsCount() {
        return ROUNDS;
    }
}
