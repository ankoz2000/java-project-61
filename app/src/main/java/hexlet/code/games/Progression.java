package hexlet.code.games;

import hexlet.code.interfaces.Game;
import hexlet.code.utils.RandomGenerator;

public final class Progression implements Game {
    private final String name;
    private final String rules;
    private String question;
    private final boolean endsOnFail;
    private static String lastAnswer;
    private static String rightAnswer;

    private static final int minStepValue = 1;
    private static final int maxStepValue = 10;

    private static final int minFirstNumber = 1;
    private static final int maxFirstNumber = 10;

    private static final int minNumberCount = 5;
    private static final int maxNumberCount = 10;

    private static final int minPositionToHide = 1;

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
        int step = RandomGenerator.getRandomNumberWithInterval(minStepValue, maxStepValue);

        int firstNumber = RandomGenerator.getRandomNumberWithInterval(minFirstNumber, maxFirstNumber);

        int numberCount = RandomGenerator.getRandomNumberWithInterval(minNumberCount, maxNumberCount);
        numberCount = numberCount > maxNumberCount ? numberCount - numberCount % maxNumberCount : numberCount;

        int hiddenNumberPosition = RandomGenerator.getRandomNumberWithInterval(minPositionToHide, numberCount);

        rightAnswer = String.valueOf(getProgressionNumber(firstNumber, step, hiddenNumberPosition));

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
