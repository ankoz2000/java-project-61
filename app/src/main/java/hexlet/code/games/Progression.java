package hexlet.code.games;

import hexlet.code.interfaces.Game;
import hexlet.code.utils.RandomGenerator;

public final class Progression implements Game {
    private String name;
    private String rules;
    private String question;
    private boolean endsOnFail;
    private String whiteSpace = " ";
    private static String lastAnswer;
    private static String rightAnswer;
    private String replacement = "..";

    public Progression() {
        this.name = "Progression";
        this.rules = "What number is missing in the progression?";
        endsOnFail = true;
    }


    @Override
    public String getRules() {
        return rules;
    }

    @Override
    public void startRound() {
        int minStep = 1;
        int maxStep = 10;
        int step = RandomGenerator.getRandomNumberWithInterval(minStep, maxStep);

        int minNumber = 1;
        int maxNumber = 10;
        int firstNumber = RandomGenerator.getRandomNumberWithInterval(minNumber, maxNumber);

        int minNumberCount = 5;
        int maxNumberCount = 10;
        int numberCount = RandomGenerator.getRandomNumberWithInterval(minNumberCount, maxNumberCount);
        numberCount = numberCount > maxNumberCount ? numberCount - numberCount % maxNumberCount : numberCount;

        int minPositionToHide = 1;
        int hiddenNumberPosition = RandomGenerator.getRandomNumberWithInterval(minPositionToHide, numberCount);

        rightAnswer = String.valueOf(getProgressionNumber(firstNumber, step, hiddenNumberPosition));

        StringBuilder questionBuilder = new StringBuilder();
        for (int i = 1; i <= numberCount; i++) {
            if (i == hiddenNumberPosition) {
                questionBuilder.append(replacement);
            } else {
                questionBuilder.append(getProgressionNumber(firstNumber, step, i));
            }
            questionBuilder.append(whiteSpace);
        }

        question = questionBuilder.toString().trim();
    }

    public int getProgressionNumber(int firstNumber, int step, int position) {
        int offset = 1;
        return firstNumber + step * (position - offset);
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
