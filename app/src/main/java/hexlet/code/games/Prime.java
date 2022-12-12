package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Prime {
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int DATA_LENGTH = 2;

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 50;
    private static final int FIRST_PRIME_NUMBER = 3;

    public static void runGame(int rounds) {
        String[][] roundsData = new String[rounds][DATA_LENGTH];
        roundsData[0] = generateRoundData();
        roundsData[1] = generateRoundData();
        roundsData[2] = generateRoundData();

        if (!Engine.start(roundsData, DESCRIPTION)) {
            return;
        }
    }

    public static boolean isPrime(int number) {
        int one = 1;
        int two = 2;
        if (number <= one || number % 2 == 0) {
            return false;
        }
        if (number <= FIRST_PRIME_NUMBER) {
            return true;
        }
        int k = (int) Math.round(Math.sqrt(number));
        return findMinDivider(number, two, k);
    }

    private static boolean findMinDivider(int number, int step, int k) {
        for (int i = FIRST_PRIME_NUMBER; i <= k; i += step) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static String[] generateRoundData() {
        int number = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);

        String question = String.valueOf(number);
        String rightAnswer = isPrime(number) ? "yes" : "no";

        String[] roundsData = new String[DATA_LENGTH];
        roundsData[0] = question;
        roundsData[1] = rightAnswer;

        return roundsData;
    }
}
