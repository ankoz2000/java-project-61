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
        for (int i = 0; i < Engine.getMaxRoundsCount(); i += 1) {
            roundsData[i] = generateRoundData();
        }

        Engine.start(roundsData, DESCRIPTION);
    }

    public static String getProgressionString(String[] progression, String hiddenNumber) {
        StringBuilder questionBuilder = new StringBuilder();
        for (String num : progression){
            if (num.equals(hiddenNumber)) {
                questionBuilder.append("..");
            } else {
                questionBuilder.append(num);
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
        int hiddenNumberPosition = Utils.getRandomNumberWithInterval(MIN_POSITION_TO_HIDE, numberCount);
        numberCount = numberCount > MAX_NUMBER_COUNT ? numberCount - numberCount % MAX_NUMBER_COUNT : numberCount;

        String[] progression = makeProgression(firstNumber, step, numberCount);
        String rightAnswer = progression[hiddenNumberPosition];
        String question = getProgressionString(progression, progression[hiddenNumberPosition]);

        String[] roundsData = new String[2];
        roundsData[0] = question;
        roundsData[1] = rightAnswer;
        return roundsData;
    }

    private static String[] makeProgression(int first, int step, int length) {
        String[] progression = new String[length];
        for (int i = 1; i < length; i++) {
            progression[i] = String.valueOf(getProgressionNumber(first, step, i));
        }
        return progression;
    }
}
