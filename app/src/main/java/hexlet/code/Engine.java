package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static boolean start(String question, String rightAnswer) {
        System.out.println("Question: " + question);
        String answer = Cli.userInteraction.next();

        if (answer.equals(rightAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answer + "'"
                    + " is wrong answer ;(. Correct answer was '" + rightAnswer + "'.\n"
                    + "Let's try again, " + Cli.getUserName() + "!");

            return false;
        }
        return true;
    }
}
