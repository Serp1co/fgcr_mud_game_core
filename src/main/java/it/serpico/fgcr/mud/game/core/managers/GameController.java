package it.serpico.fgcr.mud.game.core.managers;

import it.serpico.fgcr.mud.game.core.rooms.EncounterRoom;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameController {

    protected final static Logger log = Logger.getLogger(GameController.class.getName());

    public void resolveEncounter(EncounterRoom room) {
        log.log(Level.INFO, room.encounter());
    }

}
