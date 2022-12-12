package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static boolean start(String[][] roundsData, String description) {
        String userName = Cli.greet();

        System.out.println(description);

        Scanner scanner = new Scanner(System.in);

        for (String[] data : roundsData) {
            String question = data[0];
            String rightAnswer = data[1];
            System.out.println("Question: " + question);

            String answer = scanner.next();

            if (answer.equals(data[1])) {
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
}
