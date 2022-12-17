package hexlet.code;

import java.util.Scanner;

public final class Engine {
    private static final int ROUNDS = 3;

    public static boolean start(String[][] roundsData, String description) {
        String userName = greet();

        System.out.println(description);

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < getMaxRoundsCount(); i += 1) {
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
                return false;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
        return true;
    }

    private static String greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name? ");

        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();

        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static Integer getMaxRoundsCount() {
        return ROUNDS;
    }
}
