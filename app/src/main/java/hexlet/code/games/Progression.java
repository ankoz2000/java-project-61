package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Progression {
    private static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int DATA_LENGTH = 2;

    private static final int MIN_STEP_VALUE = 1;
    private static final int MAX_STEP_VALUE = 10;

    private static final int MIN_FIRST_NUMBER = 1;
    private static final int MAX_FIRST_NUMBER = 10;

    private static final int MIN_NUMBER_COUNT = 5;
    private static final int MAX_NUMBER_COUNT = 10;

    private static final int MIN_POSITION_TO_HIDE = 1;

    public static void runGame(int rounds) {
        String[][] roundsData = new String[rounds][DATA_LENGTH];
        roundsData[0] = generateRoundData();
        roundsData[1] = generateRoundData();
        roundsData[2] = generateRoundData();

        Engine.start(roundsData, DESCRIPTION);
    }

    public static String getProgressionString(int firstNumber, int numberCount, int hiddenNumberPosition, int step) {
        StringBuilder questionBuilder = new StringBuilder();
        for (int i = 1; i <= numberCount; i++) {
            if (i == hiddenNumberPosition) {
                String replacement = "..";
                questionBuilder.append(replacement);
            } else {
                questionBuilder.append(getProgressionNumber(firstNumber, step, i));
            }
            String whiteSpace = " ";
            questionBuilder.append(whiteSpace);
        }
        return questionBuilder.toString().trim();
    }

    public static int getProgressionNumber(int firstNumber, int step, int position) {
        int offset = 1;
        return firstNumber + step * (position - offset);
    }

    private static String[] generateRoundData() {
        int step = Utils.getRandomNumberWithInterval(MIN_STEP_VALUE, MAX_STEP_VALUE);

        int firstNumber = Utils.getRandomNumberWithInterval(MIN_FIRST_NUMBER, MAX_FIRST_NUMBER);

        int numberCount = Utils.getRandomNumberWithInterval(MIN_NUMBER_COUNT, MAX_NUMBER_COUNT);
        numberCount = numberCount > MAX_NUMBER_COUNT ? numberCount - numberCount % MAX_NUMBER_COUNT : numberCount;

        int hiddenNumberPosition = Utils.getRandomNumberWithInterval(MIN_POSITION_TO_HIDE, numberCount);

        String rightAnswer = String.valueOf(getProgressionNumber(firstNumber, step, hiddenNumberPosition));

        String question = getProgressionString(firstNumber, numberCount, hiddenNumberPosition, step);

        String[] roundsData = new String[DATA_LENGTH];
        roundsData[0] = question;
        roundsData[1] = rightAnswer;

        return roundsData;
    }
}
