package it.serpico.fgcr.mud.game.core;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameEntry {
    protected final static Logger log = Logger.getLogger(GameEntry.class.getName());

    private static int rounds = 0;

    private static GameSession gameSession = new GameSession();

    public static void main(String... args) {
        log.log(Level.INFO, "Map start: {0}", gameSession.gameLoopConcurrentHashMap.size());
        List<String> gameSessionInProgress = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            gameSessionInProgress.add(gameSession.startGameSession().getuId());
            log.log(Level.INFO, "Map add: {0}", gameSession.gameLoopConcurrentHashMap.size());
        }
        gameSessionInProgress.forEach(a -> {
            gameSession.stopGameSession(a);
            log.log(Level.INFO, "Map remove: {0}", gameSession.gameLoopConcurrentHashMap.size());
        });
        log.log(Level.INFO, "Map end: {0}", gameSession.gameLoopConcurrentHashMap.size());
    }

}
