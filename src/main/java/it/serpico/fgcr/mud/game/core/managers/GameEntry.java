package it.serpico.fgcr.mud.game.core.managers;

import java.util.logging.Logger;

public class GameEntry {
    protected final static Logger log = Logger.getLogger(GameEntry.class.getName());

    private static int rounds = 0;

    public static void main(String... args) {
        String uid = "firstGameLoop";
        GameLoopManager.startGameLoop(uid);
        GameLoopManager.stopGameLoop(GameLoopManager.gameLoopsCache.getGameLoopByUId(uid));
    }

}
