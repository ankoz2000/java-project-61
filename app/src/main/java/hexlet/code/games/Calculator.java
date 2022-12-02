package hexlet.code.games;

import hexlet.code.interfaces.Game;
import hexlet.code.utils.RandomGenerator;

public final class Calculator implements Game {
    private final String name;
    private final String rules;
    private String question;
    private static String lastAnswer;
    private static String rightAnswer;
    private final boolean endsOnFail;

    public Calculator() {
        name = "Calc";
        rules = "What is the result of the expression?";
        endsOnFail = true;
    }

    @Override
    public String getRules() {
        return rules;
    }

    @Override
    public void startRound() {
        String operation = RandomGenerator.getRandomOperation();
        int firstOperand = RandomGenerator.getRandomNumber();
        int secondOperand = RandomGenerator.getRandomNumber();
        question = firstOperand + " " + operation + " " + secondOperand;
        if (operation.equals("+")) {
            rightAnswer = String.valueOf(firstOperand + secondOperand);
        } else if (operation.equals("-")) {
            rightAnswer = String.valueOf(firstOperand - secondOperand);
        } else {
            rightAnswer = String.valueOf(firstOperand * secondOperand);
        }
    }

    @Override
    public String getLastAnswer() {
        return lastAnswer;
    }

    @Override
    public String getRightAnswer() {
        return rightAnswer;
    }

    @Override
    public String getGameName() {
        return name;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setAnswerFromUser(String answerFromUser) {
        lastAnswer = answerFromUser;
    }

    @Override
    public boolean isRightAnswer() {
        return rightAnswer.equals(lastAnswer);
    }

    @Override
    public boolean endsOnFail() {
        return endsOnFail;
    }
}
