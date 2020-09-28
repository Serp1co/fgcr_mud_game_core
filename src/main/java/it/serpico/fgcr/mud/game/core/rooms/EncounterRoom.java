package it.serpico.fgcr.mud.game.core.rooms;

import it.serpico.fgcr.mud.game.core.npc.EnemyNpc;
import it.serpico.fgcr.mud.game.core.npc.FriendlyNpc;
import it.serpico.fgcr.mud.game.core.npc.Npc;

public class EncounterRoom extends Room {

    public Npc npc;

    public EncounterRoom(String name, Npc npc, Room... locations) {
        super(name, locations);
        this.npc = npc;
    }

    public Npc getNpc() {
        return npc;
    }

    public void setNpc(Npc npc) {
        this.npc = npc;
    }

    public String encounter() {
        StringBuilder encounterMessage = new StringBuilder();
        encounterMessage.append(this.npc.hiIAm());
        if(this.npc instanceof FriendlyNpc) {
            encounterMessage.append(((FriendlyNpc)npc).sayMessage());
        }
        else if (this.npc instanceof EnemyNpc) {

        }
        return encounterMessage.toString();
    }

}
