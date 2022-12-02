package hexlet.code.games;

import hexlet.code.interfaces.Game;
import hexlet.code.utils.RandomGenerator;

public final class Prime implements Game {
    private final String name;
    private final String rules;
    private String question;
    private static String lastAnswer;
    private static String rightAnswer;
    private final boolean endsOnFail;

    private static final int FIRST_PRIME_NUMBER = 3;

    public Prime() {
        this.name = "Prime";
        this.rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        endsOnFail = true;
    }

    @Override
    public String getRules() {
        return rules;
    }

    @Override
    public void startRound() {
        int number = RandomGenerator.getRandomNumber();
        question = String.valueOf(number);
        rightAnswer = isPrime(number) ? "yes" : "no";
    }

    public boolean isPrime(int number) {
        int one = 1;
        int two = 2;
        int zero = 0;
        if (number <= one || number % two == zero) {
            return false;
        }
        if (number == FIRST_PRIME_NUMBER) {
            return true;
        }
        int k = (int) Math.round(Math.sqrt(number));
        for (int i = FIRST_PRIME_NUMBER; i <= k; i += two) {
            if (number % k == zero) {
                return false;
            }
        }
        return true;
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
