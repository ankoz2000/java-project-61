package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class GCD {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;

    public static void runGame() {
        String[][] roundsData = new String[Engine.getMaxRoundsCount()][2];
        for (int i = 0; i < Engine.getMaxRoundsCount(); i++) {
            roundsData[i] = generateRoundData();
        }

        Engine.start(roundsData, DESCRIPTION);
    }

    private static int findGcd(int firstNumber, int secondNumber) {
        while (secondNumber != 0) {
            int tmp = firstNumber % secondNumber;
            firstNumber = secondNumber;
            secondNumber = tmp;
        }
        return firstNumber;
    }

    private static String[] generateRoundData() {
        int firstNumber = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);
        int secondNumber = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);

        String question = firstNumber + " " + secondNumber;
        String rightAnswer = String.valueOf(findGcd(firstNumber, secondNumber));

        String[] roundsData = new String[2];
        roundsData[0] = question;
        roundsData[1] = rightAnswer;

        return roundsData;
    }
}
