package hexlet.code.games;

import hexlet.code.interfaces.Game;
import hexlet.code.utils.RandomGenerator;


public class Even implements Game {
    private static String lastAnswer;
    private static String rightAnswer;
    private final String name;
    private String question;
    private final String rules;
    private boolean endsOnFail;

    public Even() {
        name = "Even";
        rules = "Answer 'yes' if the number "
                + "is even, otherwise answer 'no'.";
        endsOnFail = true;
    }

    public String getRules() {
        return rules;
    }

    public void startRound() {
        int randomNumber = RandomGenerator.getRandomNumber();
        question = String.valueOf(randomNumber);
        rightAnswer = isEven(randomNumber) ? "yes" : "no";
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
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
