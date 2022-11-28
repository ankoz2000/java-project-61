package hexlet.code.games;

import hexlet.code.interfaces.Game;
import hexlet.code.utils.RandomGenerator;

public final class Prime implements Game {
    private String name;
    private String rules;
    private String question;
    private static String lastAnswer;
    private static String rightAnswer;
    private boolean endsOnFail;

    public Prime() {
        this.name = "Prime";
        this.rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        endsOnFail = false;
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
        int three = 3;
        int zero = 0;
        int two = 2;
        if (number <= one) {
            return false;
        }
        if (number <= three) {
            return true;
        }
        if (number % two == zero) {
            return false;
        }
        int k = (int) Math.round(Math.sqrt(number));
        for (int i = three; i <= k; i += two) {
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
