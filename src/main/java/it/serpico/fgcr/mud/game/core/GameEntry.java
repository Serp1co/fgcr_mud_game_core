package it.serpico.fgcr.mud.game.core;

import it.serpico.fgcr.mud.game.core.npc.FriendlyNpc;
import it.serpico.fgcr.mud.game.core.player.Player;
import it.serpico.fgcr.mud.game.core.rooms.EncounterRoom;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameEntry {
    protected final static Logger log = Logger.getLogger(GameEntry.class.getName());

    private static int rounds = 0;

    public String main(String... args) {
        for (int x = 0; x < 5; x++)
            new GameLoop() {
                @Override
                protected void processGameLoop() {
                    log.log(Level.INFO, "Thread: {0}", Thread.currentThread());
                    while (isGameRunning()) {
                        log.log(Level.INFO, "Am i alive? {0}", Player.bIAmAlive());
                        gameController.resolveEncounter(new EncounterRoom("Test Encounter Room", new FriendlyNpc("Amico delle guardie")));
                        stop();
                    }
                }
            }.run();
        return "";
    }

}
