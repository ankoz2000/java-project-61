package hexlet.code;

import hexlet.code.games.Greeting;
import hexlet.code.interfaces.Game;

public final class Engine {
    private final Integer roundsCount;
    private int points;

    public Engine(Integer count) {
        this.roundsCount = count;
        this.points = 0;
    }

    public void start(Game game) {
        for (int i = 0; i < getRoundsCount(); i++) {
            game.startRound();
            Cli.askQuestion(game.getQuestion());
            game.setAnswerFromUser(Cli.getAnswer());
            if (game.isRightAnswer()) {
                Cli.showSuccessMessage("Correct!");
                points += 1;
            } else {
                Cli.showErrorMessage("'" + game.getLastAnswer() + "'"
                        + " is wrong answer ;(. Correct answer was '" + game.getRightAnswer() + "'.\n"
                        + "Let's try again, " + Greeting.getUsername() + "!");
                return;
            }
        }
    }

    public Integer getRoundsCount() {
        return roundsCount;
    }

    public boolean isSuccess() {
        return points == roundsCount;
    }
}
