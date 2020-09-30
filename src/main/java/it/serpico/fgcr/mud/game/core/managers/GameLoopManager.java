package it.serpico.fgcr.mud.game.core.managers;

import it.serpico.fgcr.mud.game.core.npc.FriendlyNpc;
import it.serpico.fgcr.mud.game.core.rooms.EncounterRoom;

import java.util.logging.Level;

public class GameLoopManager  {
    private static GameLoopManager instance;
    private GameLoopManager() {}
    public static GameLoopManager getInstance()
    {
        if (instance == null)
        {
            //synchronized block to remove overhead
            synchronized (GameLoopManager.class)
            {
                if(instance==null)
                {
                    // if instance is null, initialize
                    instance = new GameLoopManager();
                }
            }
        }
        return instance;
    }

    public static GameLoopsCache gameLoopsCache = new GameLoopsCache();

    public static void startGameLoop(String gameLoopUId) {
        GameLoop gameLoop = new GameLoop(gameLoopUId) {
            @Override
            protected void processGameLoop() {
                log.log(Level.INFO, "Thread: {0}", Thread.currentThread());
                while (isGameRunning()) {
                    gameController.resolveEncounter(new EncounterRoom("Test Encounter Room", new FriendlyNpc("Amico delle guardie")));
                }
            }
        };
        gameLoop.run();
        gameLoopsCache.addGameLoop(gameLoop);
    }

    public static void stopGameLoop(GameLoop gameLoop) {
        gameLoop.stop();
        gameLoopsCache.removeGameLoop(gameLoop);
    }

}
