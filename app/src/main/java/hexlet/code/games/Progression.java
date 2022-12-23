package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Progression {
    private static final String DESCRIPTION = "What number is missing in the progression?";

    private static final int MIN_STEP_VALUE = 1;
    private static final int MAX_STEP_VALUE = 10;

    private static final int MIN_FIRST_NUMBER = 1;
    private static final int MAX_FIRST_NUMBER = 10;

    private static final int MIN_NUMBER_COUNT = 5;
    private static final int MAX_NUMBER_COUNT = 10;

    private static final int MIN_POSITION_TO_HIDE = 1;

    public static void runGame() {
        String[][] roundsData = new String[Engine.getMaxRoundsCount()][2];
        for (int i = 0; i < Engine.getMaxRoundsCount(); i++) {
            roundsData[i] = generateRoundData();
        }

        Engine.start(roundsData, DESCRIPTION);
    }

    private static String[] generateRoundData() {
        int step = Utils.getRandomNumberWithInterval(MIN_STEP_VALUE, MAX_STEP_VALUE);
        int firstNumber = Utils.getRandomNumberWithInterval(MIN_FIRST_NUMBER, MAX_FIRST_NUMBER);
        int numberCount = Utils.getRandomNumberWithInterval(MIN_NUMBER_COUNT, MAX_NUMBER_COUNT);
        int hiddenNumberPosition = Utils.getRandomNumberWithInterval(MIN_POSITION_TO_HIDE, numberCount);

        String[] progression = makeProgression(firstNumber, step, numberCount);
        String rightAnswer = progression[hiddenNumberPosition];
        progression[hiddenNumberPosition] = "..";
        String question = String.join(" ", progression);

        String[] roundsData = new String[2];
        roundsData[0] = question;
        roundsData[1] = rightAnswer;
        return roundsData;
    }

    private static String[] makeProgression(int first, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(first + step * i);
        }
        return progression;
    }
}
