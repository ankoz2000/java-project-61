package hexlet.code;

import hexlet.code.games.GCD;
import hexlet.code.games.Exit;
import hexlet.code.games.Even;
import hexlet.code.games.Prime;
import hexlet.code.games.Greeting;
import hexlet.code.interfaces.Game;
import hexlet.code.games.Calculator;
import hexlet.code.games.Progression;

public final class GameStorage {
    private final int exitId = 0;

    private final Game[] games = {
        new Prime(),
        new Progression(),
        new GCD(),
        new Calculator(),
        new Even(),
        new Greeting(),
        new Exit()
    };

    public Game getGameById(int id) {
        int offset = 1;
        return games[id == exitId ? exitId : games.length - offset - id];
    }

    public Game getGreeting() {
        int offset = 2;
        return games[games.length - offset];
    }

    public Integer getGreetingId() {
        return 1;
    }

    public Integer getExitId() {
        return exitId;
    }

    public Game[] getGames() {
        return games;
    }
}
