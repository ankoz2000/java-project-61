package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class GCD {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int DATA_LENGTH = 2;

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;

    public static void runGame(int rounds) {
        String[][] roundsData = new String[rounds][DATA_LENGTH];
        roundsData[0] = generateRoundData();
        roundsData[1] = generateRoundData();
        roundsData[2] = generateRoundData();

        Engine.start(roundsData, DESCRIPTION);
    }

    private static int findGcd(int firstNumber, int secondNumber) {
        int minDivider = 1;
        int zero = 0;
        if (firstNumber == 0 || secondNumber == 0) {
            return minDivider;
        }
        for (int i = Math.min(firstNumber, secondNumber); i > minDivider; i--) {
            if (firstNumber % i == zero && secondNumber % i == zero) {
                return i;
            }
        }
        return minDivider;
    }

    private static String[] generateRoundData() {
        int firstNumber = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);
        int secondNumber = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);

        String question = firstNumber + " " + secondNumber;
        String rightAnswer = String.valueOf(findGcd(firstNumber, secondNumber));

        String[] roundsData = new String[DATA_LENGTH];
        roundsData[0] = question;
        roundsData[1] = rightAnswer;

        return roundsData;
    }
}
