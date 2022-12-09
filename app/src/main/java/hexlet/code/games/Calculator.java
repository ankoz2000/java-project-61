package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.Utils;

public final class Calculator {

    private static final int OPERATIONS_COUNT = 3;

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 100;

    public static void runGame(int rounds) {
        String rules = "What is the result of the expression?";
        System.out.println(rules);
        for (int i = 0; i < rounds; i++) {
            String operation = getRandomOperation();
            int firstOperand = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);
            int secondOperand = Utils.getRandomNumberWithInterval(MIN_VALUE, MAX_VALUE);
            String question = firstOperand + " " + operation + " " + secondOperand;
            String rightAnswer;
            if (operation.equals("+")) {
                rightAnswer = String.valueOf(firstOperand + secondOperand);
            } else if (operation.equals("-")) {
                rightAnswer = String.valueOf(firstOperand - secondOperand);
            } else {
                rightAnswer = String.valueOf(firstOperand * secondOperand);
            }
            if (!Engine.start(question, rightAnswer)) {
                return;
            }
        }
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
}
