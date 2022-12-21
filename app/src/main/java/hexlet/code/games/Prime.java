package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Prime {
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 50;

    public static void runGame() {
        String[][] roundsData = new String[Engine.getMaxRoundsCount()][2];
        for (int i = 0; i < Engine.getMaxRoundsCount(); i++) {
            roundsData[i] = generateRoundData();
        }

        Engine.start(roundsData, DESCRIPTION);
    }

    private static boolean isPrime(int number) {
        if (number <= 2) {
            return false;
        }
        int k = (int) Math.round(Math.sqrt(number));
        return findMinDivider(number, k);
    }

    private static boolean findMinDivider(int number,  int k) {
        for (int i = 3; i <= k; i += 2) {
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

        String[] roundsData = new String[2];
        roundsData[0] = question;
        roundsData[1] = rightAnswer;

        return roundsData;
    }
}
