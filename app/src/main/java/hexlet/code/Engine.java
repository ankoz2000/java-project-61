package hexlet.code;

import hexlet.code.games.Greeting;
import hexlet.code.interfaces.Game;

public final class Engine {
    private final Integer roundsCount;

    public Engine(Integer count) {
        this.roundsCount = count;
    }

    public void start(Game game) {
        boolean isSuccess = true;
        for (int i = 0; i < getRoundsCount(); i++) {
            game.startRound();
            Cli.askQuestion(game.getQuestion());
            game.setAnswerFromUser(Cli.getAnswer());
            if (game.isRightAnswer()) {
                Cli.showSuccessMessage("Correct!");
            } else {
                Cli.showErrorMessage("'" + game.getLastAnswer() + "'"
                        + " is wrong answer ;(. Correct answer was '" + game.getRightAnswer() + "'.\n"
                        + "Let's try again, " + Greeting.getUsername() + "!");
                isSuccess = false;
                if (game.endsOnFail()) {
                    return;
                }
            }
        }
    }

    public Integer getRoundsCount() {
        return roundsCount;
    }
}
