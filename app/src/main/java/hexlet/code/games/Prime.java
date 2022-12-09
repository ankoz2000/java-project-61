package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;

public final class Prime {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 50;
    private static final int FIRST_PRIME_NUMBER = 3;

    public static void runGame(int rounds) {
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        System.out.println(rules);
        for (int i = 0; i < rounds; i++) {
            int number = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);
            String question = String.valueOf(number);
            String rightAnswer = isPrime(number) ? "yes" : "no";
            if (!Engine.start(question, rightAnswer)) {
                return;
            }
        }
    }

    public static boolean isPrime(int number) {
        int one = 1;
        int two = 2;
        int zero = 0;
        if (number <= one || number % two == zero) {
            return false;
        }
        if (number == FIRST_PRIME_NUMBER) {
            return true;
        }
        int k = (int) Math.round(Math.sqrt(number));
        for (int i = FIRST_PRIME_NUMBER; i <= k; i += two) {
            if (number % i == zero) {
                return false;
            }
        }
        return true;
    }
}
