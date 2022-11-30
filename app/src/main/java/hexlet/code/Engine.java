package hexlet.code;

import hexlet.code.games.Greeting;
import hexlet.code.interfaces.Game;

public final class Engine {

    public void start(Game game) {
        int roundsCount = 3;
        for (int i = 0; i < roundsCount; i++) {
            game.startRound();
            Cli.askQuestion(game.getQuestion());
            game.setAnswerFromUser(Cli.getAnswer());
            if (!game.isRightAnswer()) {
                Cli.showErrorMessage("'" + game.getLastAnswer() + "'"
                        + " is wrong answer ;(. Correct answer was '" + game.getRightAnswer() + "'\n"
                        + "Let's try again, " + Greeting.getUsername() + "!");
                if (game.endsOnFail()) {
                    break;
                }
            } else {
                Cli.showSuccessMessage("Correct!");
            }
        }
    }
}
