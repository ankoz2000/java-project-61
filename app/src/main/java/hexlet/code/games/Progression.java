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

    private static final int MIN_STEP_VALUE = 1;
    private static final int MAX_STEP_VALUE = 10;

    private static final int MIN_FIRST_NUMBER = 1;
    private static final int MAX_FIRST_NUMBER = 10;

    private static final int MIN_NUMBER_COUNT = 5;
    private static final int MAX_NUMBER_COUNT = 10;

    private static final int MIN_POSITION_TO_HIDE = 1;

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
        int step = RandomGenerator.getRandomNumberWithInterval(MIN_STEP_VALUE, MAX_STEP_VALUE);

        int firstNumber = RandomGenerator.getRandomNumberWithInterval(MIN_FIRST_NUMBER, MAX_FIRST_NUMBER);

        int numberCount = RandomGenerator.getRandomNumberWithInterval(MIN_NUMBER_COUNT, MAX_NUMBER_COUNT);
        numberCount = numberCount > MAX_NUMBER_COUNT ? numberCount - numberCount % MAX_NUMBER_COUNT : numberCount;

        int hiddenNumberPosition = RandomGenerator.getRandomNumberWithInterval(MIN_POSITION_TO_HIDE, numberCount);

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
