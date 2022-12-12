package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public final class Even {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int DATA_LENGTH = 2;

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;

    public static void runGame(int rounds) {
        String[][] roundsData = new String[rounds][DATA_LENGTH];
        roundsData[0] = generateRoundData();
        roundsData[1] = generateRoundData();
        roundsData[2] = generateRoundData();

        if (!Engine.start(roundsData, DESCRIPTION)) {
            return;
        }
    }

    private static boolean isEven(int number) {
        int zero = 0;
        int two = 2;
        return number % two == zero;
    }

    private static String[] generateRoundData() {
        int randomNumber = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);
        String question = String.valueOf(randomNumber);
        String rightAnswer = isEven(randomNumber) ? "yes" : "no";

        String[] roundsData = new String[DATA_LENGTH];
        roundsData[0] = question;
        roundsData[1] = rightAnswer;

        return roundsData;
    }
}
