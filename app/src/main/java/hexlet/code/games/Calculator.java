package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Calculator {
    private static final String DESCRIPTION = "What is the result of the expression?";
    private static final int DATA_LENGTH = 2;

    private static final int OPERATIONS_COUNT = 3;

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;


    public static void runGame(int rounds) {
        String[][] roundsData = new String[rounds][DATA_LENGTH];
        roundsData[0] = generateRoundData();
        roundsData[1] = generateRoundData();
        roundsData[2] = generateRoundData();

        Engine.start(roundsData, DESCRIPTION);
    }

    public static String getRandomOperation() {
        int min = 1;
        int number = Utils.getRandomNumberWithInterval(min, OPERATIONS_COUNT);

        int plusIntEquivalent = 1;
        int minusIntEquivalent = 2;
        if (number == plusIntEquivalent) {
            return "+";
        } else if (number == minusIntEquivalent) {
            return "-";
        }
        return "*";
    }

    private static String getExpressionAnswer(int firstOperand, int secondOperand, String operation) {
        if (operation.equals("+")) {
            return String.valueOf(firstOperand + secondOperand);
        } else if (operation.equals("-")) {
            return String.valueOf(firstOperand - secondOperand);
        } else {
            return String.valueOf(firstOperand * secondOperand);
        }
    }

    private static String[] generateRoundData() {
        String operation = getRandomOperation();

        int firstOperand = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);
        int secondOperand = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);

        String question = firstOperand + " " + operation + " " + secondOperand;
        String rightAnswer = getExpressionAnswer(firstOperand, secondOperand, operation);

        String[] roundsData = new String[DATA_LENGTH];
        roundsData[0] = question;
        roundsData[1] = rightAnswer;

        return roundsData;
    }
}
