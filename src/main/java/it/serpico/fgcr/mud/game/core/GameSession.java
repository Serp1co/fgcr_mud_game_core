package it.serpico.fgcr.mud.game.core;

import it.serpico.fgcr.mud.game.core.npc.FriendlyNpc;
import it.serpico.fgcr.mud.game.core.player.Player;
import it.serpico.fgcr.mud.game.core.rooms.EncounterRoom;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

public class GameSession {

    protected final ConcurrentHashMap<String, GameLoop> gameLoopConcurrentHashMap = new ConcurrentHashMap<>();

    protected void addGameLoop(GameLoop gameLoop) {
        this.gameLoopConcurrentHashMap.put(gameLoop.getuId(), gameLoop);
    }

    protected void removeGameLoop(GameLoop gameLoop) {
        this.gameLoopConcurrentHashMap.remove(gameLoop.getuId(), gameLoop);
    }

    public GameLoop getGameLoopByUId(String UId) {
        return this.gameLoopConcurrentHashMap.get(UId);
    }

    public GameLoop startGameSession() {
        GameLoop gameLoop = new GameLoop(UUID.randomUUID().toString()) {
            @Override
            protected void processGameLoop() {
                log.log(Level.INFO, "Thread: {0}", Thread.currentThread());
                while (isGameRunning()) {
                    log.log(Level.INFO, "Thread: {0} / Am i alive? {1}", new String[]{Thread.currentThread().toString(), "" + Player.bIAmAlive()});
                    gameController.resolveEncounter(new EncounterRoom("Test Encounter Room", new FriendlyNpc("Amico delle guardie")));
                    log.log(Level.INFO, "Thread: {0} / Am i alive? {1}", new String[]{Thread.currentThread().toString(), "" + false});
                }
            }
        };
        addGameLoop(gameLoop);
        gameLoop.run();
        return gameLoop;
    }

    public void stopGameSession(String gameSessionUId) {
        GameLoop gameLoop = getGameLoopByUId(gameSessionUId);
        gameLoop.stop();
        removeGameLoop(gameLoop);
    }

}
