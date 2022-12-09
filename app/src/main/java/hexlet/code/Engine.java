package hexlet.code;

public final class Engine {
    public static boolean start(String question, String rightAnswer) {
        System.out.println("Question: " + question);
        String answer = Cli.getUserInteraction().next();

        if (answer.equals(rightAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answer + "'"
                    + " is wrong answer ;(. Correct answer was '" + rightAnswer + "'.\n"
                    + "Let's try again, " + Cli.getUserName() + "!");

            return false;
        }
        System.out.println("Congratulations, " + Cli.getUserName() + "!");
        return true;
    }
}
