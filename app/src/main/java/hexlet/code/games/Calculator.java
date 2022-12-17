package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Calculator {
    private static final String DESCRIPTION = "What is the result of the expression?";

    private static final char[] OPERATORS = {'+', '-', '*'};

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;

    public static void runGame() {
        String[][] roundsData = new String[Engine.getMaxRoundsCount()][2];
        for (int i = 0; i < Engine.getMaxRoundsCount(); i += 1) {
            roundsData[i] = generateRoundData();
        }

        Engine.start(roundsData, DESCRIPTION);
    }

    public static char getRandomOperation() {
        int indexOfOperator = Utils.getRandomNumberWithInterval(0, OPERATORS.length - 1);
        return OPERATORS[indexOfOperator];
    }

    private static String calculate(int firstOperand, int secondOperand, String operation) {
        if (operation.equals("+")) {
            return String.valueOf(firstOperand + secondOperand);
        } else if (operation.equals("-")) {
            return String.valueOf(firstOperand - secondOperand);
        } else {
            return String.valueOf(firstOperand * secondOperand);
        }
    }

    private static String[] generateRoundData() {
        String operation = String.valueOf(getRandomOperation());

        int firstOperand = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);
        int secondOperand = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);

        String question = firstOperand + " " + operation + " " + secondOperand;
        String rightAnswer = calculate(firstOperand, secondOperand, operation);

        String[] roundsData = new String[2];
        roundsData[0] = question;
        roundsData[1] = rightAnswer;

        return roundsData;
    }
}
