package it.serpico.fgcr.mud.game.core.managers;

import java.util.concurrent.ConcurrentHashMap;

public class GameLoopsCache extends ConcurrentHashMap<String, GameLoop> {

    protected void addGameLoop(GameLoop gameLoop) {
        this.put(gameLoop.getUId(), gameLoop);
    }

    protected void removeGameLoop(GameLoop gameLoop) {
        this.remove(gameLoop.getUId(), gameLoop);
    }

    public GameLoop getGameLoopByUId(String UId) {
        return this.get(UId);
    }

}
