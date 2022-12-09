package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static boolean start(String question, String rightAnswer) {
        Scanner userInteraction = new Scanner(System.in);
        System.out.println(question);
        String answer = userInteraction.next();
        if (answer.equals(rightAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answer + "'"
                    + " is wrong answer ;(. Correct answer was '" + rightAnswer + "'.\n"
                    + "Let's try again, " + Cli.getUserName() + "!");
            userInteraction.close();
            return false;
        }
        userInteraction.close();
        return true;
    }
}
