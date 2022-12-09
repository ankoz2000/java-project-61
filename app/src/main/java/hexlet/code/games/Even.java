package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;


public final class Even {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;
    public static void runGame(int rounds) {
        String rules = "Answer 'yes' if the number "
                + "is even, otherwise answer 'no'.";
        System.out.println(rules);

        for (int i = 0; i < rounds; i++) {
            int randomNumber = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);
            String question = String.valueOf(randomNumber);
            String rightAnswer = isEven(randomNumber) ? "yes" : "no";
            if (!Engine.start(question, rightAnswer)) {
                return;
            }
        }
    }

    private static boolean isEven(int number) {
        int zero = 0;
        int two = 2;
        return number % two == zero;
    }
}
