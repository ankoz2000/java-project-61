package hexlet.code;

import hexlet.code.games.Greeting;
import hexlet.code.interfaces.Game;
import hexlet.code.interfaces.GamePreprocessor;

public class App {
    private static final int ROUNDS = 3;

    public static void main(String[] args) {
        GameStorage gameStorage = new GameStorage();

        Cli.showInitMessage();
        Cli.showAvailableChoices(gameStorage.getGames());

        int selectedGameId = Cli.selectGame();

        if (gameStorage.getExitId().equals(selectedGameId)) {
            return;
        } else {
            Cli.showWelcomeLetter();
            ((GamePreprocessor) gameStorage.getGreeting()).greet();
            if (gameStorage.getGreetingId().equals(selectedGameId)) {
                return;
            }
        }

        Game game = gameStorage.getGameById(selectedGameId);
        Cli.showPreInteractionMessageToUser(game.getRules());
        Engine engine = new Engine(ROUNDS);
        engine.start(game);
        Cli.showEndMessage(Greeting.congratulation());
        Cli.closeInteraction();
    }
}
