package hexlet.code;

import hexlet.code.games.Greeting;
import hexlet.code.interfaces.Game;
import hexlet.code.interfaces.GamePreprocessor;

public class App {
    public static void main(String[] args) {
        int playRounds = 3;
        GameStorage gameStorage = new GameStorage();

        Cli.showInitMessage();
        Cli.showAvailableChoices(gameStorage.getGames());

        int selectedGameId = Cli.selectGame();

        if (gameStorage.getExitId().equals(selectedGameId)) {
            Cli.closeInteraction();
            return;
        } else {
            Cli.showWelcomeLetter();
            ((GamePreprocessor) gameStorage.getGreeting()).greet();
            if (gameStorage.getGreetingId().equals(selectedGameId)) {
                Cli.closeInteraction();
                return;
            }
        }

        Game game = gameStorage.getGameById(selectedGameId);
        Cli.showPreInteractionMessageToUser(game.getRules());
        Engine engine = new Engine(playRounds);
        engine.start(game);
        Cli.showEndMessage(Greeting.congratulation());
        Cli.closeInteraction();
    }
}
