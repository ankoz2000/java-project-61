package hexlet.code.games;

import hexlet.code.interfaces.Game;
import hexlet.code.utils.RandomGenerator;

public final class GCD implements Game {
    private String name;
    private String rules;
    private String question;
    private static String lastAnswer;
    private static String rightAnswer;
    private boolean endsOnFail;

    public GCD() {
        name = "GCD";
        rules = "Find the greatest common divisor of given numbers.";
        endsOnFail = false;
    }

    @Override
    public String getRules() {
        return rules;
    }

    @Override
    public void startRound() {
        int firstNumber = RandomGenerator.getRandomNumber();
        int secondNumber = RandomGenerator.getRandomNumber();
        question = firstNumber + " " + secondNumber;
        rightAnswer = String.valueOf(findGcd(firstNumber, secondNumber));
    }

    private int findGcd(int firstNumber, int secondNumber) {
        int minDivider = 1;
        int zero = 0;
        for (int i = Math.min(firstNumber, secondNumber); i > minDivider; i--) {
            if (firstNumber % i == zero && secondNumber % i == zero) {
                return i;
            }
        }
        return minDivider;
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
        return lastAnswer.equals(rightAnswer);
    }

    @Override
    public boolean endsOnFail() {
        return endsOnFail;
    }
}
