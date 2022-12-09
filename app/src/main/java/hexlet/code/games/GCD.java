package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;

public final class GCD {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;

    public static void runGame(int rounds) {
        String rules = "Find the greatest common divisor of given numbers.";
        System.out.println(rules);
        for (int i = 0; i < rounds; i++) {
            int firstNumber = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);
            int secondNumber = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);
            String question = firstNumber + " " + secondNumber;
            String rightAnswer = String.valueOf(findGcd(firstNumber, secondNumber));
            if (!Engine.start(question, rightAnswer)) {
                return;
            }
        }
    }

    private static int findGcd(int firstNumber, int secondNumber) {
        int minDivider = 1;
        int zero = 0;
        for (int i = Math.min(firstNumber, secondNumber); i > minDivider; i--) {
            if (firstNumber % i == zero && secondNumber % i == zero) {
                return i;
            }
        }
        return minDivider;
    }
}
